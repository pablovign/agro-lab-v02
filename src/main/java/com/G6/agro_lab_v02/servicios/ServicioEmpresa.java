package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorEmpresa;
import com.G6.agro_lab_v02.dtos.peticiones.EmpresaEdicionDTO;
import com.G6.agro_lab_v02.dtos.peticiones.EmpresaRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.EmpresaRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Empresa;
import com.G6.agro_lab_v02.excepciones.BadRequestException;
import com.G6.agro_lab_v02.excepciones.ResourceNotFoundException;
import com.G6.agro_lab_v02.repositorios.RepositorioEmpresa;
import jakarta.transaction.Transactional;
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

    public EmpresaRespuestaDTO obtenerEmpresa(String cuit){
        Empresa empresa = repositorioEmpresa.findByCuit(cuit)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada."));
        return MapeadorEmpresa.toDTO(empresa);
    }

    @Transactional
    public EmpresaRespuestaDTO actualizarEmpresa(EmpresaEdicionDTO empresaEdicionDTO, String cuit){
        Empresa empresa = repositorioEmpresa.findByCuit(cuit)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada"));

        //empresa.setRazonSocial(empresaEdicionDTO.getRazonSocial());
        //empresa.setContrasenia(passwordEncoder.encode(empresaEdicionDTO.getContrasenia()));

        String nuevaRazonSocial = empresaEdicionDTO.getRazonSocial();
        if (nuevaRazonSocial != null && !nuevaRazonSocial.trim().isEmpty()) {
            empresa.setRazonSocial(nuevaRazonSocial);
        }

        String nuevaContrasenia = empresaEdicionDTO.getContrasenia();
        if (nuevaContrasenia != null && !nuevaContrasenia.trim().isEmpty()) {
            empresa.setContrasenia(passwordEncoder.encode(nuevaContrasenia));
        }

        Empresa empresaActualizada = repositorioEmpresa.save(empresa);

        return MapeadorEmpresa.toDTO(empresaActualizada);
    }
}
