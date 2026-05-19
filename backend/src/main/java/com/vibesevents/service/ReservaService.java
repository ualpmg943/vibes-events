package com.vibesevents.service;

import com.vibesevents.dto.DisponibilidadResponse;
import com.vibesevents.dto.ReservaRequest;
import com.vibesevents.dto.ReservaResponse;

import java.util.UUID;

public interface ReservaService {
    DisponibilidadResponse checkDisponibilidad(String mes);
    ReservaResponse crearReserva(ReservaRequest request);
    ReservaResponse obtenerReserva(UUID id);
}
