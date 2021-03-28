package com.club27.web.controllers;

import com.club27.services.MemyService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/memy", consumes = "application/json")
@Data

public class MemyController {

    private MemyService service;

    public MemyController(MemyService memyService){
        this.service = memyService;
    }

}
