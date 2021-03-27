package com.club27.web.controllers;

import com.club27.services.JugoService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/jugo")
@Data

public class JugoController {
    @Autowired
    private JugoService service;

}
