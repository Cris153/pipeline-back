package Integrador5.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDto {
    private int id;
    private String nombre, apellido, email, pass;
    private int rolId;
}
