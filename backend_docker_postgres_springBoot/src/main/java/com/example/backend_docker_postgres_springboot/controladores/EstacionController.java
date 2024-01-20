package com.example.backend_docker_postgres_springboot.controladores;

import com.example.backend_docker_postgres_springboot.entidades.EstacionEntidad;
import com.example.backend_docker_postgres_springboot.servicios.EstacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estaciones")
public class EstacionController {
    @Autowired
    public EstacionService service;

    @PostMapping("/guardar")
    public EstacionEntidad guardar(@RequestBody EstacionEntidad estacionEntidad){
        return service.guardar(estacionEntidad);
    }

    //editar
    @PutMapping("/editar/{idEstacion}")
    public ResponseEntity<EstacionEntidad> editarEstacion(
            @RequestBody EstacionEntidad estacionActualizada,
            @PathVariable Long idEstacion) {

        // Validar si existe la estación con el ID proporcionado
        EstacionEntidad estacionExistente = service.buscarPorId(idEstacion);
        if (estacionExistente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Actualizar los campos de la estación existente con la información proporcionada
        estacionExistente.setNombre_estacion(estacionActualizada.getNombre_estacion());
        estacionExistente.setUbicacion_estacion(estacionActualizada.getUbicacion_estacion());
        estacionExistente.setEstacion_origen(estacionActualizada.getEstacion_origen());
        estacionExistente.setEstacion_destino(estacionActualizada.getEstacion_destino());
        estacionExistente.setPlataformas_estacion(estacionActualizada.getPlataformas_estacion());
        // Guardar la estación actualizada
        EstacionEntidad estacionGuardada = service.guardar(estacionExistente);
        // Devolver la estación actualizada y un código de estado OK
        return new ResponseEntity<>(estacionGuardada, HttpStatus.OK);
    }

    //traerTodos
    @GetMapping("/listar")
    public List<EstacionEntidad> listarTodos(){
        return service.listar();
    }

    //traerPorId
    @GetMapping("/traer/{id_estacion}")
    public Optional<EstacionEntidad> traerPorId(@PathVariable Long id_estacion){
        return service.encontrarPorId(id_estacion);
    }

}
