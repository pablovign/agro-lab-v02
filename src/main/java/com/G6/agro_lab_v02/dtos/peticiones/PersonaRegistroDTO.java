package com.G6.agro_lab_v02.dtos.peticiones;

import jakarta.validation.constraints.*;

public class PersonaRegistroDTO {
    @NotBlank(message = "El DNI no puede estar vacío")
    @Size(min = 7, max = 8, message = "El DNI debe tener entre 7 y 8 dígitos.")
    private String dni;

    @NotBlank(message = "El apellido no puede estar vacío.")
    @Size(max = 25, message = "El apellido no puede exceder los 25 caracteres.")
    private String apellido;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 25, message = "El nombre no puede exceder los 25 caracteres.")
    private String nombre;

    @NotBlank(message = "La calle es obligatoria.")
    @Size(max = 25, message = "El nombre de la calle no puede exceder los 25 caracteres.")
    private String calle;

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

    @NotBlank(message = "El teléfono no puede estar vacío.")
    @Size(max = 20)
    private String telefono;

    @NotNull(message = "Debe seleccionar un distrito.")
    private Integer idDistrito;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Integer idDistrito) {
        this.idDistrito = idDistrito;
    }
}
