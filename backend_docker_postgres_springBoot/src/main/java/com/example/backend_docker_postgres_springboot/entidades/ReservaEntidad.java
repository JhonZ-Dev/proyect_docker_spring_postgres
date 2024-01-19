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
}
