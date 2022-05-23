package com.club27.repositories;

import com.club27.domain.AccountStatement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountStatementRepository extends JpaRepository<AccountStatement, UUID> {
}
