package com.example.backend_docker_postgres_springboot.controladores;

import com.example.backend_docker_postgres_springboot.entidades.EstacionEntidad;
import com.example.backend_docker_postgres_springboot.entidades.UsuarioEntidad;
import com.example.backend_docker_postgres_springboot.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    public UsuarioService service;


    //guardar
    @PostMapping("/guardar")
    public UsuarioEntidad guardar(@RequestBody UsuarioEntidad usuarioEntidad){
        return service.guardar(usuarioEntidad);
    }

    @PutMapping("/editar/{id_usuario}")
    public ResponseEntity<UsuarioEntidad> editar(@RequestBody UsuarioEntidad usuarioActualizado,
                                                 @PathVariable Long id_usuario)
    {
        ////validar si existe el usuario
        UsuarioEntidad usuarioExiste = service.encontrarPorId(id_usuario).orElse(null);
        if(usuarioExiste == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //ACTUALIZAR
        usuarioExiste.setNombre_usuario(usuarioActualizado.getNombre_usuario());
        usuarioExiste.setContrasenia_usuario(usuarioActualizado.getContrasenia_usuario());
        usuarioExiste.setRol_usuario(usuarioActualizado.getRol_usuario());
        //guardar
        UsuarioEntidad usuarioGuardar = service.guardar(usuarioExiste);
        return new ResponseEntity<>(usuarioGuardar, HttpStatus.OK);
    }

    @GetMapping("/listat")
    public List<UsuarioEntidad> listar(){
        return service.listar();
    }
    @GetMapping("/traer/{id_usuario}")
    public Optional<UsuarioEntidad> traerPorrId(@PathVariable Long id_usuario){
        return service.encontrarPorId(id_usuario);
    }

    @DeleteMapping("/eliminar/{id_usuario}")
    public void eliminar(@PathVariable Long id_usuario){
        service.eliminar(id_usuario);
    }
}
