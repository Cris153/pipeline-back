package Integrador5.demo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Reserva {
    public Reserva() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    private Producto producto;
    @ManyToOne(cascade=CascadeType.ALL)
    private Usuario usuario;

    private Time horaInicioReserva;
    private LocalDate inicioReserva;
    private LocalDate finalizaReserva;



}
