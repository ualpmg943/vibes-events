package com.vibesevents.repository;

import com.vibesevents.entity.EstadoReserva;
import com.vibesevents.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ReservaRepository extends JpaRepository<Reserva, UUID> {
    List<Reserva> findByFechaEventoBetween(LocalDate inicio, LocalDate fin);
    long countByEstadoAndFechaEventoBetween(EstadoReserva estado, LocalDate inicio, LocalDate fin);
}
