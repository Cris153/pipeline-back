package Integrador5.demo.servicios;

import Integrador5.demo.entidades.Ciudad;
import Integrador5.demo.entidades.Producto;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.repositorios.CiudadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CiudadService {
    private final CiudadRepository repository;

    public void agregar(Ciudad ciudad) throws ResourceNotFoundException {
        repository.save(ciudad);
    }

    public List<Ciudad> listar()  {
        return repository.findAll();
    }

    public void modificar(Ciudad ciudad){
        repository.save(ciudad);
    }

    public void eliminar(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La ciudad con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Optional<Ciudad> getById (int id){
        return repository.findById(id);
    }
}
