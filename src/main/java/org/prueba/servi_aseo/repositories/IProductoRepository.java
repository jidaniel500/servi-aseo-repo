package org.prueba.servi_aseo.repositories;

import java.util.List;
import org.prueba.servi_aseo.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("SELECT p  FROM Producto p WHERE p.precio  = (SELECT MAX(pr.precio) FROM Producto pr )")
    List<Producto> findMayoresPrecios();

}
