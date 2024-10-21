package org.prueba.servi_aseo.models;

import org.prueba.servi_aseo.entities.Factura;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaModel {

     private ProductoModel[] productos;
     private Factura factura;
     private Integer codServicio;
    
}
