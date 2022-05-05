package com.club27.repositories;

import com.club27.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeptRepository extends JpaRepository<Dept, UUID> {
}
