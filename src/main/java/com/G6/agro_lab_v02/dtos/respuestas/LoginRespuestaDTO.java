package com.G6.agro_lab_v02.dtos.respuestas;

public class LoginRespuestaDTO {
    private String token;

    public LoginRespuestaDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
