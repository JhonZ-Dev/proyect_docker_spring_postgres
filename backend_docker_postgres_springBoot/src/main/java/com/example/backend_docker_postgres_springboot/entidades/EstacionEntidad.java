package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tbl_estaciones")
@Data
public class EstacionEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_estacion;
    private String nombre_estacion;
    private String ubicacion_estacion;
    private String plataformas_estacion;
    private String estacion_origen;
    private String estacion_destino;

    //relacion de uno a muchos con ruta
    @OneToMany(mappedBy = "id_ruta",cascade = CascadeType.ALL)
    private List<RutaEntidad> rutaEntidads;

    //relacion de uno a muchos con tren
    @OneToMany(mappedBy = "id_tren", cascade = CascadeType.ALL)
    private List<TrenEntidad> trenEntidads;
    


}
