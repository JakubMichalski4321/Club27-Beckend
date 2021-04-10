package com.club27.web.controllers;

import com.club27.services.SoundboardService;
import com.club27.web.dto.SoundboardDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{soundboardId}")
    public ResponseEntity<SoundboardDto> getSoundboard(@PathVariable("soundboardId") UUID id){
        var soundboard = service.getSoundboard(id);
        return new ResponseEntity<>(soundboard, HttpStatus.OK);
    }

    @GetMapping("/allSoundboard")
    public ResponseEntity<List<SoundboardDto>> getAllSoundboard(){
        log.debug("getting all soundboards");
        var soundboards = service.getAllSoundboards();
        return new ResponseEntity<>(soundboards, HttpStatus.OK);
    }

    @PostMapping("/submitSoundboard")
    public ResponseEntity<Void> submitSoundboard(@Valid @RequestBody SoundboardDto soundboardDto){
        log.debug("submit soundboard called, " + soundboardDto.toString());
        service.submitSoundboard(soundboardDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/submitSoundboardSound")
    public ResponseEntity<Void> submitMemWithImage(@Valid @RequestParam(value = "file", required = true) MultipartFile file){
        log.debug("submit file saved called, " + file.toString());
        try {
            service.submitSoundboardSound(file);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.valueOf("File save failed"));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
