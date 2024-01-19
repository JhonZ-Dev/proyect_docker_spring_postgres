package com.example.backend_docker_postgres_springboot.repositorios;

import com.example.backend_docker_postgres_springboot.entidades.EstacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionRepositorio extends JpaRepository<EstacionEntidad, Long> {
}
