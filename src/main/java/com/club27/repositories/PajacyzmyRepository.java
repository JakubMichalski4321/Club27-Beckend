package com.club27.repositories;

import com.club27.domain.Pajacyzm;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PajacyzmyRepository extends JpaRepository<Pajacyzm, UUID> {
    Optional<Pajacyzm> getById(UUID id);
}
