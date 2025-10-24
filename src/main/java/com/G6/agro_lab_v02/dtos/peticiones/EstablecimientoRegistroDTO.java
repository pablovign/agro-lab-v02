package com.G6.agro_lab_v02.dtos.peticiones;

import jakarta.validation.constraints.*;

import java.util.List;

public class EstablecimientoRegistroDTO {
    @NotBlank(message = "El nombre del establecimiento no puede estar vacío.")
    @Size(max = 25, message = "El nombre del establecimiento no puede exceder los 25 caracteres.")
    private String nombreEstablecimiento;

    @NotBlank(message = "La calle no puede estar vacía.")
    @Size(max = 25, message = "La calle no puede exceder los 25 caracteres.")
    private String calle;

    @NotBlank(message = "La numeración no puede estar vacía.")
    @Size(max = 5, message = "La numeración no puede exceder los 5 caracteres.")
    private String numeracion;

    @NotBlank(message = "El código postal no puede estar vacío.")
    @Size(max = 4, message = "El código postal debe tener 4 caracteres.")
    private String codigoPostal;

    @NotNull(message = "La latitud es obligatoria.")
    @DecimalMin(value = "-90.0", message = "La latitud mínima es -90.")
    @DecimalMax(value = "90.0", message = "La latitud máxima es 90.")
    private Double latitud;

    @NotNull(message = "La longitud es obligatoria.")
    @DecimalMin(value = "-180.0", message = "La longitud mínima es -180.")
    @DecimalMax(value = "180.0", message = "La longitud máxima es 180.")
    private Double longitud;

    @NotNull(message = "Debe seleccionar un distrito.")
    private Integer idDistrito;

    @NotEmpty(message = "Debe seleccionar al menos una especie.")
    private List<Integer> idsEspecies;

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

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }

    public List<Integer> getIdsEspecies() {
        return idsEspecies;
    }

    public void setIdsEspecies(List<Integer> idsEspecies) {
        this.idsEspecies = idsEspecies;
    }
}
