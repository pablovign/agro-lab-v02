package com.G6.agro_lab_v02.controladores.privados;

import com.G6.agro_lab_v02.dtos.peticiones.OfertaEmpleoRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.OfertaEmpleoRespuestaPrivDTO;
import com.G6.agro_lab_v02.servicios.ServicioOfertaEmpleo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/privado/ofertas-empleo")
public class ControladorPrivadoOfertaEmpleoPriv {
    private final ServicioOfertaEmpleo servicioOfertaEmpleo;

    @Autowired
    public ControladorPrivadoOfertaEmpleoPriv(ServicioOfertaEmpleo servicioOfertaEmpleo){
        this.servicioOfertaEmpleo = servicioOfertaEmpleo;
    }

    @PostMapping("/registro")
    public ResponseEntity<OfertaEmpleoRespuestaPrivDTO> registrarOferta(@RequestBody OfertaEmpleoRegistroDTO dto) {
        OfertaEmpleoRespuestaPrivDTO respuesta = servicioOfertaEmpleo.registrarOferta(dto);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public ResponseEntity<List<OfertaEmpleoRespuestaPrivDTO>> listarPorEmpresa(Authentication authentication) {
        String cuit = authentication.getName();
        List<OfertaEmpleoRespuestaPrivDTO> respuesta = servicioOfertaEmpleo.listarPorEmpresa(cuit);
        return ResponseEntity.ok(respuesta);
    }
}
