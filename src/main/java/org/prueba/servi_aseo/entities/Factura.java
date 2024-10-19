package org.prueba.servi_aseo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @ColumnDefault("nextval('factura_id_factura_seq')")
    @Column(name = "id_factura", nullable = false)
    private Integer id;

    @ColumnDefault("CURRENT_DATE")
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "monto_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoTotal;

    @Column(name = "estado", nullable = false, length = 50)
    private String estado;

    @ColumnDefault("false")
    @Column(name = "correo_enviado")
    private Boolean correoEnviado;

}