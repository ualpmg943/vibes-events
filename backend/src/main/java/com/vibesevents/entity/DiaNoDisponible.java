package com.vibesevents.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dias_no_disponibles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaNoDisponible {

    @Id
    private LocalDate fecha;

    @CreationTimestamp
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn;
}
