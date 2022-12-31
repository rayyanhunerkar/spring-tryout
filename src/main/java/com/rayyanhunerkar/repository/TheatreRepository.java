package com.rayyanhunerkar.repository;

import com.rayyanhunerkar.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TheatreRepository extends JpaRepository<Theatre, UUID> {
}
