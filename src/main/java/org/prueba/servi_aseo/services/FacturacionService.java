package org.prueba.servi_aseo.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.prueba.servi_aseo.entities.Factura;
import org.prueba.servi_aseo.entities.FacturaProducto;
import org.prueba.servi_aseo.entities.FacturaServicio;
import org.prueba.servi_aseo.entities.Producto;
import org.prueba.servi_aseo.entities.Servicio;
import org.prueba.servi_aseo.models.ProductoModel;
import org.prueba.servi_aseo.repositories.FacturaProductoRepository;
import org.prueba.servi_aseo.repositories.FacturaServicioRepository;
import org.prueba.servi_aseo.repositories.FacturacionRepository;
import org.prueba.servi_aseo.repositories.ProductosRepositorio;
import org.prueba.servi_aseo.repositories.ServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturacionService {

    @Autowired
    private FacturacionRepository repository;

    @Autowired
    private FacturaProductoRepository factProducto_repository;

    @Autowired
    private FacturaServicioRepository factServicio_repository;

    @Autowired
    private ProductosRepositorio productoRepositorio;

    @Autowired
    private ServiciosRepository servicioRepositorio;

    public Factura crear(Factura factura) throws Exception {

        Factura newfactura = new Factura();
        try {
            if (!existeFactura(factura)) {
                factura.setCorreoEnviado(false);
                factura.setEstado("creada");
                factura.setFecha(LocalDate.now());
                factura.setMontoTotal(BigDecimal.ZERO);
                newfactura = repository.save(factura);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return newfactura;

    }

    public boolean existeFactura(Factura factura) {
        boolean existe = false;
        if (factura.getId() != null)
            existe = repository.findById(factura.getId()).isPresent();
        return existe;
    }

    public boolean registrarProductosFacturas(Factura factura, ProductoModel[] productos) throws Exception {

        try {
            FacturaProducto factprod = new FacturaProducto();

            List<ProductoModel> productosmodel = Arrays.asList(productos);
            Iterable<Integer> ids = productosmodel.stream().map(productoModel -> productoModel.getProducto().getId())
                    .collect(Collectors.toList());

            List<Producto> allproduct = productoRepositorio.findAllById(ids);
            if (allproduct.isEmpty()) {
                return false;
            }

            productosmodel.forEach(p -> {
                factprod.setCantidad(p.getCantidad());
                factprod.setIdFactura(factura);
                factprod.setIdProducto(p.getProducto());
                factProducto_repository.save(factprod);

            });

            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }

    }

    public boolean registrarServicioFacturas(Factura factura, Integer[] servicios) throws Exception {

        try {
            FacturaServicio factserv = new FacturaServicio();
            List<Integer> codservicios = Arrays.asList(servicios);
            List<Servicio> listaServicios = servicioRepositorio.findAllById(codservicios);
            listaServicios.forEach(servicio -> {
                factserv.setIdFactura(factura);
                factserv.setIdServicio(servicio);
                factServicio_repository.save(factserv);
            });

            factServicio_repository.save(factserv);
            return true;

        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }

    }

    // public BigDecimal sumarProductos(Producto[] productos, Integer cantidad,
    // Servicio servicio) {
    // BigDecimal monto_final = BigDecimal.ZERO;
    // BigDecimal bigint_cantidad = BigDecimal.valueOf(cantidad);
    // for (Producto p : productos) {
    // monto_final = monto_final.add(p.getPrecio().multiply(bigint_cantidad));
    // }

    // }

}
