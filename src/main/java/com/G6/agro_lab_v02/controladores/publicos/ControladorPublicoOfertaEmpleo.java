package com.G6.agro_lab_v02.controladores.publicos;

import com.G6.agro_lab_v02.servicios.ServicioOfertaEmpleo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
