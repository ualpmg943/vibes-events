package com.vibesevents.service.impl;

import com.vibesevents.dto.DisponibilidadResponse;
import com.vibesevents.dto.ExtraRequest;
import com.vibesevents.dto.ReservaRequest;
import com.vibesevents.dto.ReservaResponse;
import com.vibesevents.entity.*;
import com.vibesevents.exception.FechaNoDisponibleException;
import com.vibesevents.exception.ReservaNotFoundException;
import com.vibesevents.repository.*;
import com.vibesevents.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PackRepository packRepository;
    private final DiaNoDisponibleRepository diaNoDisponibleRepository;

    @Override
    @Transactional(readOnly = true)
    public DisponibilidadResponse checkDisponibilidad(String mes) {
        YearMonth yearMonth;
        try {
            yearMonth = YearMonth.parse(mes, DateTimeFormatter.ofPattern("yyyy-MM"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de mes inválido. Use yyyy-MM");
        }

        LocalDate inicio = yearMonth.atDay(1);
        LocalDate fin = yearMonth.atEndOfMonth();

        List<LocalDate> fechasReservadas = reservaRepository
                .findByFechaEventoBetween(inicio, fin)
                .stream()
                .map(Reserva::getFechaEvento)
                .distinct()
                .collect(Collectors.toList());

        List<LocalDate> fechasBloqueadas = diaNoDisponibleRepository
                .findByFechaBetween(inicio, fin)
                .stream()
                .map(DiaNoDisponible::getFecha)
                .collect(Collectors.toList());

        return DisponibilidadResponse.builder()
                .fechasReservadas(fechasReservadas)
                .fechasBloqueadas(fechasBloqueadas)
                .build();
    }

    @Override
    @Transactional
    public ReservaResponse crearReserva(ReservaRequest request) {

        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseGet(() -> usuarioRepository.save(
                        Usuario.builder()
                                .email(request.getEmail())
                                .nombre(request.getNombre())
                                .telefono(request.getTelefono())
                                .build()
                ));

        Pack pack = packRepository.findById(request.getPackId())
                .orElseThrow(() -> new IllegalArgumentException("Pack no encontrado"));

        if (!disponible(request.getFechaEvento())) {
            throw new FechaNoDisponibleException(request.getFechaEvento());
        }

        BigDecimal precioTotal = pack.getPrecioBase();
        List<Extra> extras = new ArrayList<>();

        if (request.getExtras() != null) {
            for (ExtraRequest ex : request.getExtras()) {
                Extra extra = Extra.builder()
                        .tipo(ex.getTipo())
                        .nombre(ex.getNombre())
                        .descripcion(ex.getDescripcion())
                        .precioUnitario(ex.getPrecioUnitario())
                        .cantidad(ex.getCantidad())
                        .build();
                extras.add(extra);
                precioTotal = precioTotal.add(
                        ex.getPrecioUnitario().multiply(BigDecimal.valueOf(ex.getCantidad()))
                );
            }
        }

        Reserva reserva = Reserva.builder()
                .pack(pack)
                .usuario(usuario)
                .fechaEvento(request.getFechaEvento())
                .lugarEvento(request.getLugarEvento())
                .horasContratadas(request.getHorasContratadas())
                .precioTotal(precioTotal)
                .notas(request.getNotas())
                .build();

        extras.forEach(e -> e.setReserva(reserva));
        reserva.setExtras(extras);

        Reserva saved = reservaRepository.save(reserva);

        return ReservaResponse.builder()
                .id(saved.getId())
                .fechaEvento(saved.getFechaEvento())
                .estado(saved.getEstado().name())
                .precioTotal(saved.getPrecioTotal())
                .createdAt(saved.getCreatedAt())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public ReservaResponse obtenerReserva(UUID id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException(id));

        return ReservaResponse.builder()
                .id(reserva.getId())
                .fechaEvento(reserva.getFechaEvento())
                .estado(reserva.getEstado().name())
                .precioTotal(reserva.getPrecioTotal())
                .createdAt(reserva.getCreatedAt())
                .build();
    }

    private boolean disponible(LocalDate fecha) {
        List<LocalDate> reservadas = reservaRepository.findByFechaEventoBetween(fecha, fecha)
                .stream().map(Reserva::getFechaEvento).collect(Collectors.toList());
        List<LocalDate> bloqueadas = diaNoDisponibleRepository.findByFechaBetween(fecha, fecha)
                .stream().map(DiaNoDisponible::getFecha).collect(Collectors.toList());
        return Stream.concat(reservadas.stream(), bloqueadas.stream()).noneMatch(f -> f.equals(fecha));
    }
}
