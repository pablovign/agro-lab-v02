package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorEstablecimiento;
import com.G6.agro_lab_v02.dtos.peticiones.EstablecimientoRegistroDTO;
import com.G6.agro_lab_v02.dtos.respuestas.EstablecimientoRespuestaDTO;
import com.G6.agro_lab_v02.entidades.Distrito;
import com.G6.agro_lab_v02.entidades.Empresa;
import com.G6.agro_lab_v02.entidades.Especie;
import com.G6.agro_lab_v02.entidades.Establecimiento;
import com.G6.agro_lab_v02.excepciones.BadRequestException;
import com.G6.agro_lab_v02.excepciones.ResourceNotFoundException;
import com.G6.agro_lab_v02.excepciones.UnauthorizedException;
import com.G6.agro_lab_v02.repositorios.RepositorioDistrito;
import com.G6.agro_lab_v02.repositorios.RepositorioEmpresa;
import com.G6.agro_lab_v02.repositorios.RepositorioEspecie;
import com.G6.agro_lab_v02.repositorios.RepositorioEstablecimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioEstablecimiento {
    private final RepositorioEstablecimiento repositorioEstablecimiento;
    private final RepositorioDistrito repositorioDistrito;
    private final RepositorioEspecie repositorioEspecie;
    private final RepositorioEmpresa repositorioEmpresa;

    @Autowired
    public ServicioEstablecimiento(RepositorioEstablecimiento repositorioEstablecimiento, RepositorioDistrito repositorioDistrito,
                                   RepositorioEspecie repositorioEspecie, RepositorioEmpresa repositorioEmpresa) {
        this.repositorioEstablecimiento = repositorioEstablecimiento;
        this.repositorioDistrito = repositorioDistrito;
        this.repositorioEspecie = repositorioEspecie;
        this.repositorioEmpresa = repositorioEmpresa;
    }

    public EstablecimientoRespuestaDTO registrarEstablecimiento(EstablecimientoRegistroDTO dto, String cuit) {
        Empresa empresa = repositorioEmpresa.findByCuit(cuit)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada."));

        Distrito distrito = repositorioDistrito.findById(dto.getIdDistrito())
                .orElseThrow(() -> new ResourceNotFoundException("Distrito no encontrado."));

        List<Especie> especies = repositorioEspecie.findAllById(dto.getIdsEspecies());
        if (especies.isEmpty()) {
            throw new BadRequestException("Debe seleccionar al menos una especie válida.");
        }

        Establecimiento establecimiento = MapeadorEstablecimiento.toEntity(dto, empresa, distrito, especies);

        Establecimiento guardado = repositorioEstablecimiento.save(establecimiento);

        return MapeadorEstablecimiento.toDto(guardado);
    }

    public List<EstablecimientoRespuestaDTO> listarPorEmpresa(String cuit) {
        Empresa empresa = repositorioEmpresa.findByCuit(cuit)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada."));

        List<Establecimiento> establecimientos = repositorioEstablecimiento.findByEmpresaAndFechaBajaIsNull(empresa);

        return establecimientos.stream()
                .map(MapeadorEstablecimiento::toDto)
                .toList();
    }

    public EstablecimientoRespuestaDTO establecerFechaBaja(Integer id, String cuitEmpresa) {
        Establecimiento establecimiento = repositorioEstablecimiento.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Establecimiento no encontrado."));

        if (!establecimiento.getEmpresa().getCuit().equals(cuitEmpresa)) {
            throw new UnauthorizedException("No se pueden modificar establecimientos de otra empresa.");
        }

        if (establecimiento.getFechaBaja() == null) {
            establecimiento.setFechaBaja(LocalDateTime.now());
        }

        repositorioEstablecimiento.save(establecimiento);

        return MapeadorEstablecimiento.toDto(establecimiento);
    }
}
