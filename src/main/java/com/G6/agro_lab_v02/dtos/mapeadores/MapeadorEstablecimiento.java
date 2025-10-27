package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.peticiones.EstablecimientoRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.EstablecimientoRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Distrito;
import com.G6.agro_lab_v02.entidades.Empresa;
import com.G6.agro_lab_v02.entidades.Especie;
import com.G6.agro_lab_v02.entidades.Establecimiento;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MapeadorEstablecimiento {

    public static Establecimiento toEntity(EstablecimientoRegistroDTO dto, Empresa empresa, Distrito distrito, List<Especie> especies){
        GeometryFactory gf = new GeometryFactory();
        Point ubicacion = gf.createPoint(new Coordinate(dto.getLongitud(), dto.getLatitud()));
        ubicacion.setSRID(4326);

        Establecimiento establecimiento = new Establecimiento();
        establecimiento.setNombreEstablecimiento(dto.getNombreEstablecimiento());
        establecimiento.setCalle(dto.getCalle());
        establecimiento.setNumeracion(dto.getNumeracion());
        establecimiento.setCodigoPostal(dto.getCodigoPostal());
        establecimiento.setUbicacion(ubicacion);
        establecimiento.setEmpresa(empresa);
        establecimiento.setDistrito(distrito);
        establecimiento.setEspecies(new HashSet<>(especies));

        return establecimiento;
    }

    public static EstablecimientoRespuestaDTO toDto(Establecimiento establecimiento){
        String nombreDistrito = establecimiento.getDistrito().getNombreDistrito();
        String nombreDepartamento = establecimiento.getDistrito().getDepartamento().getNombreDepartamento();

        List<String> especies = establecimiento.getEspecies()
                .stream()
                .map(Especie::getNombreEspecie)
                .toList();

        double latitud = 0;
        double longitud = 0;
        if (establecimiento.getUbicacion() != null) {
            latitud = establecimiento.getUbicacion().getY();
            longitud = establecimiento.getUbicacion().getX();
        }

        return new EstablecimientoRespuestaDTO(
                establecimiento.getIdEstablecimiento(),
                establecimiento.getNombreEstablecimiento(),
                establecimiento.getCalle(),
                establecimiento.getNumeracion(),
                establecimiento.getCodigoPostal(),
                nombreDistrito,
                nombreDepartamento,
                especies,
                latitud,
                longitud
        );
    }
}
