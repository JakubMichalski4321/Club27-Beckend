package com.club27.web.controllers;

import com.club27.services.SoundboardService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/soundboard", consumes = "application/json")
@Data

public class SoundboardController {

    private SoundboardService service;

    public SoundboardController(SoundboardService soundboardService){
        this.service = soundboardService;
    }

}
