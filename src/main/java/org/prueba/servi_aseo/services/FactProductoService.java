package org.prueba.servi_aseo.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.prueba.servi_aseo.entities.Factura;
import org.prueba.servi_aseo.entities.FacturaProducto;
import org.prueba.servi_aseo.entities.Producto;
import org.prueba.servi_aseo.models.ProductoModel;
import org.prueba.servi_aseo.repositories.IFacturaProductoRepository;
import org.prueba.servi_aseo.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactProductoService implements IFactProdService {

    @Autowired
    private IFacturaProductoRepository repository;

    @Autowired
    private IProductoRepository productoRepository;


    @Override
    public boolean registrarProductosFacturas(Factura factura, ProductoModel[] productos) throws Exception {
        boolean registro = false;
        try {
            FacturaProducto factprod = new FacturaProducto();
            List<ProductoModel> productosmodel = Arrays.asList(productos);

            List<Integer> ids = productosmodel.stream()
                    .map(p -> Optional.ofNullable(p.getProducto()).orElse(null)).map(p -> p.getId())
                    .collect(Collectors.toList());

            List<Producto> allproduct = productoRepository.findAllById(ids);
            if (allproduct.isEmpty()) {
                registro = false;
            }

            productosmodel.forEach(p -> {
                factprod.setCantidad(p.getCantidad());
                factprod.setIdFactura(factura);
                factprod.setIdProducto(p.getProducto());
                try {
                    repository.save(factprod);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            return registro;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public FacturaProducto crear(FacturaProducto facturaProducto) throws Exception {
        FacturaProducto factprod = new FacturaProducto();
        try {
            factprod = repository.save(facturaProducto);
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
        return factprod;
    }

}
