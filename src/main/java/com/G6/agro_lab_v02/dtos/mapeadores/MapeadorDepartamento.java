package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.respuestas.DepartamentoRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Departamento;

public class MapeadorDepartamento {

    public static DepartamentoRespuestaDTO toDto(Departamento departamento){
        if(departamento == null){
            return null;
        }

        return new DepartamentoRespuestaDTO(departamento.getIdDepartamento(), departamento.getNombreDepartamento());
    }
}
