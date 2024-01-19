package com.example.backend_docker_postgres_springboot.servicios;

import com.example.backend_docker_postgres_springboot.entidades.EstacionEntidad;
import com.example.backend_docker_postgres_springboot.entidades.TrenEntidad;
import com.example.backend_docker_postgres_springboot.repositorios.EstacionRepositorio;
import com.example.backend_docker_postgres_springboot.repositorios.TrenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrenService {
    @Autowired
    public TrenRepositorio repositorio;
    @Autowired
    public EstacionRepositorio estacionRepositorio;

    //metodo para guardar
    public TrenEntidad gurdarConEstacion(TrenEntidad trenEntidad,
                                         Long id_estacion){
        //Obtner el id_estacion
        Optional<EstacionEntidad> optionalEstacionEntidad = estacionRepositorio.findById(id_estacion);

        //verificar si eiste
        if(optionalEstacionEntidad.isPresent()){
            EstacionEntidad  estacionEntidad = optionalEstacionEntidad.get();
            //asiganr la estacion al tren
            trenEntidad.setId_estacion(estacionEntidad);
            //guardar el trne
            TrenEntidad entidadGuardar = repositorio.save(trenEntidad);
            return entidadGuardar;
        }else{
            throw new RuntimeException("No se encontró el usuario con ID: " + id_estacion);
        }
    }
}
