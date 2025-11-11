package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorPersona;
import com.G6.agro_lab_v02.dtos.peticiones.PersonaRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.PersonaRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Distrito;
import com.G6.agro_lab_v02.entidades.Persona;
import com.G6.agro_lab_v02.excepciones.ResourceNotFoundException;
import com.G6.agro_lab_v02.repositorios.RepositorioDistrito;
import com.G6.agro_lab_v02.repositorios.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ServicioPersona {
    private final RepositorioPersona repositorioPersona;
    private final RepositorioDistrito repositorioDistrito;

    @Autowired
    public ServicioPersona(RepositorioPersona repositorioPersona, RepositorioDistrito repositorioDistrito) {
        this.repositorioPersona = repositorioPersona;
        this.repositorioDistrito = repositorioDistrito;
    }

    @Transactional
    public Persona obtenerOCrear(PersonaRegistroDTO dto) {
        return repositorioPersona.findByDni(dto.getDni())
                .map(p -> actualizarSiCambio(p, dto))
                .orElseGet(() -> crearPersona(dto));
    }

    private Persona crearPersona(PersonaRegistroDTO dto) {
        Distrito distrito = repositorioDistrito.findById(dto.getIdDistrito())
                .orElseThrow(() -> new ResourceNotFoundException("Distrito no encontrado."));
        Persona persona = MapeadorPersona.toEntity(dto, distrito);
        return repositorioPersona.save(persona);
    }

    private Persona actualizarSiCambio(Persona persona, PersonaRegistroDTO dto) {
        boolean modificado = false;

        if (!Objects.equals(persona.getNombre(), dto.getNombre())) {
            persona.setNombre(dto.getNombre());
            modificado = true;
        }
        if (!Objects.equals(persona.getApellido(), dto.getApellido())) {
            persona.setApellido(dto.getApellido());
            modificado = true;
        }
        if (modificado) {
            repositorioPersona.save(persona);
        }
        return persona;
    }

    public PersonaRespuestaDTO buscarPorDni(String dni) {
        return repositorioPersona.findByDni(dni)
                .map(MapeadorPersona::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró una persona con el DNI: " + dni));
    }
}
