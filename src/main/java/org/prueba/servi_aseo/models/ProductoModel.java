package org.prueba.servi_aseo.models;

import org.prueba.servi_aseo.entities.Producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoModel {

    private Producto producto;
    private Integer cantidad;
}
