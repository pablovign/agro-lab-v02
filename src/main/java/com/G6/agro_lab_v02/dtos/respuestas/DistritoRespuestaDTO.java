package com.G6.agro_lab_v02.dtos.respuestas;

public class DistritoRespuestaDTO {
    private Integer idDistrito;
    private String nombreDistrito;

    public DistritoRespuestaDTO(Integer idDistrito, String nombreDistrito) {
        this.idDistrito = idDistrito;
        this.nombreDistrito = nombreDistrito;
    }

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }
}
