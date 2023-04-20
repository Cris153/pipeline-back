package Integrador5.demo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



@Entity
@AllArgsConstructor
@Getter
@Setter
public class Categoria {

    public Categoria(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL)
    private List<Producto> productos;

    private String titulo;
    private String descripcion;

    private String url_imagen;

    public Categoria(int id) {
        this.id = id;
    }
}
