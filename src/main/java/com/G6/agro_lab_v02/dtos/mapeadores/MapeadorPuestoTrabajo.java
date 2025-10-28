package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.respuestas.PuestoTrabajoRespuestaDTO;
import com.G6.agro_lab_v02.entidades.PuestoTrabajo;

public class MapeadorPuestoTrabajo {

    public static PuestoTrabajoRespuestaDTO toDto(PuestoTrabajo puestoTrabajo){
        if(puestoTrabajo == null){
            return null;
        }

        return new PuestoTrabajoRespuestaDTO(puestoTrabajo.getIdPuestoTrabajo(), puestoTrabajo.getNombrePuestoTrabajo());
    }
}
