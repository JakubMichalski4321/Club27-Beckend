package com.club27.repositories;

import com.club27.domain.Jugo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JugoRepository extends JpaRepository<Jugo, UUID> {
}
