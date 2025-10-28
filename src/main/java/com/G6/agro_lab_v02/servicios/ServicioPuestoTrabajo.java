package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorPuestoTrabajo;
import com.G6.agro_lab_v02.dtos.respuestas.PuestoTrabajoRespuestaDTO;
import com.G6.agro_lab_v02.repositorios.RepositorioPuestoTrabajo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPuestoTrabajo {
    private final RepositorioPuestoTrabajo repositorioPuestoTrabajo;

    @Autowired
    public ServicioPuestoTrabajo(RepositorioPuestoTrabajo repositorioPuestoTrabajo){
        this.repositorioPuestoTrabajo = repositorioPuestoTrabajo;
    }

    public List<PuestoTrabajoRespuestaDTO> obtenerPuestosTrabajo(){
        return repositorioPuestoTrabajo.findAll()
                .stream()
                .map(MapeadorPuestoTrabajo::toDto)
                .toList();
    }
}
