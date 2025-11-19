package com.G6.agro_lab_v02.controladores.privados;

import com.G6.agro_lab_v02.dtos.peticiones.EmpresaEdicionDTO;
import com.G6.agro_lab_v02.dtos.respuestas.EmpresaRespuestaDTO;
import com.G6.agro_lab_v02.dtos.respuestas.EstablecimientoRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioEmpresa;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/privado/empresas")
public class ControladorPrivadoEmpresa {
    private final ServicioEmpresa servicioEmpresa;

    @Autowired
    public ControladorPrivadoEmpresa(ServicioEmpresa servicioEmpresa){
        this.servicioEmpresa = servicioEmpresa;
    }

    @GetMapping("/perfil")
    public ResponseEntity<EmpresaRespuestaDTO> obtenerPerfil(Authentication authentication){
        EmpresaRespuestaDTO perfil = servicioEmpresa.obtenerEmpresa(authentication.getName());
        return ResponseEntity.ok(perfil);
    }


    @PutMapping
    public ResponseEntity<EmpresaRespuestaDTO> actualizarEmpresa(@RequestBody @Valid EmpresaEdicionDTO empresaEdicionDTO,
                                                                         Authentication authentication){
        String cuit = authentication.getName();
        EmpresaRespuestaDTO respuesta = servicioEmpresa.actualizarEmpresa(empresaEdicionDTO, cuit);
        return ResponseEntity.ok(respuesta);
    }
}
