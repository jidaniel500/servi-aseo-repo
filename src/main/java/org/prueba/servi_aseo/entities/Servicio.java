package org.prueba.servi_aseo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "servicio")
public class Servicio {
    @Id
    @ColumnDefault("nextval('servicio_id_servicio_seq')")
    @Column(name = "id_servicio", nullable = false)
    private Integer id;

    @Column(name = "tipo_servicio", nullable = false, length = 100)
    private String tipoServicio;

    @Column(name = "\"descripción\"", length = Integer.MAX_VALUE)
    private String descripción;

}