package com.example.backend_docker_postgres_springboot.servicios;

import com.example.backend_docker_postgres_springboot.repositorios.EstacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstacionService {
    @Autowired
    public EstacionRepositorio repositorio;

}
