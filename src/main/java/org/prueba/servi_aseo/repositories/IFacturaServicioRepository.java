package org.prueba.servi_aseo.repositories;

import org.prueba.servi_aseo.entities.FacturaServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaServicioRepository extends JpaRepository<FacturaServicio, Integer> {
    
}
