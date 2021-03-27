package com.club27.repositories;

import com.club27.domain.Pajacyzmy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PajacyzmyRepository extends JpaRepository<Pajacyzmy, UUID> {
}
