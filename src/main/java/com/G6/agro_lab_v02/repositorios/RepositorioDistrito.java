package com.G6.agro_lab_v02.repositorios;

import com.G6.agro_lab_v02.entidades.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDistrito extends JpaRepository<Distrito, Integer> {

    List<Distrito> findByDepartamentoIdDepartamento(Integer idDepartamento);
}
