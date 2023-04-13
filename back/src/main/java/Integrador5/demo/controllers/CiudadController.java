package Integrador5.demo.controllers;

import Integrador5.demo.entidades.Ciudad;
import Integrador5.demo.entidades.Imagen;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.servicios.CiudadService;
import Integrador5.demo.servicios.ImagenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/ciudad")
@RestController
@AllArgsConstructor
public class CiudadController {
    private final CiudadService service;

    @GetMapping("/")
    public ResponseEntity<List<Ciudad>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/nuevasCiudades")
    public ResponseEntity<String> agregar(@RequestBody Ciudad ciudad) throws ResourceNotFoundException {
        service.agregar(ciudad);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarCiudades")
    public ResponseEntity<String> modificar(@RequestBody Ciudad ciudad) {
        service.modificar(ciudad);
        return ResponseEntity.ok("Se modifico la categoria");
    }

    @DeleteMapping("/eliminarCiudades")
    public ResponseEntity<String>  eliminar(@RequestBody int id) throws ResourceNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos la ciudad con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Ciudad>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
