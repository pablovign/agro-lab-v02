package com.G6.agro_lab_v02.controladores.privados;

import com.G6.agro_lab_v02.dtos.respuestas.PostulacionRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioPostulacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/privado/postulaciones")
public class ControladorPrivadoPostulacion {
    private final ServicioPostulacion servicioPostulacion;

    @Autowired
    public ControladorPrivadoPostulacion(ServicioPostulacion servicioPostulacion){
        this.servicioPostulacion = servicioPostulacion;
    }

    @GetMapping("/oferta/{id}")
    public ResponseEntity<List<PostulacionRespuestaDTO>> obtenerPostulacionesPorOferta(@PathVariable Integer id) {
        List<PostulacionRespuestaDTO> postulaciones = servicioPostulacion.obtenerPostulacionesPorOferta(id);
        return ResponseEntity.ok(postulaciones);
    }

    @PutMapping("/{id}/baja")
    public ResponseEntity<Void> darDeBaja(@PathVariable Integer id, Authentication authentication) {
        String cuitEmpresa = authentication.getName();
        servicioPostulacion.darDeBaja(id, cuitEmpresa);
        return ResponseEntity.noContent().build();
    }
}
