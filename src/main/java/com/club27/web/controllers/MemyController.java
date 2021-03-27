package com.club27.web.controllers;

import com.club27.services.MemyService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/memy")
@Data

public class MemyController {
    @Autowired
    private MemyService service;
}
