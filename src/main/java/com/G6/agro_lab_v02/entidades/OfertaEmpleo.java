package com.G6.agro_lab_v02.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "oferta_empleo")
public class OfertaEmpleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta_empleo")
    private Integer idOfertaEmpleo;

    @Column(name = "fecha_alta", nullable = false, updatable = false, insertable = false)
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_cierre")
    private LocalDate fechaCierre;

    @Column(nullable = false)
    private Boolean vigente;

    @Column(nullable = false)
    private Integer vacantes;

    @ManyToOne
    @JoinColumn(name = "id_puesto_trabajo", nullable = false)
    private PuestoTrabajo puestoTrabajo;

    @ManyToOne
    @JoinColumn(name = "id_establecimiento", nullable = false)
    private Establecimiento establecimiento;

    @ManyToOne
    @JoinColumn(name = "id_especie")
    private Especie especie;

    public Integer getIdOfertaEmpleo() {
        return idOfertaEmpleo;
    }

    public void setIdOfertaEmpleo(Integer idOfertaEmpleo) {
        this.idOfertaEmpleo = idOfertaEmpleo;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    public Integer getVacantes() {
        return vacantes;
    }

    public void setVacantes(Integer vacantes) {
        this.vacantes = vacantes;
    }

    public PuestoTrabajo getPuestoTrabajo() {
        return puestoTrabajo;
    }

    public void setPuestoTrabajo(PuestoTrabajo puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }

    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
}
