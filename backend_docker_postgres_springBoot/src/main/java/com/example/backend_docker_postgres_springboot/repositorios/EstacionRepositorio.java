package com.example.backend_docker_postgres_springboot.repositorios;

import com.example.backend_docker_postgres_springboot.entidades.EstacionEntidad;
import
        org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionRepositorio extends JpaRepository<EstacionEntidad, Long> {
}
