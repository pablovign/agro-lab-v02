package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.peticiones.EmpresaRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.EmpresaRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Empresa;

public class MapeadorEmpresa {

    public static Empresa toEntity(EmpresaRegistroDTO dto) {
        Empresa empresa = new Empresa();
        empresa.setCuit(dto.getCuit());
        empresa.setRazonSocial(dto.getRazonSocial());
        empresa.setContrasenia(dto.getContrasenia());
        return empresa;
    }

    public static EmpresaRespuestaDTO toDTO(Empresa entity) {
        EmpresaRespuestaDTO dto = new EmpresaRespuestaDTO();
        dto.setIdEmpresa(entity.getIdEmpresa());
        dto.setCuit(entity.getCuit());
        dto.setRazonSocial(entity.getRazonSocial());
        dto.setFechaAlta(entity.getFechaAlta());
        return dto;
    }
}
