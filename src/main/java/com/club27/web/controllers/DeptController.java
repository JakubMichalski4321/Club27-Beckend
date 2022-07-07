package com.club27.web.controllers;

import com.club27.domain.BaseEntity;
import com.club27.domain.UserAccount;
import com.club27.repositories.UserAccountRepository;
import com.club27.services.DeptService;
import com.club27.services.UserService;
import com.club27.web.dto.DeptCreateAccountDto;
import com.club27.web.dto.DeptUserDto;
import com.club27.web.dto.JugoDto;
import com.club27.web.dto.PageListRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/depts")
    public ResponseEntity<List<JugoDto>> getDepts(@RequestBody(required = false) PageListRequestDto pageListRequestDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/dept/{id}")
    public ResponseEntity<List<JugoDto>> getDept(@RequestBody(required = false) PageListRequestDto pageListRequestDto) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateDept(@Valid @RequestBody JugoDto jugoDto) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createDept(@Valid @RequestBody DeptCreateAccountDto deptCreateAccountDto) {
        if(service.createDept(deptCreateAccountDto)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> removeDept(@Valid @RequestBody JugoDto jugoDto) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/deptsusers")
    public ResponseEntity<List<DeptUserDto>> getDeptUsers() {
        var deptUsers = userService.getAllForDepts();
        return new ResponseEntity<>(deptUsers, HttpStatus.OK);
    }

    @GetMapping("/getUserIdByName/{userName}")
    public ResponseEntity<UUID> getDeptUsers(@PathVariable("userName") String userName) {
        var userId = userAccountRepository.findByName(userName).stream()
                .map(BaseEntity::getId)
                .findFirst()
                .orElse(null);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

}
