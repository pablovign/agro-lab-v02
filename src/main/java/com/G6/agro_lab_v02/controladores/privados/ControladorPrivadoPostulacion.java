package com.G6.agro_lab_v02.controladores.privados;

import com.G6.agro_lab_v02.dtos.respuestas.PostulacionRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioPostulacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
