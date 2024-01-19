package com.example.backend_docker_postgres_springboot.repositorios;

import com.example.backend_docker_postgres_springboot.entidades.HorarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepositorio extends JpaRepository<HorarioEntidad, Long> {
}
