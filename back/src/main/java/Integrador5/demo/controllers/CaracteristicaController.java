package Integrador5.demo.controllers;

import Integrador5.demo.entidades.Caracteristica;
import Integrador5.demo.entidades.Ciudad;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.servicios.CaracteristicaService;
import Integrador5.demo.servicios.CiudadService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/caracteristica")
@RestController
@AllArgsConstructor
public class CaracteristicaController {
    private final CaracteristicaService service;

    @GetMapping("/")
    public ResponseEntity<List<Caracteristica>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/nuevasCaracteristicas")
    public ResponseEntity<String> agregar(@RequestBody Caracteristica caracteristica) throws ResourceNotFoundException {
        service.agregar(caracteristica);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarCaracteristicas")
    public ResponseEntity<String> modificar(@RequestBody Caracteristica caracteristica) {
        service.modificar(caracteristica);
        return ResponseEntity.ok("Se modifico la categoria");
    }

    @DeleteMapping("/eliminarCaracteristicas")
    public ResponseEntity<String>  eliminar(@RequestBody int id) throws ResourceNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos la caracteristica con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caracteristica> getById(@PathVariable int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.getById(id));
    }
}
