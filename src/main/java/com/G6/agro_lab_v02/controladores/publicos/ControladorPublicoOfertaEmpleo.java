package com.G6.agro_lab_v02.controladores.publicos;

import com.G6.agro_lab_v02.dtos.respuestas.OfertaEmpleoRespuestaPubDTO;
import com.G6.agro_lab_v02.servicios.ServicioOfertaEmpleo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publico/ofertas-empleo")
public class ControladorPublicoOfertaEmpleo {
    private final ServicioOfertaEmpleo servicioOfertaEmpleo;

    @Autowired
    public ControladorPublicoOfertaEmpleo(ServicioOfertaEmpleo servicioOfertaEmpleo) {
        this.servicioOfertaEmpleo = servicioOfertaEmpleo;
    }

    @GetMapping("/vigentes")
    public ResponseEntity<List<OfertaEmpleoRespuestaPubDTO>> listarVigentes(
            @RequestParam(required = false) String puesto,
            @RequestParam(required = false, defaultValue = "fecha") String orden,
            @RequestParam(required = false) Double lat,
            @RequestParam(required = false) Double lon) {

        List<OfertaEmpleoRespuestaPubDTO> respuesta =
                servicioOfertaEmpleo.listarVigentesFiltradas(puesto, orden, lat, lon);

        return ResponseEntity.ok(respuesta);
    }
}
