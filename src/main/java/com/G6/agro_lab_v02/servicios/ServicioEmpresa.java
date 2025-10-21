package com.G6.agro_lab_v02.servicios;

import com.G6.agro_lab_v02.repositorios.RepositorioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioEmpresa {
    private final RepositorioEmpresa repositorioEmpresa;

    @Autowired
    public ServicioEmpresa(RepositorioEmpresa repositorioEmpresa){
        this.repositorioEmpresa = repositorioEmpresa;
    }

    public boolean existePorCuit(String cuit){
        return repositorioEmpresa.existsByCuit(cuit);
    }
}
