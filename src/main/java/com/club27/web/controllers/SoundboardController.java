package com.club27.web.controllers;

import com.club27.domain.Soundboard;
import com.club27.services.SoundboardService;
import com.club27.web.dto.SoundboardDto;
import lombok.RequiredArgsConstructor;
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
@RequestMapping(value = "/soundboard")
@Slf4j
@RequiredArgsConstructor

public class SoundboardController {

    private final SoundboardService service;

    @GetMapping("/{soundboardId}")
    public ResponseEntity<Soundboard> getSoundboard(@PathVariable("soundboardId") UUID id) {
        var soundboard = service.getSoundboard(id);
        return new ResponseEntity<>(soundboard, HttpStatus.OK);
    }

    @GetMapping("/soundboards")
    public ResponseEntity<List<SoundboardDto>> getAllSoundboard() {
        var soundboards = service.getAllSoundboards();
        return new ResponseEntity<>(soundboards, HttpStatus.OK);
    }

    @PostMapping("/soundboard-submit")
    public ResponseEntity<Void> submitSoundboard(@Valid @RequestBody SoundboardDto soundboardDto) {
        log.debug("submit soundboard called, " + soundboardDto.toString());
        service.submitSoundboard(soundboardDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/soundboard-sound-submit", method = RequestMethod.POST, headers = {"Content-Type=multipart/form-data"})
    @ResponseBody
    public ResponseEntity<Void> create(@RequestBody MultipartFile file) {
        try {
            service.submitSoundboardSound(file);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.valueOf("File save failed"));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
