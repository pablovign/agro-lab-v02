package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorOfertaEmpleo;
import com.G6.agro_lab_v02.dtos.peticiones.OfertaEmpleoRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.OfertaEmpleoRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Especie;
import com.G6.agro_lab_v02.entidades.Establecimiento;
import com.G6.agro_lab_v02.entidades.OfertaEmpleo;
import com.G6.agro_lab_v02.entidades.PuestoTrabajo;
import com.G6.agro_lab_v02.excepciones.ResourceNotFoundException;
import com.G6.agro_lab_v02.repositorios.RepositorioEspecie;
import com.G6.agro_lab_v02.repositorios.RepositorioEstablecimiento;
import com.G6.agro_lab_v02.repositorios.RepositorioOfertaEmpleo;
import com.G6.agro_lab_v02.repositorios.RepositorioPuestoTrabajo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioOfertaEmpleo {
    private final RepositorioOfertaEmpleo repositorioOfertaEmpleo;
    private final RepositorioEstablecimiento repositorioEstablecimiento;
    private final RepositorioPuestoTrabajo repositorioPuestoTrabajo;
    private final RepositorioEspecie repositorioEspecie;

    public ServicioOfertaEmpleo(RepositorioOfertaEmpleo repositorioOfertaEmpleo,
                                RepositorioEstablecimiento repositorioEstablecimiento,
                                RepositorioPuestoTrabajo repositorioPuestoTrabajo,
                                RepositorioEspecie repositorioEspecie) {
        this.repositorioOfertaEmpleo = repositorioOfertaEmpleo;
        this.repositorioEstablecimiento = repositorioEstablecimiento;
        this.repositorioPuestoTrabajo = repositorioPuestoTrabajo;
        this.repositorioEspecie = repositorioEspecie;
    }

    @Transactional
    public OfertaEmpleoRespuestaDTO registrarOferta(OfertaEmpleoRegistroDTO dto) {
        Establecimiento establecimiento = repositorioEstablecimiento.findById(dto.getIdEstablecimiento())
                .orElseThrow(() -> new ResourceNotFoundException("Establecimiento no encontrado."));

        PuestoTrabajo puesto = repositorioPuestoTrabajo.findById(dto.getIdPuestoTrabajo())
                .orElseThrow(() -> new ResourceNotFoundException("Puesto de trabajo no encontrado."));

        Especie especie = null;
        if (dto.getIdEspecie() != null) {
            especie = repositorioEspecie.findById(dto.getIdEspecie())
                    .orElseThrow(() -> new ResourceNotFoundException("Especie no encontrada."));
        }

        OfertaEmpleo oferta = MapeadorOfertaEmpleo.toEntity(dto, establecimiento, puesto, especie);
        OfertaEmpleo guardada = repositorioOfertaEmpleo.save(oferta);

        return MapeadorOfertaEmpleo.toDto(guardada);
    }
}
