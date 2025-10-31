package com.G6.agro_lab_v02.repositorios;

import com.G6.agro_lab_v02.entidades.Empresa;
import com.G6.agro_lab_v02.entidades.OfertaEmpleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioOfertaEmpleo extends JpaRepository<OfertaEmpleo, Integer> {
    List<OfertaEmpleo> findByEstablecimiento_Empresa(Empresa empresa);
    List<OfertaEmpleo> findByEstablecimiento_EmpresaAndVigenteTrue(Empresa empresa);
}
