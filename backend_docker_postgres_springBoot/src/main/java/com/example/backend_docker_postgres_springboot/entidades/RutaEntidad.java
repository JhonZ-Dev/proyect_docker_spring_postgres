package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.*;

@Entity
@Table(name ="tbl_rutas")
public class RutaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_ruta;


}
