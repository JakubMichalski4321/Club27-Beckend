package com.club27.repositories;

import com.club27.domain.Mem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MemyRepository extends JpaRepository<Mem, UUID> {
}
