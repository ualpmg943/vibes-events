package com.vibesevents.repository;

import com.vibesevents.entity.Extra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ExtraRepository extends JpaRepository<Extra, Long> {
    List<Extra> findByReservaId(UUID reservaId);
}
