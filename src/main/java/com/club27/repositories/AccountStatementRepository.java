package com.club27.repositories;

import com.club27.domain.AccountStatement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountStatementRepository extends JpaRepository<AccountStatement, UUID> {
}
