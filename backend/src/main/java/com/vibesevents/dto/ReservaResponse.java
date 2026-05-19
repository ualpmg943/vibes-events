package com.vibesevents.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaResponse {
    private UUID id;
    private LocalDate fechaEvento;
    private String estado;
    private BigDecimal precioTotal;
    private LocalDateTime createdAt;
}
