package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.respuestas.OfertaEmpleoRespuestaPubDTO;
import com.G6.agro_lab_v02.entidades.OfertaEmpleo;

public class MapeadorOfertaEmpleoPub {

    public static OfertaEmpleoRespuestaPubDTO toDto(OfertaEmpleo oferta) {
        double lat = oferta.getEstablecimiento().getUbicacion().getY(); // Y = latitud
        double lon = oferta.getEstablecimiento().getUbicacion().getX(); // X = longitud

        return new OfertaEmpleoRespuestaPubDTO(
                oferta.getIdOfertaEmpleo(),
                oferta.getEstablecimiento().getNombreEstablecimiento(),
                oferta.getPuestoTrabajo().getNombrePuestoTrabajo(),
                oferta.getEspecie() != null ? oferta.getEspecie().getNombreEspecie() : null,
                oferta.getVacantes(),
                oferta.getFechaCierre(),
                lat,
                lon
        );
    }
}
