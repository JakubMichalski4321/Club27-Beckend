package com.club27.repositories;

import com.club27.domain.Soundboard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SoundboardRepository extends JpaRepository<Soundboard, UUID> {
}
