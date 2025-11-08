package com.G6.agro_lab_v02.repositorios;

import com.G6.agro_lab_v02.entidades.OfertaEmpleo;
import com.G6.agro_lab_v02.entidades.OfertaEmpleoPersona;
import com.G6.agro_lab_v02.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioOfertaEmpleoPersona extends JpaRepository<OfertaEmpleoPersona, Integer> {
    boolean existsByPersonaAndOfertaEmpleo(Persona persona, OfertaEmpleo oferta);
    List<OfertaEmpleoPersona> findByOfertaEmpleo(OfertaEmpleo ofertaEmpleo);
}