package com.vibesevents.exception;

import java.time.LocalDate;

public class FechaNoDisponibleException extends RuntimeException {
    public FechaNoDisponibleException(LocalDate fecha) {
        super("La fecha " + fecha + " no está disponible");
    }
}
