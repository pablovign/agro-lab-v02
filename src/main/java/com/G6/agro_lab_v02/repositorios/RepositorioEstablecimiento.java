package com.G6.agro_lab_v02.repositorios;

import com.G6.agro_lab_v02.entidades.Empresa;
import com.G6.agro_lab_v02.entidades.Establecimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEstablecimiento extends JpaRepository<Establecimiento, Integer> {
    List<Establecimiento> findByEmpresaAndFechaBajaIsNull(Empresa empresa);
}
