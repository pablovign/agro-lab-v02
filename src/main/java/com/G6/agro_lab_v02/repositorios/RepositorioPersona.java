package com.G6.agro_lab_v02.repositorios;

import com.G6.agro_lab_v02.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPersona extends JpaRepository<Persona, Integer> {
}
