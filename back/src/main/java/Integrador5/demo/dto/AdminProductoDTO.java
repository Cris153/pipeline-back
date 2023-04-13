package Integrador5.demo.dto;

import Integrador5.demo.entidades.Caracteristica;
import Integrador5.demo.entidades.Imagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class AdminProductoDTO {
    private  int id;
    private  int categoria_id;
    private List<Imagen> imagenes;
    private  int ciudad_id;
    private  List<Caracteristica> caracteristicas;
    private  String marca;
    private  String modelo;
    private  String descripcion;
    private  int anio;
}
