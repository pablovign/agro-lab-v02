package com.G6.agro_lab_v02.controladores.privados;

import com.G6.agro_lab_v02.dtos.respuestas.EspecieRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Especie;
import com.G6.agro_lab_v02.servicios.ServicioEspecie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/privado/especies")
public class ControladorPrivadoEspecie {
    private final ServicioEspecie servicioEspecie;

    @Autowired
    public ControladorPrivadoEspecie(ServicioEspecie servicioEspecie){
        this.servicioEspecie = servicioEspecie;
    }

    @GetMapping
    public List<EspecieRespuestaDTO> listarEspecies(){
        return servicioEspecie.obtenerEspecies();
    }
}
