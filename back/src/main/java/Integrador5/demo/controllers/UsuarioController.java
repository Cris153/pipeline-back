package Integrador5.demo.controllers;



import Integrador5.demo.dto.UsuarioDto;
import Integrador5.demo.entidades.Usuario;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.servicios.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("usuario")
@RestController
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService service;

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/nuevosUsuarios")
    public ResponseEntity<String> agregar(@RequestBody UsuarioDto usuario) throws ResourceNotFoundException {
        service.agregar(usuario);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }

    @PutMapping("/modificarUsuario")
    public ResponseEntity<String> modificar(@RequestBody Usuario usuario) {
        service.modificar(usuario);
        return ResponseEntity.ok("Se modifico el usuario correctamente");
    }

    @DeleteMapping("/eliminarUsuario")
    public ResponseEntity<String>  eliminar(@RequestBody int id) throws ResourceNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos el usuario con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/obtenerPorEmail/{email}")
    public ResponseEntity<Optional<UsuarioDto>> getByEmail(@PathVariable String email){
        return  ResponseEntity.ok(service.getByEmail(email));
    }
}
