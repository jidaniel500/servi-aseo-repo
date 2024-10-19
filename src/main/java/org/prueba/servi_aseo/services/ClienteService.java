package org.prueba.servi_aseo.services;

import org.prueba.servi_aseo.entities.Cliente;
import org.prueba.servi_aseo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public boolean crear(Cliente cliente) {
        boolean existe = repository.findById(cliente.getId()).isPresent();
        if (!existe)
            return false;
        repository.save(cliente);
        return true;
    }

    
}
