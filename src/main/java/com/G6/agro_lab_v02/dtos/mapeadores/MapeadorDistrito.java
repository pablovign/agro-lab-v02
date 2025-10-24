package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.respuestas.DistritoRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Distrito;

public class MapeadorDistrito {

    public static DistritoRespuestaDTO toDto(Distrito distrito){
        if(distrito == null){
            return null;
        }

        return new DistritoRespuestaDTO(distrito.getIdDistrito(), distrito.getNombreDistrito());
    }
}
