package org.prueba.servi_aseo.services;

import java.math.BigDecimal;
import java.util.List;

import org.prueba.servi_aseo.entities.Producto;


public interface IProductoService {
    
    public BigDecimal calcularMontoTotal(List<Integer> idsProductos,  List<Integer> idsServicios);
    public List<Producto> getAllProducts();
    public List<Producto> getProductsByIds(List<Integer> ids);
    
       
}
