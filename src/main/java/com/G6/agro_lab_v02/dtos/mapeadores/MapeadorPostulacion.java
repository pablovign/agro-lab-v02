package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.respuestas.PersonaRespuestaDTO;
import com.G6.agro_lab_v02.dtos.respuestas.PostulacionRespuestaDTO;
import com.G6.agro_lab_v02.entidades.OfertaEmpleoPersona;

public class MapeadorPostulacion {

    public static PostulacionRespuestaDTO toDto(OfertaEmpleoPersona postulacion){
        PostulacionRespuestaDTO postulacionDto = new PostulacionRespuestaDTO();
        PersonaRespuestaDTO personaDto = MapeadorPersona.toDto(postulacion.getPersona());

        postulacionDto.setFechaPostulacion(postulacion.getFechaAlta());
        postulacionDto.setPersona(personaDto);

        return postulacionDto;
    }
}
