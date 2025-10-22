package com.G6.agro_lab_v02.seguridad;

import com.G6.agro_lab_v02.entidades.Empresa;
import com.G6.agro_lab_v02.repositorios.RepositorioEmpresa;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final RepositorioEmpresa repositorioEmpresa;

    public CustomUserDetailsService(RepositorioEmpresa repositorioEmpresa) {
        this.repositorioEmpresa = repositorioEmpresa;
    }

    @Override
    public UserDetails loadUserByUsername(String cuit) throws UsernameNotFoundException {
        Empresa empresa = repositorioEmpresa.findByCuit(cuit)
                .orElseThrow(() -> new UsernameNotFoundException("Empresa no encontrada."));

        return User.builder()
                .username(empresa.getCuit())
                .password(empresa.getContrasenia())
                .authorities("ROLE_EMPRESA")
                .build();
    }
}
