package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.respuestas.DistritoRespuestaDTO;
import com.G6.agro_lab_v02.repositorios.RepositorioDistrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDistrito {
    private final RepositorioDistrito repositorioDistrito;

    @Autowired
    public ServicioDistrito(RepositorioDistrito repositorioDistrito){
        this.repositorioDistrito = repositorioDistrito;
    }

    public List<DistritoRespuestaDTO> obtenerDistritosPorDepartamento(Integer idDepartamento) {
        return repositorioDistrito.findByDepartamentoIdDepartamento(idDepartamento)
                .stream()
                .map(distrito -> new DistritoRespuestaDTO(distrito.getIdDistrito(), distrito.getNombreDistrito()))
                .toList();
    }
}
