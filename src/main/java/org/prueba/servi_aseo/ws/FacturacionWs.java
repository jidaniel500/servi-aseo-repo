package org.prueba.servi_aseo.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.prueba.servi_aseo.entities.Cliente;
import org.prueba.servi_aseo.entities.Factura;
import org.prueba.servi_aseo.entities.FacturaProducto;
import org.prueba.servi_aseo.entities.Producto;
import org.prueba.servi_aseo.entities.Response;
import org.prueba.servi_aseo.models.FacturaModel;
import org.prueba.servi_aseo.models.ProductoModel;
import org.prueba.servi_aseo.services.ClienteService;
import org.prueba.servi_aseo.services.FactProductoService;
import org.prueba.servi_aseo.services.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionWs {

    @Autowired
    private FacturacionService service;

    @PostMapping("/crear")
    public void create(@RequestBody FacturaModel facturamodel) {
        Response<Cliente> respuesta = new Response<>();
        try {
            Factura factura = service.crear(facturamodel.getFactura());
            if (factura != null) {
                service.registrarProductosFacturas(facturamodel.getFactura(), facturamodel.getProductos());
                
            }

        } catch (Exception e) {
            respuesta.setIscompletada(false);
            respuesta.setMensaje(e.getMessage());
        
        }

    }

}