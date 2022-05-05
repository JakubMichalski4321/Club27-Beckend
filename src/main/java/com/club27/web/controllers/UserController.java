package com.club27.web.controllers;

import com.club27.services.UserService;
import com.club27.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.control.MappingControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/register-user")
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserDto userDto){
        service.registerNewUser(userDto);
        log.debug("register new user " + userDto.name());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user-exists/{userName}")
    public ResponseEntity<Boolean> userExists(@PathVariable("userName") String name){
        var userExists = service.userNameExists(name);
        return new ResponseEntity<>(userExists, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@Valid @RequestBody UserDto userDto){
        service.login(userDto);
        log.debug("user " + userDto.name() + " login attempt");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
