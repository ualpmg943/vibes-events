package com.vibesevents.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nombre;

    private String telefono;

    @NotNull
    private LocalDate fechaEvento;

    private String lugarEvento;

    private Integer horasContratadas;

    @NotNull
    private Long packId;

    @Valid
    private List<ExtraRequest> extras;

    private String notas;
}
