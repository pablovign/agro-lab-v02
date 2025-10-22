package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorEmpresa;
import com.G6.agro_lab_v02.dtos.peticiones.EmpresaRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.EmpresaRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Empresa;
import com.G6.agro_lab_v02.excepciones.BadRequestException;
import com.G6.agro_lab_v02.repositorios.RepositorioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServicioEmpresa {
    private final RepositorioEmpresa repositorioEmpresa;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ServicioEmpresa(RepositorioEmpresa repositorioEmpresa, PasswordEncoder passwordEncoder){
        this.repositorioEmpresa = repositorioEmpresa;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean existePorCuit(String cuit){
        return repositorioEmpresa.existsByCuit(cuit);
    }

    public EmpresaRespuestaDTO registrarEmpresa(EmpresaRegistroDTO dto) {
        if (repositorioEmpresa.existsByCuit(dto.getCuit())) {
            throw new BadRequestException("El CUIT ya está registrado.");
        }

        Empresa empresa = MapeadorEmpresa.toEntity(dto);
        empresa.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
        repositorioEmpresa.save(empresa);

        return MapeadorEmpresa.toDTO(empresa);
    }
}
