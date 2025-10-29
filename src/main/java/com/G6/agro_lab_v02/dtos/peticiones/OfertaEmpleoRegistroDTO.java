package com.G6.agro_lab_v02.dtos.peticiones;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class OfertaEmpleoRegistroDTO {
    @NotNull(message = "El ID del establecimiento no puede estar vacío.")
    private Integer idEstablecimiento;

    @NotNull(message = "El ID del puesto de trabajo no puede estar vacío.")
    private Integer idPuestoTrabajo;

    private Integer idEspecie;
    @NotNull(message = "Las cantidad de vacantes son obligatorias.")
    @Min(value = 1, message = "La cantidad de vacantes debe ser al menos una.")
    private Integer vacantes;

    @NotNull(message = "La fecha de cierre es obligatoria.")
    @FutureOrPresent(message = "La fecha de cierre no puede ser anterior a hoy.")
    private LocalDate fechaCierre;

    public Integer getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public Integer getIdPuestoTrabajo() {
        return idPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(Integer idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    public Integer getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    public Integer getVacantes() {
        return vacantes;
    }

    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
