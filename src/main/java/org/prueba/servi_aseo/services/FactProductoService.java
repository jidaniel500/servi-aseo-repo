package org.prueba.servi_aseo.services;

import org.prueba.servi_aseo.entities.FacturaProducto;
import org.prueba.servi_aseo.repositories.FacturaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactProductoService {

    @Autowired
    private FacturaProductoRepository repository;

    public FacturaProducto crear(FacturaProducto entidad) throws Exception {
        return repository.save(entidad);
    }

}
