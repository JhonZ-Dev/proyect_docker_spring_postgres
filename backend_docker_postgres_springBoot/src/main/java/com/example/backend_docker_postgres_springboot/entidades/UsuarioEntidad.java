package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    //relacion de uno a muchos con reserva billetes
    @OneToMany(mappedBy = "id_reserva", cascade = CascadeType.ALL)
    private List<ReservaEntidad> reservaEntidads;



}
