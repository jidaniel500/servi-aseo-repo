package org.prueba.servi_aseo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "factura_servicio")
public class FacturaServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_servicio_id_gen")
    @SequenceGenerator(name = "factura_servicio_id_gen", sequenceName = "factura_servicio_id_factura_servicio_seq", allocationSize = 1)
    @Column(name = "id_factura_servicio", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura idFactura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_servicio", nullable = false)
    private Servicio idServicio;

}