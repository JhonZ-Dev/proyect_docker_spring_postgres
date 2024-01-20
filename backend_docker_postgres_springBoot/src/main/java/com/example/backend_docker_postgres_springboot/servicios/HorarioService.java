package com.example.backend_docker_postgres_springboot.servicios;

import com.example.backend_docker_postgres_springboot.entidades.HorarioEntidad;
import com.example.backend_docker_postgres_springboot.entidades.RutaEntidad;
import com.example.backend_docker_postgres_springboot.entidades.TrenEntidad;
import com.example.backend_docker_postgres_springboot.repositorios.HorarioRepositorio;
import com.example.backend_docker_postgres_springboot.repositorios.RutaRepositorio;
import com.example.backend_docker_postgres_springboot.repositorios.TrenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {
    @Autowired
    public HorarioRepositorio repositorio;

    @Autowired
    public RutaRepositorio rutaRepositorio;
    @Autowired
    public TrenRepositorio trenRepositorio;

    //metodo para guardar
    public HorarioEntidad guardarConTrenYRuta(HorarioEntidad horarioEntidad,
                                              Long id_ruta,
                                              Long id_tren){
        //optener la ruta y el tren por su ID
        Optional<RutaEntidad> rutaEntidadOptional = rutaRepositorio.findById(id_ruta);
        Optional<TrenEntidad> trenEntidadOptional = trenRepositorio.findById(id_tren);
        //verificar si existe
        if(rutaEntidadOptional.isPresent() && trenEntidadOptional.isPresent()){
            RutaEntidad rutaEntidad = rutaEntidadOptional.get();
            TrenEntidad trenEntidad = trenEntidadOptional.get();
            //asighnar a sus ID
            horarioEntidad.setId_ruta(rutaEntidad);
            horarioEntidad.setId_tren(trenEntidad);
            //guardar
            HorarioEntidad entidadGuardar = repositorio.save(horarioEntidad);
            return entidadGuardar;
        }else{
            throw new RuntimeException("No se encontró el id ruta con ID: " + id_ruta + "Id tren:   "+  id_tren);

        }
    }




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

    //metodo para buscarPorSuId
    public HorarioEntidad buscarPorId(Long id_horario){
        HorarioEntidad horarioEntidad = this.repositorio.findById(id_horario).orElse(null);
        return horarioEntidad;
    }

    //metodo para editar
    public HorarioEntidad editar(HorarioEntidad horarioEntidad, Long id_horario){
        //validar si existe
        HorarioEntidad horarioExiste = buscarPorId(id_horario);
        if(horarioExiste !=null){
            //actualiza los campos
            horarioExiste.setDias_semana(horarioEntidad.getDias_semana());
            horarioExiste.setHora_salida(horarioEntidad.getHora_salida());
            horarioExiste.setHora_llegada(horarioEntidad.getHora_llegada());
            return repositorio.save(horarioExiste);
        }else{
            throw new RuntimeException("No se encontró el horario con ID: " + id_horario);

        }

    }




}
