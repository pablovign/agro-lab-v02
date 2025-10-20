package com.G6.agro_lab_v02.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "puesto_trabajo")
public class PuestoTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_puesto_trabajo")
    private Integer idPuestoTrabajo;

    @Column(name = "nombre_puesto_trabajo", length = 25, nullable = false, unique = true)
    private String nombrePuestoTrabajo;

    public Integer getIdPuestoTrabajo() {
        return idPuestoTrabajo;
    }

    public void setIdPuestoTrabajo(Integer idPuestoTrabajo) {
        this.idPuestoTrabajo = idPuestoTrabajo;
    }

    public String getNombrePuestoTrabajo() {
        return nombrePuestoTrabajo;
    }

    public void setNombrePuestoTrabajo(String nombrePuestoTrabajo) {
        this.nombrePuestoTrabajo = nombrePuestoTrabajo;
    }
}
