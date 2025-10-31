package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.respuestas.OfertaEmpleoRespuestaPubDTO;
import com.G6.agro_lab_v02.entidades.OfertaEmpleo;

public class MapeadorOfertaEmpleoPub {

    public static OfertaEmpleoRespuestaPubDTO toDto(OfertaEmpleo oferta) {
        return new OfertaEmpleoRespuestaPubDTO(oferta.getIdOfertaEmpleo(), oferta.getEstablecimiento().getNombreEstablecimiento(),
                oferta.getPuestoTrabajo().getNombrePuestoTrabajo(),
                oferta.getEspecie() != null ? oferta.getEspecie().getNombreEspecie() : null, oferta.getFechaCierre(), oferta.getVacantes(),
                oferta.getEstablecimiento().getUbicacion().getY(), oferta.getEstablecimiento().getUbicacion().getX()
        );
    }
}
