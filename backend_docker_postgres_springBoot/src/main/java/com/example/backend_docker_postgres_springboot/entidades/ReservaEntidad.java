package com.example.backend_docker_postgres_springboot.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_reservas")
@Data
public class ReservaEntidad {
    @Id
    private Long id_reserva;
    private String detalle_pasajero;
    private String num_asientos_reservados;
    private Boolean estado_reserva;
}
