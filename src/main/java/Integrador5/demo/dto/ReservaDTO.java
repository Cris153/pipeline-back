package Integrador5.demo.dto;

import Integrador5.demo.entidades.Producto;

import java.sql.Time;
import java.time.LocalDate;

public record ReservaDTO (int id, int productoId, int usuarioId, Time horaInicioReserva, LocalDate inicioReserva, LocalDate FinalizaReserva) {
}
