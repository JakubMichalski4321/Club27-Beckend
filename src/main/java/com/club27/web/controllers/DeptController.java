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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/dept")
@Slf4j
@RequiredArgsConstructor
public class DeptController {

    private final DeptService service;
    private final UserService userService;
    private final UserAccountRepository userAccountRepository;

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dept> getDept(@PathVariable("accountId") String accountId) {
        var dept = service.getDeptAccountDetails(accountId);
        return new ResponseEntity<>(dept, HttpStatus.OK);
    }

    @RequestMapping(value = "/list/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeptDto>> getUserDepts(@PathVariable("username") String userId) {
        var userDepts = service.getUserDepts(userId);
        return new ResponseEntity<>(userDepts, HttpStatus.OK);
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
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

    @RequestMapping(value = "/getUserIdByName/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringWrapper> getDeptUsers(@PathVariable("username") String username) {
        var userId = userAccountRepository.findByName(username).stream()
                .map(BaseEntity::getId)
                .findFirst();
        if (userId.isEmpty()) {
            return new ResponseEntity<>(new StringWrapper("No id found for user " + username), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new StringWrapper(userId.get().toString()), HttpStatus.OK);
    }

}
