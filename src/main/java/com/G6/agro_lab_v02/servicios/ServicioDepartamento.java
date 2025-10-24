package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.dtos.mapeadores.MapeadorDepartamento;
import com.G6.agro_lab_v02.dtos.respuestas.DepartamentoRespuestaDTO;
import com.G6.agro_lab_v02.repositorios.RepositorioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDepartamento {

    private final RepositorioDepartamento repositorioDepartamento;

    @Autowired
    public ServicioDepartamento(RepositorioDepartamento repositorioDepartamento){
        this.repositorioDepartamento = repositorioDepartamento;
    }

    public List<DepartamentoRespuestaDTO> obtenerDepartamentos(){
        return repositorioDepartamento.findAll()
                .stream()
                .map(MapeadorDepartamento::toDto)
                .toList();
    }
}
