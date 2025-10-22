package com.G6.agro_lab_v02.repositorios;

import com.G6.agro_lab_v02.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioEmpresa extends JpaRepository<Empresa, Integer> {
    boolean existsByCuit(String cuit);

    Optional<Empresa> findByCuit(String cuit);
}
