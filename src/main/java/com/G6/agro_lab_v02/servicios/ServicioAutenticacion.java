package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.entidades.Empresa;
import com.G6.agro_lab_v02.seguridad.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ServicioAutenticacion {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public ServicioAutenticacion(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public String login(String cuit, String contrasenia) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(cuit, contrasenia)
        );
        if (auth.isAuthenticated()) {
            return jwtUtil.generateToken(cuit);
        }
        throw new BadCredentialsException("Credenciales inválidas");
    }

    public String generarToken(Empresa empresa) {
        return jwtUtil.generateToken(empresa.getCuit());
    }
}
