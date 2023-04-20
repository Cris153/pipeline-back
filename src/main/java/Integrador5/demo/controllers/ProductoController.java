package Integrador5.demo.controllers;


import Integrador5.demo.dto.AdminProductoDTO;
import Integrador5.demo.dto.DisponibilidadDTO;
import Integrador5.demo.dto.DisponibilidadxFechasDTO;
import Integrador5.demo.entidades.Producto;
import Integrador5.demo.dto.ProductoDTO;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.servicios.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequestMapping("/producto")
@RestController
@AllArgsConstructor
public class ProductoController {

    private final ProductoService service;

    @GetMapping("/")
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/listarPorCategoria/{id}")
    public ResponseEntity<List<Producto>> listarPorCategoria(@PathVariable int id) {
        return ResponseEntity.ok(service.listarPorCategoria(id));
    }
    @GetMapping("/listarPorDisponibilidad")
    public ResponseEntity<List<Producto>> listarPorDisponibilidad(
            @RequestParam("inicioFechaReserva") LocalDate inicioFechaReserva,
            @RequestParam("finFechaReserva") LocalDate finFechaReserva,
            @RequestParam("ciudadId") int ciudadId) {

        DisponibilidadDTO disponibilidadDTO = new DisponibilidadDTO(inicioFechaReserva, finFechaReserva, ciudadId);
        return ResponseEntity.ok(service.listarPorDisponibilidad(disponibilidadDTO));
    }
    @GetMapping("/listarPorFechas")
    public ResponseEntity<List<Producto>> listarPorFechas(
            @RequestParam("inicioFechaReserva") LocalDate inicioFechaReserva,
            @RequestParam("finFechaReserva") LocalDate finFechaReserva){

        DisponibilidadxFechasDTO disponibilidadxFechasDTO = new DisponibilidadxFechasDTO(inicioFechaReserva, finFechaReserva);
        return ResponseEntity.ok(service.listarPorFechas(disponibilidadxFechasDTO));
    }
    @GetMapping("/listarPorCiudad/{id}")
    public ResponseEntity<List<Producto>> listarPorCiudad(@PathVariable int id) {
        return ResponseEntity.ok(service.listarPorCiudad(id));
    }

    @GetMapping("/productos-aleatorios")

    public ResponseEntity<List<Producto>> obtenerProductosAleatorios() {
        return ResponseEntity.ok(service.obtenerProductosAleatorios());
    }

    @PostMapping("/nuevosProductos")
    public ResponseEntity<String> agregar(@RequestBody ProductoDTO producto) throws ResourceNotFoundException {
        service.agregar(producto);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PostMapping("/crearProductos")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<String> agregar(@RequestBody AdminProductoDTO producto) throws ResourceNotFoundException {
        service.crear(producto);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarProducto")
    public ResponseEntity<String> modificar(@RequestBody AdminProductoDTO producto) throws ResourceNotFoundException{
        service.modificar(producto);
        return ResponseEntity.ok("Se modifico el producto");
    }

    @DeleteMapping("/eliminarProducto")
    public ResponseEntity<String>  eliminar(@RequestBody int id) throws ResourceNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el producto con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/contarPorCategoria/{id}")
    public int countProductosByCategoria(@PathVariable int id) {
        return service.contarPorCategoria(id);
    }
}
