package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.respuestas.EspecieRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Especie;

public class MapeadorEspecie {

    public static EspecieRespuestaDTO toDto(Especie especie){
        if(especie == null){
            return null;
        }

        return new EspecieRespuestaDTO(especie.getIdEspecie(), especie.getNombreEspecie());
    }
}
