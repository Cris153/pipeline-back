package Integrador5.demo.controllers;

import Integrador5.demo.entidades.Categoria;
import Integrador5.demo.entidades.Imagen;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.modelo.AuthCredentials;
import Integrador5.demo.modelo.AuthResponse;
import Integrador5.demo.security.SecurityService;
import Integrador5.demo.security.TokenUtils;
import Integrador5.demo.servicios.CategoriaService;
import Integrador5.demo.servicios.ImagenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/imagen")
@RestController
@AllArgsConstructor
public class ImagenController {
    private final ImagenService service;
    private SecurityService securityService;
    @GetMapping("/")
    public ResponseEntity<List<Imagen>> listar(@RequestBody AuthCredentials authCredentials) {
        final UserDetails userDetails = securityService.validation(authCredentials);
        final String jwt = TokenUtils.createToken(userDetails);

        return ResponseEntity.ok(service.listar());
    }

    @PostMapping("/nuevasImagenes")
    public ResponseEntity<String> agregar(@RequestBody Imagen imagen) throws ResourceNotFoundException {
        service.agregar(imagen);
        return ResponseEntity.ok("Se agregó a la base de datos");
    }



    @PutMapping("/modificarImagenes")
    public ResponseEntity<String> modificar(@RequestBody Imagen imagen) {
        service.modificar(imagen);
        return ResponseEntity.ok("Se modifico la categoria");
    }

    @DeleteMapping("/eliminarImagenes")
    public ResponseEntity<String>  eliminar(@RequestBody int id) throws ResourceNotFoundException {
        service.eliminar(id);
        return ResponseEntity.ok("Se eliminó de la base de datos la imagen con id: " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> getById(@PathVariable int id)throws ResourceNotFoundException {
        return ResponseEntity.ok(service.getById(id));
    }

}
