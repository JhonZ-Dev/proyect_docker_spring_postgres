package com.example.backend_docker_postgres_springboot.servicios;

import com.example.backend_docker_postgres_springboot.entidades.UsuarioEntidad;
import com.example.backend_docker_postgres_springboot.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    public UsuarioRepositorio repositorio;

    //metodo para guardar
    public UsuarioEntidad guardar(UsuarioEntidad usuarioEntidad){
      try {
          //si el usuario tiene un ID asignado es una actualizacion
          if(usuarioEntidad.getId_usuario()!=null){
              return repositorio.save(usuarioEntidad);
          }else{
              return repositorio.save(usuarioEntidad);
          }
      }catch (DataIntegrityViolationException e){
          throw new RuntimeException("Error de integridad al guardar la entidad", e);
      }
    }

    //metodo para listar
    public List<UsuarioEntidad>listar(){
        return repositorio.findAll();
    }

    //metodo para eliminar
    public void eliminar(Long id_usuario){
        repositorio.deleteById(id_usuario);
    }

    //obtenerPorSuId
    public Optional<UsuarioEntidad> encontrarPorId(Long id_usuario){
        return repositorio.findById(id_usuario);
    }


}
