package Integrador5.demo.repositorios;

import Integrador5.demo.entidades.Categoria;
import Integrador5.demo.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {
}
