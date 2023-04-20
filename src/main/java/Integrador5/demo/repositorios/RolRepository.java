package Integrador5.demo.repositorios;

import Integrador5.demo.entidades.Rol;
import Integrador5.demo.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findById(int id);
}
