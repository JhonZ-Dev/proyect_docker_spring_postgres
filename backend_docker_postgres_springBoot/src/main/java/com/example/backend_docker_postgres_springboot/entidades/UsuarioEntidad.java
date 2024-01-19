package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_usuarios")
@Data
public class UsuarioEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_usuario;
    private String nombre_usuario;
    private String contrasenia_usuario;
    private String rol_usuario;

}
