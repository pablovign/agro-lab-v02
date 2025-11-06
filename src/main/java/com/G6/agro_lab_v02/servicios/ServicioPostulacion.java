package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.peticiones.PostulacionRegistroDTO;
import com.G6.agro_lab_v02.entidades.OfertaEmpleo;
import com.G6.agro_lab_v02.entidades.OfertaEmpleoPersona;
import com.G6.agro_lab_v02.entidades.Persona;
import com.G6.agro_lab_v02.excepciones.ResourceNotFoundException;
import com.G6.agro_lab_v02.repositorios.RepositorioOfertaEmpleo;
import com.G6.agro_lab_v02.repositorios.RepositorioOfertaEmpleoPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

        OfertaEmpleoPersona postulacion = new OfertaEmpleoPersona();
        postulacion.setPersona(persona);
        postulacion.setOfertaEmpleo(oferta);
        postulacion.setFechaAlta(LocalDateTime.now());

        repositorioPostulacion.save(postulacion);
    }
}
