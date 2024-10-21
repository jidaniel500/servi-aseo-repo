package org.prueba.servi_aseo.repositories;

import org.prueba.servi_aseo.entities.FacturaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaProductoRepository extends JpaRepository<FacturaProducto, Integer> {
    
}
