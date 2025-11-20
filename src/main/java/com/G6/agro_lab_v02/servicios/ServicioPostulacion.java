package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorPostulacion;
import com.G6.agro_lab_v02.dtos.peticiones.PostulacionRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.PostulacionRespuestaDTO;
import com.G6.agro_lab_v02.entidades.OfertaEmpleo;
import com.G6.agro_lab_v02.entidades.OfertaEmpleoPersona;
import com.G6.agro_lab_v02.entidades.Persona;
import com.G6.agro_lab_v02.excepciones.IllegalStateBusinessException;
import com.G6.agro_lab_v02.excepciones.ResourceNotFoundException;
import com.G6.agro_lab_v02.excepciones.UnauthorizedException;
import com.G6.agro_lab_v02.repositorios.RepositorioOfertaEmpleo;
import com.G6.agro_lab_v02.repositorios.RepositorioOfertaEmpleoPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioPostulacion {
    private final RepositorioOfertaEmpleoPersona repositorioPostulacion;
    private final RepositorioOfertaEmpleo repositorioOfertaEmpleo;
    private final ServicioPersona servicioPersona;

    @Autowired
    public ServicioPostulacion(RepositorioOfertaEmpleoPersona repositorioPostulacion,
                               RepositorioOfertaEmpleo repositorioOfertaEmpleo,
                               ServicioPersona servicioPersona) {
        this.repositorioPostulacion = repositorioPostulacion;
        this.repositorioOfertaEmpleo = repositorioOfertaEmpleo;
        this.servicioPersona = servicioPersona;
    }

    @Transactional
    public void registrar(PostulacionRegistroDTO dto) {
        Persona persona = servicioPersona.obtenerOCrear(dto.getPersona());

        OfertaEmpleo oferta = repositorioOfertaEmpleo.findById(dto.getIdOfertaEmpleo())
                .orElseThrow(() -> new ResourceNotFoundException("Oferta no encontrada"));

        if (Boolean.FALSE.equals(oferta.getVigente())) {
            throw new IllegalStateException("No se puede postular a una oferta no vigente.");
        }

        LocalDate hoy = LocalDate.now();
        if (oferta.getFechaCierre() != null && oferta.getFechaCierre().isBefore(hoy)) {
            throw new IllegalStateException("La oferta ya está vencida.");
        }

        boolean yaPostulado = repositorioPostulacion
                .existsByPersonaAndOfertaEmpleo(persona, oferta);

        if (yaPostulado) {
            throw new IllegalStateBusinessException("La persona ya se postuló a esta oferta.");
        }

        OfertaEmpleoPersona postulacion = new OfertaEmpleoPersona();
        postulacion.setPersona(persona);
        postulacion.setOfertaEmpleo(oferta);
        postulacion.setFechaAlta(LocalDateTime.now());

        repositorioPostulacion.save(postulacion);
    }

    @Transactional(readOnly = true)
    public List<PostulacionRespuestaDTO> obtenerPostulacionesPorOferta(Integer idOfertaEmpleo) {
        OfertaEmpleo oferta = repositorioOfertaEmpleo.findById(idOfertaEmpleo)
                .orElseThrow(() -> new ResourceNotFoundException("Oferta de empleo no encontrada."));

        return repositorioPostulacion.findByOfertaEmpleo(oferta)
                .stream()
                .map(MapeadorPostulacion::toDto)
                .toList();
    }

    public void darDeBaja(Integer id, String cuitEmpresa) {
        OfertaEmpleo oferta = repositorioOfertaEmpleo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oferta no encontrada."));

        if (!oferta.getEstablecimiento().getEmpresa().getCuit().equals(cuitEmpresa)) {
            throw new UnauthorizedException("No se pueden modificar ofertas de otra empresa.");
        }

        oferta.setVigente(false);

        repositorioOfertaEmpleo.save(oferta);
    }
}
