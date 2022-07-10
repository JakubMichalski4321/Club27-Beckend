package com.club27.services;

import com.club27.domain.Dept;
import com.club27.domain.UserAccount;
import com.club27.repositories.AccountStatementRepository;
import com.club27.repositories.DeptRepository;
import com.club27.repositories.UserAccountRepository;
import com.club27.web.dto.DeptCreateAccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeptService {

    private final DeptRepository deptRepository;
    private final AccountStatementRepository accountStatementRepository;
    private final UserAccountRepository userAccountRepository;

    public boolean createDept(DeptCreateAccountDto dto) {
        if (dto.deptUsersIds().contains(dto.userId().toString())) {
            return false;
        }

        UserAccount user1 = userAccountRepository.getOne(dto.userId());
        UserAccount user2 = userAccountRepository.getOne(UUID.fromString(dto.deptUsersIds().get(0)));

        List<UserAccount> userAccountList = new ArrayList<>();
        userAccountList.add(user1);
        userAccountList.add(user2);

        Dept deptAccount = new Dept();
        deptAccount.setDeptAccountName(dto.accountName());
        deptAccount.setUserAccounts(userAccountList);
        deptAccount.setBalance(0.00);

        deptRepository.save(deptAccount);
        return true;
    }


    public List<Dept> getUserDepts(String userId) {
        var check = deptRepository.findAll().stream()
                .filter(dept -> dept.getUserAccounts().stream()
                        .anyMatch(userAccount -> userAccount.getId().equals(UUID.fromString(userId)))).toList();
        return deptRepository.findAll().stream()
                .filter(dept -> dept.getUserAccounts().stream()
                        .anyMatch(userAccount -> userAccount.getId().equals(UUID.fromString(userId)))).toList();
    }
}
