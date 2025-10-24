package com.G6.agro_lab_v02.dtos.respuestas;

public class DepartamentoRespuestaDTO {
    private Integer idDepartamento;
    private String nombreDepartamento;

    public DepartamentoRespuestaDTO(Integer idDepartamento, String nombreDepartamento){
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}
