package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="tbl_rutas")
@Data
public class RutaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_ruta;
    private String descripcion;
    private String duracion_estimada;

}
