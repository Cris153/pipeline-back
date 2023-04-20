package Integrador5.demo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter

public class Ciudad {
    public Ciudad() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JsonIgnore
    @OneToMany(mappedBy = "ciudad")
    private List<Producto> productos;

    private String ciudad;
    private String provincia;

    public Ciudad(int id) {
        this.id = id;
    }
}
