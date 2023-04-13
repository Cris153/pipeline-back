package Integrador5.demo.servicios;


import Integrador5.demo.dto.AdminProductoDTO;
import Integrador5.demo.dto.DisponibilidadDTO;
import Integrador5.demo.dto.DisponibilidadxFechasDTO;
import Integrador5.demo.dto.ProductoDTO;
import Integrador5.demo.entidades.*;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.repositorios.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ProductoService {

    private final ProductoRepository repository;
    private final CategoriaService categoriaService;
    private final CiudadService ciudadService;
    private final CaracteristicaService caracteristicaService;
    private final ImagenService imagenService;



    public void agregar(ProductoDTO producto) throws ResourceNotFoundException {
        var categoria = categoriaService.getById(producto.getCategoria_id()).orElseThrow();
        var ciudad = ciudadService.getById(producto.getCiudad_id()).orElseThrow();
        var caracteristicas =  new ArrayList<Caracteristica>();
        for (Integer id: producto.getCaracteristica_id()) {
            var caracterisica = caracteristicaService.getById(id);
            caracteristicas.add(caracterisica);
        }
        var imagenes = new ArrayList<Imagen>();
        for (Integer id: producto.getImagenes_id()) {
            var imagen = imagenService.getById(id);
            imagenes.add(imagen);
        }



        repository.save(new Producto(producto.getId(),categoria, imagenes,ciudad,caracteristicas,producto.getMarca(),
                producto.getModelo(),producto.getDescripcion(),producto.getAnio()));

    }
    public void crear(AdminProductoDTO producto) throws ResourceNotFoundException {
        var categoria = categoriaService.getById(producto.getCategoria_id()).orElseThrow();
        var ciudad = ciudadService.getById(producto.getCiudad_id()).orElseThrow();

        repository.save(new Producto(producto.getId(),categoria,producto.getImagenes() ,ciudad,producto.getCaracteristicas(),producto.getMarca(),
                producto.getModelo(),producto.getDescripcion(),producto.getAnio()));

    }

    public List<Producto> listar(){
       return  repository.findAll();
    }


    public void modificar(AdminProductoDTO producto) throws ResourceNotFoundException {
        var categoria = categoriaService.getById(producto.getCategoria_id()).orElseThrow();
        var ciudad = ciudadService.getById(producto.getCiudad_id()).orElseThrow();

        repository.save(new Producto(producto.getId(),categoria,producto.getImagenes() ,ciudad,producto.getCaracteristicas(),producto.getMarca(),
                producto.getModelo(),producto.getDescripcion(),producto.getAnio()));

    }

    

    public void eliminar(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El producto con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public List<Producto> listarPorCategoria(int id){
        return repository.findByCategoria(new Categoria(id));
    }
    public List<Producto> listarPorCiudad(int id){
        return repository.findByCiudad(new Ciudad(id));
    }
    public List<Producto> obtenerProductosAleatorios(){
        List<Producto> productos = repository.findAll();
        Collections.shuffle(productos);
        return productos.subList(0, Math.min(productos.size(), 8));
    }

    public List<Producto> listarPorDisponibilidad(DisponibilidadDTO disponibilidadDTO){
        return repository.getProductosDisponibles(disponibilidadDTO.inicioFechaReserva(), disponibilidadDTO.finFechaReserva(), disponibilidadDTO.ciudadId());

    }

    public List<Producto> listarPorFechas(DisponibilidadxFechasDTO disponibilidadxFechasDTO){
        return repository.getProductosDisponiblesXfecha(disponibilidadxFechasDTO.inicioFechaReserva(), disponibilidadxFechasDTO.finFechaReserva());
    }

    public int contarPorCategoria(int categoriaId){
       return  repository.countByCategoria(categoriaId);
    }



    public Optional<Producto> getById (int id){
        return repository.findById(id);
    }

}
