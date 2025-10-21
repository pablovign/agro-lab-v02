package com.G6.agro_lab_v02.repositorios;

import com.G6.agro_lab_v02.entidades.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEspecie extends JpaRepository<Especie, Integer> {
}
