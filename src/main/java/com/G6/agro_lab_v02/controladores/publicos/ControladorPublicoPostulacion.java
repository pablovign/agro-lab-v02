package com.G6.agro_lab_v02.controladores.publicos;

import com.G6.agro_lab_v02.dtos.peticiones.PostulacionRegistroDTO;
import com.G6.agro_lab_v02.servicios.ServicioPostulacion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publico/postulaciones")
public class ControladorPublicoPostulacion {
    private final ServicioPostulacion servicioPostulacion;

    @Autowired
    public ControladorPublicoPostulacion(ServicioPostulacion servicioPostulacion) {
        this.servicioPostulacion = servicioPostulacion;
    }

    @PostMapping("/registro")
    public ResponseEntity<Void> registrar(@RequestBody PostulacionRegistroDTO dto) {
        servicioPostulacion.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
