package com.G6.agro_lab_v02.repositorios;

import com.G6.agro_lab_v02.entidades.Empresa;
import com.G6.agro_lab_v02.entidades.OfertaEmpleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioOfertaEmpleo extends JpaRepository<OfertaEmpleo, Integer> {
    List<OfertaEmpleo> findByEstablecimiento_Empresa(Empresa empresa);

    List<OfertaEmpleo> findByEstablecimiento_EmpresaAndVigenteTrue(Empresa empresa);
    @Query(value = """
        SELECT oe.*
        FROM oferta_empleo oe
        JOIN establecimiento e ON oe.id_establecimiento = e.id_establecimiento
        WHERE oe.vigente = true
        ORDER BY ST_Distance(e.ubicacion, ST_SetSRID(ST_MakePoint(:lon, :lat), 4326))
        """, nativeQuery = true)
    List<OfertaEmpleo> findVigentesOrderByDistancia(@Param("lat") Double lat, @Param("lon") Double lon);

    List<OfertaEmpleo> findByVigenteTrueOrderByFechaCierreAsc();

    List<OfertaEmpleo> findByVigenteTrue();
}
