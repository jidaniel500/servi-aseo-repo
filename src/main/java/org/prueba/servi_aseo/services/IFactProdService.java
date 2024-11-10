package org.prueba.servi_aseo.services;

import org.prueba.servi_aseo.entities.Factura;
import org.prueba.servi_aseo.entities.FacturaProducto;
import org.prueba.servi_aseo.models.ProductoModel;

public interface IFactProdService {

    FacturaProducto crear(FacturaProducto facturaProducto) throws Exception;
    boolean registrarProductosFacturas(Factura factura, ProductoModel[] productos) throws Exception;

}
