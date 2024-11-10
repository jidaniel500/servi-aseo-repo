package org.prueba.servi_aseo.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/apis/compras")
public class ComprasWs {

      
    @PostMapping("/crear")
    public String crearFacturacion(@RequestBody String entity) {
        return entity;
    }
    
    
}