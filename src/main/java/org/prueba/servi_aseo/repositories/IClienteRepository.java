package org.prueba.servi_aseo.repositories;

import java.time.LocalDate;

import org.prueba.servi_aseo.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    
    @Procedure(procedureName = "sp_crear_cliente")
    public void crear_cliente(String nombre, String apellido, String direccion, String email, String telefono,
            LocalDate fechaRegistro);

}
