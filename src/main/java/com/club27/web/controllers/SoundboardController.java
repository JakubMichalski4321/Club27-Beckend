package com.club27.web.controllers;

import com.club27.services.SoundboardService;
import com.club27.web.dto.PajacyzmDto;
import com.club27.web.dto.SoundboardDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/soundboard", consumes = "application/json")
@Data
@Slf4j

public class SoundboardController {

    private SoundboardService service;

    public SoundboardController(SoundboardService soundboardService){
        this.service = soundboardService;
    }

    @GetMapping("/getAllSoundboard")
    public ResponseEntity<List<SoundboardDto>> getAllSoundboard(){
        log.debug("getting all soundboards");
        var soundboards = service.getAllSoundboards();
        return new ResponseEntity<>(soundboards, HttpStatus.OK);
    }

}
