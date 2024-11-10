package org.prueba.servi_aseo.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.prueba.servi_aseo.entities.Producto;
import org.prueba.servi_aseo.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicioService implements IProductoService {

      @Autowired
      private IProductoRepository productoRepository;

      @Override
      public BigDecimal calcularMontoTotal(List<Integer> idsProductos, List<Integer> idsServicios) {

            BigDecimal sumaTotalProductos = BigDecimal.ZERO;

            if (!idsProductos.isEmpty()) {
                  List<Producto> productos = this.getProductsByIds(idsProductos);
                  sumaTotalProductos = productos.stream()
                              .map(p -> Optional.ofNullable(p.getPrecio()).orElse(BigDecimal.ZERO))
                              .reduce(BigDecimal.ZERO, BigDecimal::add);

            }

            return sumaTotalProductos;
      }

      

      @Override
      public List<Producto> getAllProducts() {
            return productoRepository.findAll();
      }

      @Override
      public List<Producto> getProductsByIds(List<Integer> ids) {
            return productoRepository.findAllById(ids);
      }

      public List<Producto> getMaximoPrecio() {
            return productoRepository.findMayoresPrecios();
      }

}
