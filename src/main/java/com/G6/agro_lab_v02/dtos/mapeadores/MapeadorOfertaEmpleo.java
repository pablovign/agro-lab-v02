package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.peticiones.OfertaEmpleoRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.OfertaEmpleoRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Especie;
import com.G6.agro_lab_v02.entidades.Establecimiento;
import com.G6.agro_lab_v02.entidades.OfertaEmpleo;
import com.G6.agro_lab_v02.entidades.PuestoTrabajo;

public class MapeadorOfertaEmpleo {
    public static OfertaEmpleo toEntity(OfertaEmpleoRegistroDTO dto,
                                        Establecimiento establecimiento,
                                        PuestoTrabajo puestoTrabajo,
                                        Especie especie) {

        OfertaEmpleo oferta = new OfertaEmpleo();
        oferta.setEstablecimiento(establecimiento);
        oferta.setPuestoTrabajo(puestoTrabajo);
        oferta.setEspecie(especie);
        oferta.setVacantes(dto.getVacantes());
        oferta.setFechaCierre(dto.getFechaCierre());
        oferta.setVigente(true);
        return oferta;
    }

    public static OfertaEmpleoRespuestaDTO toDto(OfertaEmpleo oferta) {
        return new OfertaEmpleoRespuestaDTO(
                oferta.getIdOfertaEmpleo(),
                oferta.getPuestoTrabajo().getNombrePuestoTrabajo(),
                oferta.getEstablecimiento().getNombreEstablecimiento(),
                oferta.getEspecie() != null ? oferta.getEspecie().getNombreEspecie() : null,
                oferta.getVacantes(),
                oferta.getVigente(),
                oferta.getFechaAlta(),
                oferta.getFechaCierre()
        );
    }
}
