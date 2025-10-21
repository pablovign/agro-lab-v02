package com.G6.agro_lab_v02.repositorios;

import com.G6.agro_lab_v02.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEmpresa extends JpaRepository<Empresa, Integer> {
}
