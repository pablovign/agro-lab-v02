package com.G6.agro_lab_v02.controladores.publicos;

import com.G6.agro_lab_v02.dtos.respuestas.DistritoRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioDistrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publico/distritos")
public class ControladorPublicoDistrito {
    private final ServicioDistrito servicioDistrito;

    @Autowired
    public ControladorPublicoDistrito(ServicioDistrito servicioDistrito){
        this.servicioDistrito = servicioDistrito;
    }

    @GetMapping("/{idDepartamento}")
    public ResponseEntity<List<DistritoRespuestaDTO>> listarDistritosPorDepartamento(@PathVariable Integer idDepartamento) {
        List<DistritoRespuestaDTO> distritos = servicioDistrito.obtenerDistritosPorDepartamento(idDepartamento);

        if (distritos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(distritos);
    }
}
