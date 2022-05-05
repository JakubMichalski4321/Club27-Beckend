package com.club27.web.controllers;

import com.club27.services.DeptService;
import com.club27.services.UserService;
import com.club27.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/dept")
@Slf4j
@RequiredArgsConstructor
public class DeptController {

    private final DeptService service;


}
