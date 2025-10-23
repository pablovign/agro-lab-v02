package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorEspecie;
import com.G6.agro_lab_v02.dtos.respuestas.EspecieRespuestaDTO;
import com.G6.agro_lab_v02.repositorios.RepositorioEspecie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEspecie {
    private final RepositorioEspecie repositorioEspecie;

    @Autowired
    public ServicioEspecie(RepositorioEspecie repositorioEspecie){
        this.repositorioEspecie = repositorioEspecie;
    }

    public List<EspecieRespuestaDTO> obtenerEspecies(){
        return repositorioEspecie.findAll()
                .stream()
                .map(MapeadorEspecie::toDto)
                .toList();
    }
}
