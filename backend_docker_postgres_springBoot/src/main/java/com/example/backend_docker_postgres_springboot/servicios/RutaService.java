package com.example.backend_docker_postgres_springboot.servicios;

import com.example.backend_docker_postgres_springboot.entidades.EstacionEntidad;
import com.example.backend_docker_postgres_springboot.entidades.RutaEntidad;
import com.example.backend_docker_postgres_springboot.entidades.TrenEntidad;
import com.example.backend_docker_postgres_springboot.repositorios.EstacionRepositorio;
import com.example.backend_docker_postgres_springboot.repositorios.RutaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RutaService {

    @Autowired
    public RutaRepositorio repositorio;

    @Autowired
    public EstacionRepositorio estacionRepositorio;

    //metodo para guardar con el id de la estacion:
    public RutaEntidad guardar(RutaEntidad rutaEntidad, Long id_estacion){
        //obtener el id de la estacion
        Optional<EstacionEntidad> optionalEstacionEntidad = estacionRepositorio.findById(id_estacion);
        //verificar si eiste
        if(optionalEstacionEntidad.isPresent()){
            EstacionEntidad  estacionEntidad = optionalEstacionEntidad.get();
            //asiganr la estacion al tren
            rutaEntidad.setId_estacion(estacionEntidad);
            //guardar el trne
            RutaEntidad entidadGuardar = repositorio.save(rutaEntidad);
            return entidadGuardar;
        }else{
            throw new RuntimeException("No se encontró la estacion con ID: " + id_estacion);
        }
    }
    //metodo para buscarPorId
    public RutaEntidad buscarPorId(Long id_ruta){
        RutaEntidad rutas = this.repositorio.findById(id_ruta).orElse(null);
        return rutas;
    }
    //metodo para listar
    public List<RutaEntidad>listar(){
        return repositorio.findAll();
    }

    //obtener por id
    public Optional<RutaEntidad>traerPorId(Long id_ruta){
        return repositorio.findById(id_ruta);
    }

    //eliminar
    public void eliminar(Long id_ruta){
        repositorio.deleteById(id_ruta);
    }

    //metodo para editar la ruta
    public RutaEntidad editar(RutaEntidad rutaEntidad,
                              Long id_ruta){
        RutaEntidad rutaExiste = buscarPorId(id_ruta);
        if(rutaExiste !=null){
            //actualizar los campos
            rutaExiste.setDescripcion(rutaEntidad.getDescripcion());
            rutaExiste.setDuracion_estimada(rutaEntidad.getDuracion_estimada());
            //guardar
            return repositorio.save(rutaExiste);
        }else{
            throw new RuntimeException("No se encontró la ruta con ID: " + id_ruta);

        }
    }

}
