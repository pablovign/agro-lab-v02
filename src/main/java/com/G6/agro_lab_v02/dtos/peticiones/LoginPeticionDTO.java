package com.G6.agro_lab_v02.dtos.peticiones;

public class LoginPeticionDTO {
    private String cuit;
    private String contrasenia;

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
