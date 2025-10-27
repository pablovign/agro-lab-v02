package com.G6.agro_lab_v02.controladores.privados;

import com.G6.agro_lab_v02.dtos.peticiones.EstablecimientoRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.EstablecimientoRespuestaDTO;
import com.G6.agro_lab_v02.servicios.ServicioEstablecimiento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/privado/establecimientos")
public class ControladorPrivadoEstablecimiento {
    private final ServicioEstablecimiento servicioEstablecimiento;

    @Autowired
    public ControladorPrivadoEstablecimiento(ServicioEstablecimiento servicioEstablecimiento) {
        this.servicioEstablecimiento = servicioEstablecimiento;
    }

    @PostMapping("/registro")
    public ResponseEntity<EstablecimientoRespuestaDTO> registrarEstablecimiento(@RequestBody @Valid EstablecimientoRegistroDTO dto,
            Authentication authentication) {

        String cuit = authentication.getName();

        EstablecimientoRespuestaDTO respuesta = servicioEstablecimiento.registrarEstablecimiento(dto, cuit);

        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }
}
