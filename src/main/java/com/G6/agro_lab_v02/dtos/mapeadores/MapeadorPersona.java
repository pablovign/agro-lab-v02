package com.G6.agro_lab_v02.dtos.mapeadores;

import com.G6.agro_lab_v02.dtos.peticiones.PersonaRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.PersonaRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Distrito;
import com.G6.agro_lab_v02.entidades.Persona;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

public class MapeadorPersona {

    public static Persona toEntity(PersonaRegistroDTO dto, Distrito distrito){
        GeometryFactory gf = new GeometryFactory();
        Point ubicacion = gf.createPoint(new Coordinate(dto.getLongitud(), dto.getLatitud()));
        ubicacion.setSRID(4326);

        Persona persona = new Persona();
        persona.setDni(dto.getDni());
        persona.setApellido(dto.getApellido());
        persona.setNombre(dto.getNombre());
        persona.setCalle(dto.getCalle());
        persona.setNumeracion(dto.getNumeracion());
        persona.setCodigoPostal(dto.getCodigoPostal());
        persona.setUbicacion(ubicacion);
        persona.setTelefono(dto.getTelefono());
        persona.setDistrito(distrito);

        return persona;
    }

    public static PersonaRespuestaDTO toDto(Persona persona) {
        PersonaRespuestaDTO dto = new PersonaRespuestaDTO();
        dto.setIdPersona(persona.getIdPersona());
        dto.setDni(persona.getDni());
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setCalle(persona.getCalle());
        dto.setNumeracion(persona.getNumeracion());
        dto.setNombreDistrito(persona.getDistrito().getNombreDistrito());
        dto.setNombreDepartamento(persona.getDistrito().getDepartamento().getNombreDepartamento());
        dto.setTelefono(persona.getTelefono());
        dto.setLatitud(persona.getUbicacion().getY());
        dto.setLongitud(persona.getUbicacion().getX());

        return dto;
    }
}
