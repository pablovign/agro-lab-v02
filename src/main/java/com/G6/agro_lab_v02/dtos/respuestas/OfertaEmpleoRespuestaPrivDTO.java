package com.G6.agro_lab_v02.dtos.respuestas;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OfertaEmpleoRespuestaPrivDTO {
    private Integer idOfertaEmpleo;
    private String nombrePuesto;
    private String nombreEstablecimiento;
    private String nombreEspecie;
    private Integer vacantes;
    private Boolean vigente;
    private LocalDateTime fechaAlta;
    private LocalDate fechaCierre;

    public OfertaEmpleoRespuestaPrivDTO(Integer idOfertaEmpleo, String nombrePuesto, String nombreEstablecimiento,
                                        String nombreEspecie, Integer vacantes, Boolean vigente,
                                        LocalDateTime fechaAlta, LocalDate fechaCierre) {
        this.idOfertaEmpleo = idOfertaEmpleo;
        this.nombrePuesto = nombrePuesto;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.nombreEspecie = nombreEspecie;
        this.vacantes = vacantes;
        this.vigente = vigente;
        this.fechaAlta = fechaAlta;
        this.fechaCierre = fechaCierre;
    }

    public Integer getIdOfertaEmpleo() {
        return idOfertaEmpleo;
    }

    public void setIdOfertaEmpleo(Integer idOfertaEmpleo) {
        this.idOfertaEmpleo = idOfertaEmpleo;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public Integer getVacantes() {
        return vacantes;
    }

    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
