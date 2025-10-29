package com.G6.agro_lab_v02.controladores.privados;

import com.G6.agro_lab_v02.dtos.peticiones.OfertaEmpleoRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.OfertaEmpleoRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioOfertaEmpleo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/privado/ofertas-empleo")
public class ControladorPrivadoOfertaEmpleo {
    private final ServicioOfertaEmpleo servicioOfertaEmpleo;

    @Autowired
    public ControladorPrivadoOfertaEmpleo(ServicioOfertaEmpleo servicioOfertaEmpleo){
        this.servicioOfertaEmpleo = servicioOfertaEmpleo;
    }

    @PostMapping("/registro")
    public ResponseEntity<OfertaEmpleoRespuestaDTO> registrarOferta(@RequestBody OfertaEmpleoRegistroDTO dto) {
        OfertaEmpleoRespuestaDTO respuesta = servicioOfertaEmpleo.registrarOferta(dto);
        return ResponseEntity.ok(respuesta);
    }
}
