package com.vibesevents.repository;

import com.vibesevents.entity.MensajeContacto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MensajeContactoRepository extends JpaRepository<MensajeContacto, UUID> {
    long countByLeidoFalse();
}
