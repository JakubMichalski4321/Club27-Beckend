package com.club27.web.controllers;

import com.club27.services.JugoService;
import com.club27.web.dto.JugoDto;
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
@RequestMapping("/jugo")
@Data
@Slf4j

public class JugoController {

    private JugoService service;

    public JugoController(JugoService jugoService){
        this.service = jugoService;
    }

    @GetMapping("/allJugo")
    public ResponseEntity<List<JugoDto>> getAllSoundboard(){
        log.debug("getting all Jugo");
        var jugos = service.getAllJugo();
        return new ResponseEntity<>(jugos, HttpStatus.OK);
    }

}
