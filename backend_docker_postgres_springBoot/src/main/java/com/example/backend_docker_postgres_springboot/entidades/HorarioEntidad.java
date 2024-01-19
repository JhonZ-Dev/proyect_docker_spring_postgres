package com.example.backend_docker_postgres_springboot.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

    //relacion de uno a muchos con reservabilletes
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_horario")
    private List<ReservaEntidad> reservaEntidads;

    //relacion de muchos a uno con ruta
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ruta", referencedColumnName = "id_ruta")
    private RutaEntidad id_ruta;

    //relacion de muchos a uno con tren
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tres", referencedColumnName = "id_tren")
    private TrenEntidad id_tren;

}
