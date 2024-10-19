package org.prueba.servi_aseo.services;

import org.prueba.servi_aseo.entities.Factura;
import org.prueba.servi_aseo.repositories.FacturacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturacionService {

    @Autowired
    private FacturacionRepository repositorio;

    public void create(Factura factura) throws Exception  {
        boolean existe = repositorio.findById(factura.getId()).isPresent();
        if(!existe){
            throw new Exception("Ya existe una factura con este Id");
        }
        repositorio.save(factura);
        
    }

}
