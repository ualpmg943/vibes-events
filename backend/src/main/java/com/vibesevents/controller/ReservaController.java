package com.vibesevents.controller;

import com.vibesevents.dto.DisponibilidadResponse;
import com.vibesevents.dto.ReservaRequest;
import com.vibesevents.dto.ReservaResponse;
import com.vibesevents.service.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping("/disponibilidad")
    public ResponseEntity<DisponibilidadResponse> checkDisponibilidad(
            @RequestParam("mes") String mes) {
        DisponibilidadResponse response = reservaService.checkDisponibilidad(mes);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ReservaResponse> crearReserva(
            @Valid @RequestBody ReservaRequest request) {
        ReservaResponse response = reservaService.crearReserva(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponse> obtenerReserva(
            @PathVariable UUID id) {
        ReservaResponse response = reservaService.obtenerReserva(id);
        return ResponseEntity.ok(response);
    }
}
