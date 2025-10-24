package com.G6.agro_lab_v02.dtos.respuestas;

import java.util.List;

public class EstablecimientoRespuestaDTO {
    private Integer idEstablecimiento;
    private String nombreEstablecimiento;
    private String calle;
    private String numeracion;
    private String codigoPostal;
    private String nombreDistrito;
    private String nombreDepartamento;
    private List<String> especies;

    public EstablecimientoRespuestaDTO(Integer idEstablecimiento, String nombreEstablecimiento, String calle, String numeracion,
                                       String codigoPostal, String nombreDistrito, String nombreDepartamento, List<String> especies) {
        this.idEstablecimiento = idEstablecimiento;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.calle = calle;
        this.numeracion = numeracion;
        this.codigoPostal = codigoPostal;
        this.nombreDistrito = nombreDistrito;
        this.nombreDepartamento = nombreDepartamento;
        this.especies = especies;
    }

    public Integer getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public List<String> getEspecies() {
        return especies;
    }

    public void setEspecies(List<String> especies) {
        this.especies = especies;
    }
}
