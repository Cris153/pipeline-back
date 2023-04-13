package Integrador5.demo.servicios;

import Integrador5.demo.dto.UsuarioDto;
import Integrador5.demo.entidades.Rol;
import Integrador5.demo.entidades.Usuario;
import Integrador5.demo.exeptions.ResourceNotFoundException;
import Integrador5.demo.repositorios.RolRepository;
import Integrador5.demo.repositorios.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    private final PasswordEncoder bCryptPasswordEncoder;
    private final RolRepository rolRepository;
    public void agregar(UsuarioDto usuario) throws ResourceNotFoundException {
        usuario.setPass(bCryptPasswordEncoder.encode(usuario.getPass()));
        Rol rol = rolRepository.findById(usuario.getRolId())
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setApellido(usuario.getApellido());
        nuevoUsuario.setEmail(usuario.getEmail());
        nuevoUsuario.setPass(usuario.getPass());
        nuevoUsuario.setRol(rol);

        repository.save(nuevoUsuario);
    }


    public List<Usuario> listar()  {
        return repository.findAll();
    }

    public void modificar(Usuario usuario){
        repository.save(usuario);
    }

    public void eliminar(int id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El usuario con id: " + id +" no existe en la base de datos"));
        repository.deleteById(id);
    }

    public Optional<Usuario> getById (int id) {return repository.findById(id);
    }

    public Optional<UsuarioDto> getByEmail (String email){
        return repository.findOneByEmail(email);
    }



}
