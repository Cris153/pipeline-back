package Integrador5.demo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rol {
    public Rol() {
    }

    @Id
    private int id;
    private String nombre;
}
