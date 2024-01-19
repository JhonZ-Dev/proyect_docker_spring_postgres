package com.example.backend_docker_postgres_springboot.servicios;

import com.example.backend_docker_postgres_springboot.entidades.HorarioEntidad;
import com.example.backend_docker_postgres_springboot.repositorios.HorarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {
    @Autowired
    public HorarioRepositorio repositorio;

    //metodo para guardar



    //generar por su ID
    public Optional<HorarioEntidad> horarioById(Long id_horario){
        return repositorio.findById(id_horario);
    }


    //listar
    public List<HorarioEntidad> listar(){
        return repositorio.findAll();
    }

    public void eliminar(Long id_horario){
        repositorio.deleteById(id_horario);
    }
}
