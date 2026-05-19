package com.vibesevents.exception;

import java.util.UUID;

public class ReservaNotFoundException extends RuntimeException {
    public ReservaNotFoundException(UUID id) {
        super("Reserva no encontrada: " + id);
    }
}
