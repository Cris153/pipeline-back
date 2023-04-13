package Integrador5.demo.servicios;


import Integrador5.demo.dto.ReservaDTO;
import Integrador5.demo.entidades.Producto;
import Integrador5.demo.entidades.Reserva;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.repositorios.ProductoRepository;
import Integrador5.demo.repositorios.ReservaRepository;
import Integrador5.demo.repositorios.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    public void agregar(ReservaDTO reserva) throws ResourceNotFoundException {
        var producto = productoRepository.findById(reserva.productoId()).orElseThrow(()->new ResourceNotFoundException("producto con id: " + reserva.productoId() + " no encontrado"));
        var usuario = usuarioRepository.findById(reserva.usuarioId()).orElseThrow(()->new ResourceNotFoundException("usuario con id: " + reserva.usuarioId() + " no encontrado"));
       reservaRepository.save(new Reserva(reserva.id(),producto,usuario,reserva.horaInicioReserva(), reserva.inicioReserva(), reserva.FinalizaReserva()));
    }

    public List<ReservaDTO> listar()  {
        List<Reserva> reservas = reservaRepository.findAll();
        List<ReservaDTO> dtos = new ArrayList<>();
        for (Reserva reserva : reservas) {
            ReservaDTO dto = new ReservaDTO(
                    reserva.getId(),
                    reserva.getProducto().getId(),
                    reserva.getUsuario().getId(),
                    reserva.getHoraInicioReserva(),
                    reserva.getInicioReserva(),
                    reserva.getFinalizaReserva()
            );
            dtos.add(dto);
        }
        return dtos;
    }


    public void modificar(ReservaDTO reserva)throws ResourceNotFoundException{
        var producto = productoRepository.findById(reserva.productoId()).orElseThrow(()->new ResourceNotFoundException("producto con id: " + reserva.productoId() + " no encontrado"));
        var usuario = usuarioRepository.findById(reserva.usuarioId()).orElseThrow(()->new ResourceNotFoundException("cliente con id: " + reserva.usuarioId() + " no encontrado"));
        reservaRepository.save(new Reserva(reserva.id(),producto,usuario,reserva.horaInicioReserva(), reserva.inicioReserva(), reserva.FinalizaReserva()));
    }

    public void eliminar(int id) throws ResourceNotFoundException {
        reservaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La reserva con id: " + id +" no existe en la base de datos"));
        reservaRepository.deleteById(id);
    }

    public Reserva getById (int id) throws ResourceNotFoundException{
        return reservaRepository.findById(id).orElseThrow();
    }

    public List<ReservaDTO> listarPorProducto(int id){
        List<Reserva> reservas = reservaRepository.findByProductoId(id);
        List<ReservaDTO> dtos = new ArrayList<>();
        for (Reserva reserva : reservas) {
            ReservaDTO dto = new ReservaDTO(
                    reserva.getId(),
                    reserva.getProducto().getId(),
                    reserva.getUsuario().getId(),
                    reserva.getHoraInicioReserva(),
                    reserva.getInicioReserva(),
                    reserva.getFinalizaReserva()
            );
            dtos.add(dto);
        }
        return dtos;
    }
    public List<ReservaDTO> listarPorUsuario(int id){
        List<Reserva> reservas = reservaRepository.findByUsuarioId(id);
        List<ReservaDTO> dtos = new ArrayList<>();
        for (Reserva reserva : reservas) {
            ReservaDTO dto = new ReservaDTO(
                    reserva.getId(),
                    reserva.getProducto().getId(),
                    reserva.getUsuario().getId(),
                    reserva.getHoraInicioReserva(),
                    reserva.getInicioReserva(),
                    reserva.getFinalizaReserva()
            );
            dtos.add(dto);
        }
        return dtos;
    }
}
