package com.G6.agro_lab_v02.controladores.privados;

import com.G6.agro_lab_v02.dtos.respuestas.PuestoTrabajoRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioPuestoTrabajo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/privado/puestos-trabajo")
public class ControladorPrivadoPuestoTrabajo {
    private final ServicioPuestoTrabajo servicioPuestoTrabajo;

    public ControladorPrivadoPuestoTrabajo(ServicioPuestoTrabajo servicioPuestoTrabajo){
        this.servicioPuestoTrabajo = servicioPuestoTrabajo;
    }

    @GetMapping
    public List<PuestoTrabajoRespuestaDTO> obtenerPuestosTrabajo(){
        return servicioPuestoTrabajo.obtenerPuestosTrabajo();
    }
}
