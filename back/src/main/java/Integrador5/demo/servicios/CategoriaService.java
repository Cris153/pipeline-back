package Integrador5.demo.servicios;

import Integrador5.demo.entidades.Categoria;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.repositorios.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    public void agregar(Categoria categoria) throws ResourceNotFoundException {
        repository.save(categoria);

    }

    public List<Categoria> listar()  {
        return repository.findAll();
    }

    public void modificar(Categoria categoria){
        repository.save(categoria);
    }

    public void eliminar(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La categoria con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Optional<Categoria> getById (int id){

        return repository.findById(id);
    }

}
