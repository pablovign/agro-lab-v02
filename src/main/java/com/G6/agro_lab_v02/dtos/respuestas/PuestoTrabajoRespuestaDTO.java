package com.G6.agro_lab_v02.dtos.respuestas;

public class PuestoTrabajoRespuestaDTO {
    private Integer idPuestoTrabajo;
    private String nombrePuestoTrabajo;

    public PuestoTrabajoRespuestaDTO(Integer idPuestoTrabajo, String nombrePuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
    }

    public Integer getIdPuestoTrabajo() {
        return idPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(Integer idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    public String getNombrePuestoTrabajo() {
        return nombrePuestoTrabajo;
    }

    public void setNombrePuestoTrabajo(String nombrePuestoTrabajo) {
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
    }
}
