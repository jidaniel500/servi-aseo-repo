package org.prueba.servi_aseo.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/apis")
public class ComprasWs {

      
    @PostMapping("path")
    public String postMethodName(@RequestBody String entity) {
        
        
        return entity;
    }
    
    
}