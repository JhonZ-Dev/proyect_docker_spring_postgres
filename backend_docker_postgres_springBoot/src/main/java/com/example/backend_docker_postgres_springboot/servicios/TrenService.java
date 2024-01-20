package com.example.backend_docker_postgres_springboot.servicios;

import com.example.backend_docker_postgres_springboot.entidades.EstacionEntidad;
import com.example.backend_docker_postgres_springboot.entidades.ReservaEntidad;
import com.example.backend_docker_postgres_springboot.entidades.TrenEntidad;
import com.example.backend_docker_postgres_springboot.repositorios.EstacionRepositorio;
import com.example.backend_docker_postgres_springboot.repositorios.TrenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    //metodo para editar
    public TrenEntidad editarTren(TrenEntidad trenEntidad,
                                  Long id_tren){
        //verificar que existe el id del tren
        TrenEntidad trenExiste = buscarPorId(id_tren);
        if(trenExiste !=null){
            //actualizar los campos
            trenExiste.setModelo_tren(trenEntidad.getModelo_tren());
            trenExiste.setCapacidad(trenEntidad.getCapacidad());
            trenExiste.setEstado(trenEntidad.getEstado());
            //guardar
            return  repositorio.save(trenExiste);
        }else{
            throw new RuntimeException("No se encontró la reserva con ID: " + id_tren);

        }
    }

    public TrenEntidad buscarPorId(Long id_tren){
        TrenEntidad trenes = this.repositorio.findById(id_tren).orElse(null);
        return trenes;
    }

    //obtener por id
    public Optional<TrenEntidad> encontrarPorId(Long id_tren){
        return repositorio.findById(id_tren);
    }

    //listar
    public List<TrenEntidad> listar(){
        return repositorio.findAll();
    }

    //eliminar por id
    public void eliminar(Long id_tren){
        repositorio.deleteById(id_tren);
    }
}
