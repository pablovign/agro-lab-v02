package com.G6.agro_lab_v02.controladores.publicos;

import com.G6.agro_lab_v02.dtos.peticiones.LoginPeticionDTO;
import com.G6.agro_lab_v02.dtos.respuestas.LoginRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioAutenticacion;
import com.G6.agro_lab_v02.servicios.ServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publico")
public class ControladorAutenticacion {
    private final ServicioAutenticacion servicioAutenticacion;
    private final ServicioEmpresa servicioEmpresa;

    @Autowired
    public ControladorAutenticacion(ServicioAutenticacion servicioAutenticacion, ServicioEmpresa servicioEmpresa) {
        this.servicioAutenticacion = servicioAutenticacion;
        this.servicioEmpresa = servicioEmpresa;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginRespuestaDTO> login(@RequestBody LoginPeticionDTO dto) {
        String token = servicioAutenticacion.login(dto.getCuit(), dto.getContrasenia());
        return ResponseEntity.ok(new LoginRespuestaDTO(token));
    }
}
