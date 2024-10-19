package org.prueba.servi_aseo.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.prueba.servi_aseo.entities.Factura;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/facturacion")
public class FacturacionWs {

      
    @PostMapping("/crear")
    public String create(@RequestBody Factura factura) {
        
       return "";
    }

    
    
    
}