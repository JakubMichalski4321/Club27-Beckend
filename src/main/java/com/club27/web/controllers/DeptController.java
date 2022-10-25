package com.club27.web.controllers;

import com.club27.domain.BaseEntity;
import com.club27.domain.Dept;
import com.club27.repositories.UserAccountRepository;
import com.club27.services.DeptService;
import com.club27.services.UserService;
import com.club27.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/dept")
@Slf4j
@RequiredArgsConstructor
public class DeptController {

    private final DeptService service;
    private final UserService userService;
    private final UserAccountRepository userAccountRepository;

    @PostMapping("/list")
    public ResponseEntity<List<DeptDto>> getUserDepts(@Valid StringDto req) {
        var userDepts = service.getUserDepts(req.value());
        return new ResponseEntity<>(userDepts, HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<Dept> getDept(@Valid StringDto req) {
        var userDept = service.getDeptAccountDetails(req.value());
        return new ResponseEntity<>(userDept, HttpStatus.OK);
    }

    @PostMapping("/addStatement")
    public ResponseEntity<Void> addStatement(@Valid @RequestBody AddStatementDto addStatementDto) {
        service.saveNewStatement(addStatementDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createDept(@Valid @RequestBody DeptCreateAccountDto deptCreateAccountDto) {
        if (service.createDept(deptCreateAccountDto)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

/*    @GetMapping("/deleteDept/{accountId}")
    public ResponseEntity<String> deleteDept(@PathVariable("accountId") @NotBlank String accountId) {
        var response = service.deleteDept(accountId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/

    @PostMapping("/deptsusers")
    public ResponseEntity<List<DeptUserDto>> getDeptUsers() {
        var deptUsers = userService.getAllForDepts();
        return new ResponseEntity<>(deptUsers, HttpStatus.OK);
    }

    @PostMapping("/getUserIdByName")
    public ResponseEntity<UUID> getDeptUsers(@Valid StringDto req) {
        var userId = userAccountRepository.findByName(req.value()).stream()
                .map(BaseEntity::getId)
                .findFirst()
                .orElse(null);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

}
