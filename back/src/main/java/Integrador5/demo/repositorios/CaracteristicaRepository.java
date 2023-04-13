package Integrador5.demo.repositorios;

import Integrador5.demo.entidades.Caracteristica;
import Integrador5.demo.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica,Integer> {
}
