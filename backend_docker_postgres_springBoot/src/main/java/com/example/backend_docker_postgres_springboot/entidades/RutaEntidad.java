package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name ="tbl_rutas")
@Data
public class RutaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_ruta;
    private String descripcion;
    private String duracion_estimada;

    //relacion de uno a mcuhos con horario
    @OneToMany(mappedBy = "id_horario",cascade = CascadeType.ALL)
    private List<HorarioEntidad> horarioEntidads;

    //relacion de muchos a uno con estacion
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estacion", referencedColumnName = "id_estacion")
    private EstacionEntidad id_estacion;

}
