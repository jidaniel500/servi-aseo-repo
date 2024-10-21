package org.prueba.servi_aseo.repositories;

import org.prueba.servi_aseo.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepositorio extends JpaRepository<Producto, Integer> {
    
      
}
