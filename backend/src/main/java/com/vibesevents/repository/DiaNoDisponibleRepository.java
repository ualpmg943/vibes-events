package com.vibesevents.repository;

import com.vibesevents.entity.DiaNoDisponible;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DiaNoDisponibleRepository extends JpaRepository<DiaNoDisponible, LocalDate> {
    List<DiaNoDisponible> findByFechaBetween(LocalDate inicio, LocalDate fin);
}
