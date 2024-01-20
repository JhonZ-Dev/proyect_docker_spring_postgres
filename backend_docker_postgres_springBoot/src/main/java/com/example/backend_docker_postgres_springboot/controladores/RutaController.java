package com.example.backend_docker_postgres_springboot.controladores;

import com.example.backend_docker_postgres_springboot.entidades.RutaEntidad;
import com.example.backend_docker_postgres_springboot.servicios.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ruta")
public class RutaController {

    @Autowired
    public RutaService service;


    //guardar
    @PostMapping("/guardar/{id_estacion}")
    public RutaEntidad guardarRuta(@RequestBody RutaEntidad rutaEntidad,
                                   @PathVariable Long id_estacion){
        return service.guardar(rutaEntidad, id_estacion);
    }

    //editar
    @PutMapping("/guardar/{id_ruta}")
    public RutaEntidad editarRuta(@RequestBody RutaEntidad rutaEntidad,
                                   @PathVariable Long id_ruta){
        return service.editar(rutaEntidad, id_ruta);
    }
    //traerTodas
    @GetMapping("/listarTodos")
    public List<RutaEntidad> traerTodos(){
        return service.listar();
    }

    //eliminar
    @DeleteMapping("/eliminar/{id_ruta}")
    public void eliminar(@PathVariable Long id_ruta){
        service.eliminar(id_ruta);
    }

    //taerPorId
    @GetMapping("/traer/{id_ruta}")
    public Optional<RutaEntidad> traerPorId(@PathVariable Long id_ruta){
        return service.traerPorId(id_ruta);
    }

}
