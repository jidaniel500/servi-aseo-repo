package org.prueba.servi_aseo.entities;

import lombok.Data;

@Data
public class Response<T> {
    
     private String mensaje;
     private T respuesta;
     private boolean Iscompletada;

}
