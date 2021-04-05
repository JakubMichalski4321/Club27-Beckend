package com.club27.web.controllers;

import com.club27.services.JugoService;
import com.club27.web.dto.JugoDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{jugoId}")
    public ResponseEntity<JugoDto> getJugo(@PathVariable("jugoId") UUID id){
        var jugo = service.getJugo(id);
        return new ResponseEntity<>(jugo, HttpStatus.OK);
    }

    @GetMapping("/allJugo")
    public ResponseEntity<List<JugoDto>> getAllSoundboard(){
        log.debug("getting all Jugo");
        var jugos = service.getAllJugo();
        return new ResponseEntity<>(jugos, HttpStatus.OK);
    }

    @PostMapping("submitJugo")
    public ResponseEntity<Void> submitJugo(@Valid @RequestBody JugoDto jugoDto){
        log.debug("submit jugo called, " + jugoDto.toString());
        service.submitJugo(jugoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
