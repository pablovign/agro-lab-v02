package com.G6.agro_lab_v02.controladores.publicos;

import com.G6.agro_lab_v02.dtos.peticiones.EmpresaRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.EmpresaRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioEmpresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/registro")
    public ResponseEntity<EmpresaRespuestaDTO> registrarEmpresa(@RequestBody EmpresaRegistroDTO dto) {
        EmpresaRespuestaDTO respuesta = servicioEmpresa.registrarEmpresa(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }
}
