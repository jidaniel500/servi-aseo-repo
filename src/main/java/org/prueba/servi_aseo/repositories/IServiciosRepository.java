package org.prueba.servi_aseo.repositories;

import org.prueba.servi_aseo.entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiciosRepository extends JpaRepository<Servicio, Integer> {
    
      
}
