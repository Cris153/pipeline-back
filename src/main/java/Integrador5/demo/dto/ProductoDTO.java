package Integrador5.demo.dto;

import Integrador5.demo.entidades.Caracteristica;
import Integrador5.demo.entidades.Imagen;
import Integrador5.demo.entidades.Producto;
import Integrador5.demo.entidades.Reserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public  class ProductoDTO {
    private  int id;
    private  int categoria_id;
    private  List<Integer> imagenes_id;
    private  int ciudad_id;
    private  List<Integer> caracteristica_id;
    private  String marca;
    private  String modelo;
    private  String descripcion;
    private  int anio;


    public ProductoDTO() {

    }
    public static ProductoDTO toDto(Producto producto){
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setCategoria_id(producto.getCategoria().getId());
        dto.setImagenes_id(producto.getImagenes().stream().map(Imagen::getId).collect(Collectors.toList()));
        dto.setCiudad_id(producto.getCiudad().getId());
        dto.setCaracteristica_id(producto.getCaracteristica().stream().map(Caracteristica::getId).collect(Collectors.toList()));
        dto.setMarca(producto.getMarca());
        dto.setModelo(producto.getModelo());
        dto.setDescripcion(producto.getDescripcion());
        dto.setAnio(producto.getAnio());

        return dto;
    }


}