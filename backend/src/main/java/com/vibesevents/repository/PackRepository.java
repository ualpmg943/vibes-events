package com.vibesevents.repository;

import com.vibesevents.entity.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackRepository extends JpaRepository<Pack, Long> {
    List<Pack> findByActivoTrue();
}
