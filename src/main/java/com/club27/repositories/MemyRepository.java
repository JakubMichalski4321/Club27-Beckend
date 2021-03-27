package com.club27.repositories;

import com.club27.domain.Memy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MemyRepository extends JpaRepository<Memy, UUID> {
}
