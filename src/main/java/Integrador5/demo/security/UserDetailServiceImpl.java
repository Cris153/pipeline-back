package Integrador5.demo.security;

import Integrador5.demo.dto.UsuarioDto;
import Integrador5.demo.entidades.Usuario;
import Integrador5.demo.modelo.AuthCredentials;
import Integrador5.demo.repositorios.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioDto usuario = repository
                .findOneByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("El usuario con " + email+ "no existe"));

        return new UserDetailsImpl(usuario);
    }


}
