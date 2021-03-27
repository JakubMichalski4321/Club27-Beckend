package com.club27.repositories;

import com.club27.domain.Jugo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JugoRepository extends JpaRepository<Jugo, UUID> {
}
