package com.G6.agro_lab_v02.controladores.publicos;

import com.G6.agro_lab_v02.dtos.respuestas.DepartamentoRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publico/departamentos")
public class ControladorPublicoDepartamento {
    private final ServicioDepartamento servicioDepartamento;

    @Autowired
    public ControladorPublicoDepartamento(ServicioDepartamento servicioDepartamento){
        this.servicioDepartamento = servicioDepartamento;
    }

    @GetMapping
    public List<DepartamentoRespuestaDTO> listarDepartamentos(){
        return servicioDepartamento.obtenerDepartamentos();
    }
}
