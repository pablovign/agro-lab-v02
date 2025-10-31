package com.G6.agro_lab_v02.dtos.respuestas;

import java.time.LocalDate;

public class OfertaEmpleoRespuestaPubDTO {
    private Integer idOfertaEmpleo;
    private String nombreEstablecimiento;
    private String nombrePuestoTrabajo;
    private String nombreEspecie;
    private LocalDate fechaCierre;
    private Integer vacantes;
    private double latitud;
    private double longitud;

    public OfertaEmpleoRespuestaPubDTO(Integer idOfertaEmpleo, String nombreEstablecimiento, String nombrePuestoTrabajo, String nombreEspecie, LocalDate fechaCierre, Integer vacantes,
                                       double latitud, double longitud) {
        this.idOfertaEmpleo = idOfertaEmpleo;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
        this.nombreEspecie = nombreEspecie;
        this.fechaCierre = fechaCierre;
        this.vacantes = vacantes;
        this.latitud = latitud;
        this.longitud = longitud;
    }
}
