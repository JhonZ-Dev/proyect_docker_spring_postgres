package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbls_estaciones")
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


}
