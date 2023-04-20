package Integrador5.demo.repositorios;

import Integrador5.demo.dto.UsuarioDto;
import Integrador5.demo.entidades.Categoria;
import Integrador5.demo.entidades.Producto;
import Integrador5.demo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Optional<UsuarioDto> findOneByEmail(String email);
    @Query("SELECT u FROM Usuario u WHERE u.email = :email AND u.pass = :pass")
    Optional<Usuario> authenticate(@Param("email") String email, @Param("pass") String password);
}
