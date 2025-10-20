package com.G6.agro_lab_v02.entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "oferta_empleo_persona", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_oferta_empleo", "id_persona"})
})
public class OfertaEmpleoPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta_empleo_persona")
    private Integer idOfertaEmpleoPersona;

    @Column(name = "fecha_alta", nullable = false, updatable = false, insertable = false)
    private LocalDateTime fechaAlta;

    @ManyToOne
    @JoinColumn(name = "id_oferta_empleo", nullable = false)
    private OfertaEmpleo ofertaEmpleo;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    public Integer getIdOfertaEmpleoPersona() {
        return idOfertaEmpleoPersona;
    }

    public void setIdOfertaEmpleoPersona(Integer idOfertaEmpleoPersona) {
        this.idOfertaEmpleoPersona = idOfertaEmpleoPersona;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public OfertaEmpleo getOfertaEmpleo() {
        return ofertaEmpleo;
    }

    public void setOfertaEmpleo(OfertaEmpleo ofertaEmpleo) {
        this.ofertaEmpleo = ofertaEmpleo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}

