package com.club27.repositories;

import com.club27.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeptRepository extends JpaRepository<Dept, UUID> {
}
