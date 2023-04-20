package Integrador5.demo.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthCredentials {
    private String email, password;

    public AuthCredentials() {
    }
}
