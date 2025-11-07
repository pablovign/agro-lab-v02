package com.G6.agro_lab_v02.dtos.respuestas;

import java.time.LocalDateTime;

public class PostulacionRespuestaDTO {
    private PersonaRespuestaDTO persona;
    private LocalDateTime fechaPostulacion;

    public PostulacionRespuestaDTO() {}

    public PostulacionRespuestaDTO(PersonaRespuestaDTO persona, LocalDateTime fechaPostulacion) {
        this.persona = persona;
        this.fechaPostulacion = fechaPostulacion;
    }

    public PersonaRespuestaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaRespuestaDTO persona) {
        this.persona = persona;
    }

    public LocalDateTime getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(LocalDateTime fechaPostulacion) {
        this.fechaPostulacion = fechaPostulacion;
    }
}
