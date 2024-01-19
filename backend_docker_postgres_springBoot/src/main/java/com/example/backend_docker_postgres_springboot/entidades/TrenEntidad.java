package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.*;
import lombok.Data;

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
}
