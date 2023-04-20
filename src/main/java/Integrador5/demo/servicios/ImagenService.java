package Integrador5.demo.servicios;

import Integrador5.demo.entidades.Ciudad;
import Integrador5.demo.entidades.Imagen;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.repositorios.CiudadRepository;
import Integrador5.demo.repositorios.ImagenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ImagenService {
    private final ImagenRepository repository;

    public void agregar(Imagen imagen) throws ResourceNotFoundException {
        repository.save(imagen);
    }

    public List<Imagen> listar()  {
        return repository.findAll();
    }

    public void modificar(Imagen imagen){
        repository.save(imagen);
    }

    public void eliminar(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La imagen con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Imagen getById (int id)throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow();
    }
}
