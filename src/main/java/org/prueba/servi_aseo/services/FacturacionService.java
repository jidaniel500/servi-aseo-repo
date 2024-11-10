package org.prueba.servi_aseo.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.prueba.servi_aseo.entities.Factura;
import org.prueba.servi_aseo.models.FacturaModel;
import org.prueba.servi_aseo.repositories.IFacturacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturacionService implements IFacturacionService {

    @Autowired
    private IFacturacionRepository repository;

    @Autowired
    private FactProductoService prodServiceFactura;

    public Factura crear(FacturaModel factura) throws Exception {

        Factura facturaInicializada = incicializarFactura();
        Factura facturaGuardada = new Factura();
        try {
            facturaGuardada = repository.save(facturaInicializada);
            if (!prodServiceFactura.registrarProductosFacturas(facturaGuardada, factura.getProductos())) {
                throw new Exception("no se pudo registrar  la factura con los productos");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return facturaGuardada;

    }

    private Factura incicializarFactura() {
        Factura factura = new Factura();
        factura.setEstado("iniciao");
        factura.setFecha(LocalDate.parse(LocalDateTime.now().toString()));
        factura.setCorreoEnviado(false);
        factura.setMontoTotal(BigDecimal.ZERO);
        return factura;
    }
}
