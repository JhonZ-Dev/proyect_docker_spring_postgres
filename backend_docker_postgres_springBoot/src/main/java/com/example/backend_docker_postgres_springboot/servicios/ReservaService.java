package com.example.backend_docker_postgres_springboot.servicios;

import com.example.backend_docker_postgres_springboot.entidades.HorarioEntidad;
import com.example.backend_docker_postgres_springboot.entidades.ReservaEntidad;
import com.example.backend_docker_postgres_springboot.entidades.UsuarioEntidad;
import com.example.backend_docker_postgres_springboot.repositorios.HorarioRepositorio;
import com.example.backend_docker_postgres_springboot.repositorios.ReservaRepositorio;
import com.example.backend_docker_postgres_springboot.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    public ReservaRepositorio repositorio;
    @Autowired
    public UsuarioRepositorio user_repo;
    @Autowired
    public HorarioRepositorio hora_repo;

    //metodo para guardar un repositorio con su usuario
    public ReservaEntidad guardarConUsuario(ReservaEntidad reserva,
                                            Long id_usuario,
                                            Long id_horario){
        //obtener el usuario por su ID
        Optional<UsuarioEntidad> usuarioEntidadOptional = user_repo.findById(id_usuario);
        Optional<HorarioEntidad> horarioEntidadOptional = hora_repo.findById(id_horario);
        //verificar si existe
        if(usuarioEntidadOptional.isPresent() &&horarioEntidadOptional.isPresent()){
            UsuarioEntidad entidad = usuarioEntidadOptional.get();
            HorarioEntidad hEntidad = horarioEntidadOptional.get();
            //asignar el usuario a la reserva
            reserva.setId_usuario(entidad);
            reserva.setId_horario(hEntidad);
            //guardar la reserva y propagar los cambios al usuario
            ReservaEntidad entidadGuardada = repositorio.save(reserva);
            return entidadGuardada;
        }else{
            throw new RuntimeException("No se encontró el usuario con ID: " + id_usuario);

        }
    }

    //editar
    public ReservaEntidad editar(ReservaEntidad reservaEntidad, Long id_reserva){
        //validar si existe id
        ReservaEntidad reservaExiste = buscarPorId(id_reserva);
        if(reservaExiste !=null){
            //actualizar los campos
            reservaExiste.setDetalle_pasajero(reservaEntidad.getDetalle_pasajero());
            reservaExiste.setNum_asientos_reservados(reservaEntidad.getNum_asientos_reservados());
            reservaExiste.setEstado_reserva(reservaEntidad.getEstado_reserva());

            //guardar
            return repositorio.save(reservaExiste);

        }else {
            throw new RuntimeException("No se encontró la reserva con ID: " + id_reserva);

        }
    }


    //buscarPorId
    public ReservaEntidad buscarPorId(Long id_reserva){
        ReservaEntidad reserva = this.repositorio.findById(id_reserva).orElse(null);
        return reserva;
    }

    //listar
    public List<ReservaEntidad> listar(){
        return repositorio.findAll();
    }

    //eliminar
    public void eliminar(Long id_reserva){
        repositorio.deleteById(id_reserva);
    }

    //traerPorId
    public Optional<ReservaEntidad> reservaById(Long id_reserva){
        return repositorio.findById(id_reserva);
    }
}
