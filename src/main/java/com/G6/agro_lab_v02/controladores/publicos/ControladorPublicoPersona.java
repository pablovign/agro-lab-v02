package com.G6.agro_lab_v02.controladores.publicos;

import com.G6.agro_lab_v02.dtos.peticiones.PersonaRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.PersonaRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publico/personas")
public class ControladorPublicoPersona {
    private final ServicioPersona servicioPersona;

    @Autowired
    public ControladorPublicoPersona(ServicioPersona servicioPersona){
        this.servicioPersona = servicioPersona;
    }

    @GetMapping("/buscar/{dni}")
    public ResponseEntity<PersonaRespuestaDTO> buscarPorDni(@PathVariable String dni) {
        PersonaRespuestaDTO persona = servicioPersona.buscarPorDni(dni);
        if (persona != null) {
            return ResponseEntity.ok(persona);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
