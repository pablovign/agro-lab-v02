package com.G6.agro_lab_v02.dtos.respuestas;

import java.time.LocalDate;

public class OfertaEmpleoRespuestaPubDTO {
    private Integer idOfertaEmpleo;
    private String nombreEstablecimiento;
    private String nombrePuestoTrabajo;
    private String nombreEspecie;
    private Integer vacantes;
    private LocalDate fechaCierre;
    private double latitud;
    private double longitud;

    public OfertaEmpleoRespuestaPubDTO(Integer idOfertaEmpleo,
                                       String nombreEstablecimiento,
                                       String nombrePuestoTrabajo,
                                       String nombreEspecie,
                                       Integer vacantes,
                                       LocalDate fechaCierre,
                                       double latitud,
                                       double longitud) {
        this.idOfertaEmpleo = idOfertaEmpleo;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
        this.nombreEspecie = nombreEspecie;
        this.vacantes = vacantes;
        this.fechaCierre = fechaCierre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Integer getIdOfertaEmpleo() {
        return idOfertaEmpleo;
    }

    public void setIdOfertaEmpleo(Integer idOfertaEmpleo) {
        this.idOfertaEmpleo = idOfertaEmpleo;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getNombrePuestoTrabajo() {
        return nombrePuestoTrabajo;
    }

    public void setNombrePuestoTrabajo(String nombrePuestoTrabajo) {
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
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

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
