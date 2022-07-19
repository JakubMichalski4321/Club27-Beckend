package com.club27.web.dto;

import com.club27.domain.UserAccount;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.List;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record DeptAccountDetailsDto (
        String deptAccountName,
        Double balance,
        List<UserAccount> userAccounts,
        Timestamp createdDate
) {
}
