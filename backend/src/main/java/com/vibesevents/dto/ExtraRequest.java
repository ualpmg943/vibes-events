package com.vibesevents.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExtraRequest {

    @NotBlank
    private String tipo;

    @NotBlank
    private String nombre;

    private String descripcion;

    @NotNull
    @Min(0)
    private BigDecimal precioUnitario;

    @NotNull
    @Min(1)
    private Integer cantidad;
}
