package com.G6.agro_lab_v02.controladores.publicos;

import com.G6.agro_lab_v02.servicios.ServicioEmpresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publico/empresas")
public class ControladorPublicoEmpresa {
    private final ServicioEmpresa servicioEmpresa;

    public ControladorPublicoEmpresa(ServicioEmpresa servicioEmpresa){
        this.servicioEmpresa = servicioEmpresa;
    }

    @GetMapping("/existe/{cuit}")
    public ResponseEntity<Boolean> existeCuit(@PathVariable String cuit){
        return ResponseEntity.ok(servicioEmpresa.existePorCuit(cuit));
    }
}
