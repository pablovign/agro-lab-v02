package com.G6.agro_lab_v02.dtos.peticiones;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmpresaRegistroDTO {
    @NotBlank(message = "El CUIT no puede estar vacío.")
    @Size(min = 11, max = 11, message = "El CUIT debe tener 11 dígitos.")
    @Pattern(regexp = "\\d{11}", message = "El CUIT solo debe contener números.")
    private String cuit;

    @NotBlank(message = "La razón social es obligatoria.")
    @Size(max = 255, message = "La razón social no puede exceder los 255 caracteres.")
    private String razonSocial;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres.")
    private String contrasenia;

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
