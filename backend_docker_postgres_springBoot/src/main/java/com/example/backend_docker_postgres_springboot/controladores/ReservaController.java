package com.example.backend_docker_postgres_springboot.controladores;

import com.example.backend_docker_postgres_springboot.entidades.ReservaEntidad;
import com.example.backend_docker_postgres_springboot.servicios.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservaController {

    @Autowired
    public ReservaService service;

    //metodo para guardar
    @PostMapping("/agregar/{id_horario}/{id_usuario}")
    public ReservaEntidad guardar(@RequestBody ReservaEntidad reservaEntidad,
                                  @PathVariable Long id_horario,
                                  @PathVariable Long id_usuario){
        return service.guardarConUsuarioyHorario(reservaEntidad, id_horario, id_usuario);
    }

    @PutMapping("/editar/{id_reserva}")
    public ReservaEntidad editar(@RequestBody ReservaEntidad reservaEntidad,
                                 @PathVariable Long id_reserva){
        return service.editar(reservaEntidad, id_reserva);
    }

    @GetMapping("/listar")
    public List<ReservaEntidad> listar(){
        return service.listar();
    }
    @GetMapping("/listar/{id_reserva}")
    public Optional<ReservaEntidad> listarById(@PathVariable Long id_reserva){
        return service.reservaById(id_reserva);
    }

    @DeleteMapping("/eliminar/{id_reserava}")
    public void eliminar( @PathVariable Long id_reserava){
        service.eliminar(id_reserava);
    }


}
