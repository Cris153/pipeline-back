package Integrador5.demo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario implements UserDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String nombre, apellido, email, pass;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "rol_id")
        private Rol rol;
        public Usuario(int id, String nombre, String apellido, String email, String pass,Rol rol) {
                this.id = id;
                this.nombre = nombre;
                this.apellido = apellido;
                this.email = email;
                this.pass = pass;
                this.rol = rol;
        }


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> roles = new ArrayList<>();
                return new ArrayList<GrantedAuthority>();
        }


        @Override
        public String getPassword() {
                return pass;
        }

        @Override
        public String getUsername() {
                return email;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}
