package com.G6.agro_lab_v02.dtos.peticiones;

import jakarta.validation.constraints.Size;

public class EmpresaEdicionDTO {
    @Size(max = 255, message = "La razón social no puede exceder los 255 caracteres.")
    private String razonSocial;

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}
