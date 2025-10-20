package com.G6.agro_lab_v02.entidades;

import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "establecimiento", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_empresa", "nombre_establecimiento"})
})
public class Establecimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_establecimiento")
    private Integer idEstablecimiento;

    @Column(name = "nombre_establecimiento", length = 25, nullable = false)
    private String nombreEstablecimiento;

    @Column(name = "fecha_alta", nullable = false, updatable = false, insertable = false)
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_baja")
    private LocalDateTime fechaBaja;

    @Column(length = 25, nullable = false)
    private String calle;

    @Column(length = 5, nullable = false)
    private String numeracion;

    @Column(name = "codigo_postal", length = 4, nullable = false)
    private String codigoPostal;

    @Column(columnDefinition = "GEOGRAPHY(POINT, 4326)", nullable = false)
    private Point ubicacion;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "id_distrito", nullable = false)
    private Distrito distrito;

    @ManyToMany
    @JoinTable(
            name = "establecimiento_especie",
            joinColumns = @JoinColumn(name = "id_establecimiento"),
            inverseJoinColumns = @JoinColumn(name = "id_especie")
    )
    private Set<Especie> especies = new HashSet<>();

    public Integer getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdEstablecimiento(Integer idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Point getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Point ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Set<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(Set<Especie> especies) {
        this.especies = especies;
    }
}
