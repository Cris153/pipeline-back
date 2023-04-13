package Integrador5.demo.controllers;

import Integrador5.demo.entidades.Categoria;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.servicios.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/categoria")
@RestController
@AllArgsConstructor
public class CategoriaController {
    private final CategoriaService service;

    @GetMapping("/")
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/nuevasCategorias")
    public ResponseEntity<String> agregar(@RequestBody Categoria categoria) throws ResourceNotFoundException {
        service.agregar(categoria);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarCategorias")
    public ResponseEntity<String> modificar(@RequestBody Categoria categoria) {
        service.modificar(categoria);
        return ResponseEntity.ok("Se modifico la categoria");
    }

    @DeleteMapping("/eliminarCategorias")
    public ResponseEntity<String>  eliminar(@RequestBody int id) throws ResourceNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos la categoria con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
