package com.example.backend_docker_postgres_springboot.servicios;

import com.example.backend_docker_postgres_springboot.entidades.EstacionEntidad;
import com.example.backend_docker_postgres_springboot.repositorios.EstacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionService {
    @Autowired
    public EstacionRepositorio repositorio;

    //metodo para guardar y editar
    public EstacionEntidad guardar(EstacionEntidad estacionEntidad) {
        try {
            //verificar si la estacion ya tiene asiganado un ID
            if(estacionEntidad.getId_estacion() !=null){
                return repositorio.save(estacionEntidad);
            }else{
                return repositorio.save(estacionEntidad);
            }

        }catch ( DataIntegrityViolationException e){
            throw new RuntimeException("Error de integridad al guardar la entidad", e);

        }
    }

    //metodo para listar
    public List<EstacionEntidad> listar(){
        return repositorio.findAll();
    }

    //metodo para traer por id
    public Optional<EstacionEntidad> encontrarPorId(Long id_estacion){
        return repositorio.findById(id_estacion);
    }

    //metodo para eliminar
    public void elimina(Long id_estacion){
        repositorio.deleteById(id_estacion);
    }

}
