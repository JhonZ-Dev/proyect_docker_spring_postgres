package com.example.backend_docker_postgres_springboot.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tbl_horarios")
@Data
public class HorarioEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_horario;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dias_semana;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime hora_salida;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime hora_llegada;
}
