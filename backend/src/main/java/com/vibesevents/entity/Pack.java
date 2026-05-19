package com.vibesevents.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "packs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio_base", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioBase;

    @Column(name = "horas_incluidas")
    private Integer horasIncluidas;

    @Column(nullable = false)
    @Builder.Default
    private Boolean popular = false;

    @Column(name = "icono_svg", columnDefinition = "TEXT")
    private String iconoSvg;

    @Column(columnDefinition = "TEXT")
    private String caracteristicas;

    @Column(nullable = false)
    @Builder.Default
    private Boolean activo = true;
}
