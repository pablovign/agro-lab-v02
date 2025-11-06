package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorOfertaEmpleoPriv;
import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorOfertaEmpleoPub;
import com.G6.agro_lab_v02.dtos.peticiones.OfertaEmpleoRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.OfertaEmpleoRespuestaPrivDTO;
import com.G6.agro_lab_v02.dtos.respuestas.OfertaEmpleoRespuestaPubDTO;
import com.G6.agro_lab_v02.entidades.*;
import com.G6.agro_lab_v02.excepciones.ResourceNotFoundException;
import com.G6.agro_lab_v02.repositorios.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioOfertaEmpleo {
    private final RepositorioOfertaEmpleo repositorioOfertaEmpleo;
    private final RepositorioEstablecimiento repositorioEstablecimiento;
    private final RepositorioPuestoTrabajo repositorioPuestoTrabajo;
    private final RepositorioEspecie repositorioEspecie;
    private final RepositorioEmpresa repositorioEmpresa;

    public ServicioOfertaEmpleo(RepositorioOfertaEmpleo repositorioOfertaEmpleo, RepositorioEstablecimiento repositorioEstablecimiento,
                                RepositorioPuestoTrabajo repositorioPuestoTrabajo, RepositorioEspecie repositorioEspecie,
                                RepositorioEmpresa repositorioEmpresa) {
        this.repositorioOfertaEmpleo = repositorioOfertaEmpleo;
        this.repositorioEstablecimiento = repositorioEstablecimiento;
        this.repositorioPuestoTrabajo = repositorioPuestoTrabajo;
        this.repositorioEspecie = repositorioEspecie;
        this.repositorioEmpresa = repositorioEmpresa;
    }

    @Transactional
    public OfertaEmpleoRespuestaPrivDTO registrarOferta(OfertaEmpleoRegistroDTO dto) {
        Establecimiento establecimiento = repositorioEstablecimiento.findById(dto.getIdEstablecimiento())
                .orElseThrow(() -> new ResourceNotFoundException("Establecimiento no encontrado."));

        PuestoTrabajo puesto = repositorioPuestoTrabajo.findById(dto.getIdPuestoTrabajo())
                .orElseThrow(() -> new ResourceNotFoundException("Puesto de trabajo no encontrado."));

        Especie especie = null;
        if (dto.getIdEspecie() != null) {
            especie = repositorioEspecie.findById(dto.getIdEspecie())
                    .orElseThrow(() -> new ResourceNotFoundException("Especie no encontrada."));
        }

        OfertaEmpleo oferta = MapeadorOfertaEmpleoPriv.toEntity(dto, establecimiento, puesto, especie);
        OfertaEmpleo guardada = repositorioOfertaEmpleo.save(oferta);

        return MapeadorOfertaEmpleoPriv.toDto(guardada);
    }

    @Transactional
    public List<OfertaEmpleoRespuestaPrivDTO> listarPorEmpresa(String cuit, Boolean vigente) {
        actualizarVigenciaAutomatica();

        Empresa empresa = repositorioEmpresa.findByCuit(cuit)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada."));

        List<OfertaEmpleo> ofertas;

        if(Boolean.TRUE.equals(vigente)){
            ofertas = repositorioOfertaEmpleo.findByEstablecimiento_EmpresaAndVigenteTrue(empresa);
        }
        else{
            ofertas = repositorioOfertaEmpleo.findByEstablecimiento_Empresa(empresa);
        }

        return ofertas.stream()
                .map(MapeadorOfertaEmpleoPriv::toDto)
                .toList();
    }

    @Transactional
    public List<OfertaEmpleoRespuestaPubDTO> listarVigentesFiltradas(String puesto, String orden, Double lat, Double lon) {
        actualizarVigenciaAutomatica();

        List<OfertaEmpleo> ofertas;

        if ("distancia".equalsIgnoreCase(orden) && lat != null && lon != null) {
            ofertas = repositorioOfertaEmpleo.findVigentesOrderByDistancia(lat, lon);
        } else {
            ofertas = repositorioOfertaEmpleo.findByVigenteTrueOrderByFechaCierreAsc();
        }

        if (puesto != null && !puesto.isBlank()) {
            ofertas = ofertas.stream()
                    .filter(o -> o.getPuestoTrabajo().getNombrePuestoTrabajo().equalsIgnoreCase(puesto))
                    .toList();
        }

        return ofertas.stream()
                .map(MapeadorOfertaEmpleoPub::toDto)
                .toList();
    }

    @Transactional
    public void actualizarVigenciaAutomatica() {
        LocalDate hoy = LocalDate.now();
        List<OfertaEmpleo> ofertasVigentes = repositorioOfertaEmpleo.findByVigenteTrue();

        boolean hayCambios = false;
        for (OfertaEmpleo oferta : ofertasVigentes) {
            if (oferta.getFechaCierre() != null && oferta.getFechaCierre().isBefore(hoy)) {
                oferta.setVigente(false);
                hayCambios = true;
            }
        }

        if (hayCambios) {
            repositorioOfertaEmpleo.saveAll(ofertasVigentes);
        }
    }
}
