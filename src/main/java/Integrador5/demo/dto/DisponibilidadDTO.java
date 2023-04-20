package Integrador5.demo.dto;

import java.time.LocalDate;

public record DisponibilidadDTO(LocalDate inicioFechaReserva, LocalDate finFechaReserva, int ciudadId) {
}
