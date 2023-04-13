package Integrador5.demo.controllers;



import Integrador5.demo.dto.ReservaDTO;
import Integrador5.demo.entidades.Reserva;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.servicios.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/reserva")
@RestController
@AllArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;


    @GetMapping("/")
    public ResponseEntity<List<ReservaDTO>> listar() {

        return ResponseEntity.ok(reservaService.listar());
    }

   @GetMapping("/listarPorProducto/{id}")
    public ResponseEntity<List<ReservaDTO>> listarPorProducto(@PathVariable int id) {
        return ResponseEntity.ok(reservaService.listarPorProducto(id));
    }
    @GetMapping("/listarPorUsuario/{id}")
    public ResponseEntity<List<ReservaDTO>> listarPorUsuario(@PathVariable int id) {
        return ResponseEntity.ok(reservaService.listarPorUsuario(id));
    }

    @PostMapping("/nuevasReservas")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<String> agregar(@RequestBody ReservaDTO reserva) throws ResourceNotFoundException {
        reservaService.agregar(reserva);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarReserva")
    public ResponseEntity<String> modificar(@RequestBody ReservaDTO reserva) throws ResourceNotFoundException{
        reservaService.modificar(reserva);
        return ResponseEntity.ok("Se modifico la reserva");
    }

    @DeleteMapping("/eliminarReserva")
    public ResponseEntity<String>  eliminar(@RequestBody int id) throws ResourceNotFoundException {
        reservaService.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos la reserva con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getById(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(reservaService.getById(id));
    }

}
