package com.club27.web.dto;

import com.club27.domain.UserAccount;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;

@Getter
public record DeptAccountDetailsDto (
        String deptAccountName,
        Double balance,
        List<UserAccount> userAccounts,
        Timestamp createdDate
) {
}
