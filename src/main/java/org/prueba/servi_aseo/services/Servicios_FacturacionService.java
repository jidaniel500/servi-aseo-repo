package org.prueba.servi_aseo.services;

import org.prueba.servi_aseo.entities.FacturaServicio;
import org.prueba.servi_aseo.repositories.FacturaServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicios_FacturacionService {

    @Autowired
    private FacturaServicioRepository repository;

    public FacturaServicio crear(FacturaServicio entidad) throws Exception {
        if (entidad.getIdFactura() == null || entidad.getIdServicio() == null)
            throw new Exception("No pueden ser nulos las llaves foraneas de la tabla ");
        return repository.save(entidad);
    }

}
