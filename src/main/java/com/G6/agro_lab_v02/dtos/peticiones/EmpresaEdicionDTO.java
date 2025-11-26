package com.G6.agro_lab_v02.dtos.peticiones;

import jakarta.validation.constraints.Size;

public class EmpresaEdicionDTO {
    @Size(max = 255, message = "La razón social no puede exceder los 255 caracteres.")
    private String razonSocial;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres.")
    private String contrasenia;

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
