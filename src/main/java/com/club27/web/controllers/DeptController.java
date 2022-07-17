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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/dept")
@Slf4j
@RequiredArgsConstructor
public class DeptController {

    private final DeptService service;
    private final UserService userService;
    private final UserAccountRepository userAccountRepository;

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<DeptDto>> getUserDepts(@PathVariable("userId") @NotBlank String userId) {
        var userDepts = service.getUserDepts(userId);
        return new ResponseEntity<>(userDepts, HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Dept> getDept(@PathVariable("accountId") @NotBlank String accountId) {
        var userDept = service.getDeptAccountDetails(accountId);
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

    @GetMapping("/deptsusers")
    public ResponseEntity<List<DeptUserDto>> getDeptUsers() {
        var deptUsers = userService.getAllForDepts();
        return new ResponseEntity<>(deptUsers, HttpStatus.OK);
    }

    @GetMapping("/getUserIdByName/{userName}")
    public ResponseEntity<UUID> getDeptUsers(@PathVariable("userName") @NotBlank String userName) {
        var userId = userAccountRepository.findByName(userName).stream()
                .map(BaseEntity::getId)
                .findFirst()
                .orElse(null);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

}
