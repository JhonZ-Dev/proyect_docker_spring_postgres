package com.example.backend_docker_postgres_springboot.controladores;

import com.example.backend_docker_postgres_springboot.entidades.HorarioEntidad;
import com.example.backend_docker_postgres_springboot.servicios.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HorarioController {

    @Autowired
    public HorarioService service;

    //guardar
    @PostMapping("/guardar/{id_ruta}/{id_tren}")
    public HorarioEntidad guardar(@RequestBody HorarioEntidad horarioEntidad,
                                  @PathVariable Long id_ruta,
                                  @PathVariable Long id_tren){
        return service.guardarConTrenYRuta(horarioEntidad, id_ruta, id_tren);
    }
    //editar
    @PutMapping("/editar/{id_horario}")
    public HorarioEntidad editar(@RequestBody HorarioEntidad horarioEntidad,
                                  @PathVariable Long id_horario){
        return service.editar(horarioEntidad, id_horario);
    }

    //listar
    @GetMapping("/traer")
    public List<HorarioEntidad> traerTodos(){
        return service.listar();
    }

    //eliminar
    @DeleteMapping("/eliminar/{id_horario}")
    public void eliminar(@PathVariable Long id_horario){
        service.eliminar(id_horario);
    }

    //encontrarPorId
    @GetMapping("/traerPorId/{id_horario}")
    public Optional<HorarioEntidad> traerPorId(@PathVariable Long id_horario){
        return service.horarioById(id_horario);
    }
}
