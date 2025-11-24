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
public class ControladorPrivadoOfertaEmpleo {
    private final ServicioOfertaEmpleo servicioOfertaEmpleo;

    @Autowired
    public ControladorPrivadoOfertaEmpleo(ServicioOfertaEmpleo servicioOfertaEmpleo){
        this.servicioOfertaEmpleo = servicioOfertaEmpleo;
    }

    @PostMapping("/registro")
    public ResponseEntity<OfertaEmpleoRespuestaPrivDTO> registrarOferta(@RequestBody OfertaEmpleoRegistroDTO dto) {
        OfertaEmpleoRespuestaPrivDTO respuesta = servicioOfertaEmpleo.registrarOferta(dto);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public ResponseEntity<List<OfertaEmpleoRespuestaPrivDTO>> listarPorEmpresa(Authentication authentication,
                                                                               @RequestParam(name = "vigente", required = false) Boolean vigente) {
        String cuit = authentication.getName();
        List<OfertaEmpleoRespuestaPrivDTO> respuesta = servicioOfertaEmpleo.listarPorEmpresa(cuit, vigente);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}/baja")
    public ResponseEntity<Void> darDeBaja(@PathVariable Integer id, Authentication authentication) {
        String cuitEmpresa = authentication.getName();
        servicioOfertaEmpleo.darDeBaja(id, cuitEmpresa);
        return ResponseEntity.noContent().build();
    }
}
