package Integrador5.demo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Producto {
    public Producto(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    private  Categoria categoria;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private List<Imagen> imagenes;

    @ManyToOne(cascade=CascadeType.ALL)
    private Ciudad ciudad;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private List<Caracteristica> caracteristica;


    private String marca;
    private String modelo;
    private String descripcion;
    private int anio;




}
