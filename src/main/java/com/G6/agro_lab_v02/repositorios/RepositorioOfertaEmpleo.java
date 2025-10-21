package com.G6.agro_lab_v02.repositorios;

import com.G6.agro_lab_v02.entidades.OfertaEmpleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioOfertaEmpleo extends JpaRepository<OfertaEmpleo, Integer> {
}
