package com.club27.repositories;

import com.club27.domain.Mem;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MemyRepository extends JpaRepository<Mem, UUID> {
    @Query("select m from Memy m")
    List<Mem> findAllMemy(Pageable page);
}
