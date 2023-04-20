package Integrador5.demo.repositorios;





import Integrador5.demo.entidades.Producto;
import Integrador5.demo.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Query("SELECT r FROM Reserva r WHERE r.producto.id = :productoId")
    List<Reserva> findByProductoId(@Param("productoId") int productoId);

    @Query("SELECT r FROM Reserva r WHERE r.usuario.id = :usuarioId")
    List<Reserva> findByUsuarioId(@Param("usuarioId") int usuarioId);
}
