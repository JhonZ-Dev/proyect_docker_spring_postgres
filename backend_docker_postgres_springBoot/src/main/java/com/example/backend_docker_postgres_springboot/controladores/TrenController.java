package com.example.backend_docker_postgres_springboot.controladores;

import com.example.backend_docker_postgres_springboot.entidades.EstacionEntidad;
import com.example.backend_docker_postgres_springboot.entidades.TrenEntidad;
import com.example.backend_docker_postgres_springboot.servicios.TrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tren")
public class TrenController {

    @Autowired
    public TrenService service;

    //metodo para guardar
    @PostMapping("/guardar/{id_estacion}")
    public TrenEntidad guardar(@RequestBody TrenEntidad trenEntidad,
                               @PathVariable Long id_estacion){
       return service.gurdarConEstacion(trenEntidad, id_estacion);
    }

    //metodo para editar
    @PutMapping("/editar/{id_tren}")
    public TrenEntidad editarTren(@RequestBody TrenEntidad trenEntidad,
                                  @PathVariable Long id_tren){
        return service.editarTren(trenEntidad, id_tren);
    }

    //traerTodos
    @GetMapping("/listar")
    public List<TrenEntidad> listar(){
        return service.listar();
    }

    //obtenerPorId
    public Optional<TrenEntidad> encontrarPorId(@PathVariable Long id_tren)
    {
        return service.encontrarPorId(id_tren);
    }

    //eliminar
    @DeleteMapping("/eliminar/{id_tren}")
    public void eliminarTren(Long id_tren){
        service.eliminar(id_tren);
    }
}
