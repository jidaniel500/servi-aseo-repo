package org.prueba.servi_aseo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "factura_producto")
public class FacturaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_producto_id_gen")
    @SequenceGenerator(name = "factura_producto_id_gen", sequenceName = "factura_producto_id_factura_producto_seq", allocationSize = 1)
    @Column(name = "id_factura_producto", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura idFactura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto idProducto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

}