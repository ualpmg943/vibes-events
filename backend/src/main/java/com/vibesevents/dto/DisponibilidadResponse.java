package com.vibesevents.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DisponibilidadResponse {
    private List<LocalDate> fechasReservadas;
    private List<LocalDate> fechasBloqueadas;
}
