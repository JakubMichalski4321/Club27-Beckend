package com.club27.services;

import com.club27.domain.AccountStatement;
import com.club27.domain.Dept;
import com.club27.domain.UserAccount;
import com.club27.repositories.AccountStatementRepository;
import com.club27.repositories.DeptRepository;
import com.club27.repositories.UserAccountRepository;
import com.club27.web.dto.AddStatementDto;
import com.club27.web.dto.DeptCreateAccountDto;
import com.club27.web.dto.DeptDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

        user1.getUserDepts().add(deptAccount);
        user2.getUserDepts().add(deptAccount);

        deptRepository.save(deptAccount);
        userAccountRepository.save(user1);
        userAccountRepository.save(user2);
        return true;
    }


    public List<DeptDto> getUserDepts(String userId) {
        List<DeptDto> deptDtoList = new ArrayList<>();
        var deptList =  Optional.of(userAccountRepository.getOne(UUID.fromString(userId))).map(UserAccount::getUserDepts).orElseThrow();
        deptList.forEach(dept -> {
            DeptDto dto = new DeptDto(
                dept.getId(),
                dept.getDeptAccountName(),
                dept.getCreatedDate(),
                dept.getBalance(),
                dept.getUserAccounts().get(0).getName(),
                dept.getUserAccounts().get(1).getName()
            );
            deptDtoList.add(dto);
        });
        return deptDtoList;
    }

    @Transactional
    public void saveNewStatement(AddStatementDto dto) {
        AccountStatement accountStatement = new AccountStatement();
        accountStatement.setTitle(dto.title());
        accountStatement.setDescription(dto.description());
        accountStatement.setAmount(dto.amount());

        Dept dept = deptRepository.getOne(UUID.fromString(dto.deptId()));
        accountStatement.setDept(dept);

        UserAccount deptUser = userAccountRepository.getOne(UUID.fromString(dto.deptUserId()));
        accountStatement.setDeptUserId(deptUser.getId().toString());

        accountStatementRepository.save(accountStatement);
    }

    public Dept getUserDept(String accountId) {
        var check = deptRepository.getOne(UUID.fromString(accountId));
        return deptRepository.getOne(UUID.fromString(accountId));
    }
}
