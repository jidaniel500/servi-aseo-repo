package org.prueba.servi_aseo.services;

import org.prueba.servi_aseo.entities.Factura;
import org.prueba.servi_aseo.models.FacturaModel;

public interface IFacturacionService {

    Factura crear(FacturaModel factura) throws Exception;

}
