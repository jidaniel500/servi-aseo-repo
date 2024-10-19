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
@Table(name = "empleado")
public class Empleado {
    @Id
    @ColumnDefault("nextval('empleado_id_empleado_seq')")
    @Column(name = "id_empleado", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "cargo", nullable = false, length = 50)
    private String cargo;

    @Column(name = "correo_electronico", length = 100)
    private String correoElectronico;

}