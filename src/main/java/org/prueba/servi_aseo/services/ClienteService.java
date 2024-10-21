package org.prueba.servi_aseo.services;

import org.prueba.servi_aseo.entities.Cliente;
import org.prueba.servi_aseo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public boolean crear(Cliente cliente) throws Exception {
        boolean creado = false;
        if (!existeCliente(cliente)) {
            try {
                // repository.save(cliente);
                repository.crear_cliente(cliente.getNombre(), cliente.getApellido(), cliente.getDireccion(),
                        cliente.getCorreoElectronico(), cliente.getTelefono(), cliente.getFechaRegistro());
                creado = true;
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }
        return creado;
    }

    public boolean existeCliente(Cliente cliente) {
        boolean existe = false;
        if (cliente.getId() != null)
            existe = repository.findById(cliente.getId()).isPresent();
        return existe;
    }

}
