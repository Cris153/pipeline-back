package Integrador5.demo.repositorios;

import Integrador5.demo.entidades.Categoria;
import Integrador5.demo.entidades.Ciudad;
import Integrador5.demo.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByCategoria(Categoria categoria);
    List<Producto> findByCiudad(Ciudad ciudad);

    @Query("SELECT p FROM Producto p " +
            "WHERE p.ciudad.id = :ciudad " +
            "AND NOT EXISTS (" +
            "  SELECT r FROM Reserva r " +
            "  WHERE r.producto = p " +
            "    AND r.inicioReserva <= :finFechaReserva " +
            "    AND r.finalizaReserva >= :inicioFechaReserva" +
            ")")
    List<Producto> getProductosDisponibles(@Param("inicioFechaReserva") LocalDate inicioFechaReserva,
                                           @Param("finFechaReserva") LocalDate finFechaReserva,
                                           @Param("ciudad") int ciudad);



    @Query("SELECT COUNT(p) FROM Producto p WHERE p.categoria.id = :categoria_id")
    int countByCategoria(@Param("categoria_id") int idCategoria);

    @Query("SELECT p FROM Producto p " +
            "WHERE NOT EXISTS (" +
            "  SELECT r FROM Reserva r " +
            "  WHERE r.producto = p " +
            "    AND r.inicioReserva <= :finFechaReserva " +
            "    AND r.finalizaReserva >= :inicioFechaReserva" +
            ")")
    List<Producto> getProductosDisponiblesXfecha(@Param("inicioFechaReserva") LocalDate inicioFechaReserva,
                                           @Param("finFechaReserva") LocalDate finFechaReserva);





}
