package com.club27.services;

import com.club27.repositories.AccountStatementRepository;
import com.club27.repositories.DeptRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeptService {

    private final DeptRepository deptRepository;
    private final AccountStatementRepository accountStatementRepository;

}
