package Integrador5.demo.servicios;

import Integrador5.demo.entidades.Caracteristica;
import Integrador5.demo.entidades.Ciudad;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.repositorios.CaracteristicaRepository;
import Integrador5.demo.repositorios.CiudadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CaracteristicaService {
    private final CaracteristicaRepository repository;

    public void agregar(Caracteristica caracteristica) throws ResourceNotFoundException {
        repository.save(caracteristica);
    }

    public List<Caracteristica> listar()  {
        return repository.findAll();
    }

    public void modificar(Caracteristica caracteristica){
        repository.save(caracteristica);
    }

    public void eliminar(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("La caracteristica con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Caracteristica getById (int id) throws ResourceNotFoundException{
        return repository.findById(id).orElseThrow();
    }
}
