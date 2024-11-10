package org.prueba.servi_aseo.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.prueba.servi_aseo.entities.Cliente;
import org.prueba.servi_aseo.entities.Response;
import org.prueba.servi_aseo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/clientes")
public class ClientesWs {

    @Autowired
    private ClienteService service;

    @PostMapping("/crear")
    public ResponseEntity<Response<Cliente>> crear(@RequestBody Cliente cliente) {
        Response<Cliente> respuesta = new Response<>();
        try {
            boolean crear = service.crear(cliente);
            if (!crear) {
                respuesta.setMensaje("Usuario no ha sido creado, ya existe uno");
            } else {
                respuesta.setMensaje("Usuario creado con exito");
            }
            respuesta.setIscompletada(true);
            respuesta.setRespuesta(cliente);
            return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            respuesta.setIscompletada(false);
            respuesta.setMensaje(e.getMessage());
            return new ResponseEntity<Response<Cliente>>(respuesta, HttpStatus.NOT_FOUND);
        }
    }

}
