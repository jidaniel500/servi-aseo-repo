package org.prueba.servi_aseo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id_cliente", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_id_cliente_seq")
    @SequenceGenerator(name = "cliente_id_cliente_seq", sequenceName = "cliente_id_cliente_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "correo_electronico", length = 100)
    private String correoElectronico;

    @ColumnDefault("CURRENT_DATE")
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

}