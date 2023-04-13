package Integrador5.demo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity

@AllArgsConstructor
@Getter
@Setter
public class Caracteristica {
    public Caracteristica(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String color;
    private int puertas;
    private Boolean bloqueoNinios;
    private Boolean gps;
    private String combustible;
    private Boolean modoConduccion;
    private int airbag;
    private Boolean faroCurva;


}
