package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_reservas")
@Data
public class ReservaEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_reserva;
    private String detalle_pasajero;
    private String num_asientos_reservados;
    private Boolean estado_reserva;

    //muchos a uno con usuariso
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private UsuarioEntidad id_usuario;


    //muchos a uno con id horario
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario")
    private HorarioEntidad id_horario;
}
