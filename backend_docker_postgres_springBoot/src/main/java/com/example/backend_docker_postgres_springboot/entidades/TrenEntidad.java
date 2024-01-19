package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tbl_trenes")
@Data
public class TrenEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_tren;
    private String modelo_tren;
    private String capacidad;
    private Boolean estado;

    //relacion de muchos a uno con estacion
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estacion", referencedColumnName = "id_estacion")
    private EstacionEntidad id_estacion;

    //relacion de one a muchos con horario
    @OneToMany(mappedBy = "id_horario", cascade = CascadeType.ALL)
    private List<HorarioEntidad> horarioEntidadList;

}
