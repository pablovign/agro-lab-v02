package com.G6.agro_lab_v02.dtos.peticiones;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class PostulacionRegistroDTO {
    @Valid
    @NotNull
    private PersonaRegistroDTO persona;

    @NotNull
    private Integer idOfertaEmpleo;

    public PersonaRegistroDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaRegistroDTO persona) {
        this.persona = persona;
    }

    public Integer getIdOfertaEmpleo() {
        return idOfertaEmpleo;
    }

    public void setIdOfertaEmpleo(Integer idOfertaEmpleo) {
        this.idOfertaEmpleo = idOfertaEmpleo;
    }
}
