package org.prueba.servi_aseo.repositories;


import org.prueba.servi_aseo.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FacturacionRepository extends JpaRepository<Factura, Integer> {
     

}