package com.G6.agro_lab_v02.controladores.privados;

import com.G6.agro_lab_v02.dtos.respuestas.EmpresaRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
