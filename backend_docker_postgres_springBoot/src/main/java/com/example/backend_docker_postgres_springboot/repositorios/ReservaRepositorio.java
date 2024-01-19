package com.example.backend_docker_postgres_springboot.repositorios;

import com.example.backend_docker_postgres_springboot.entidades.ReservaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepositorio extends JpaRepository<ReservaEntidad, Long> {
}
