package com.club27.web.controllers;

import com.club27.services.SoundboardService;
import com.club27.web.dto.SoundboardDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Context;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/submitSoundboardSound2")
    public ResponseEntity<Void> submitSound2(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        log.debug("submit file saved called, " + file.toString());
        System.out.println("1");
        try {
            service.submitSoundboardSound(file);
            System.out.println("3");
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.valueOf("File save failed"));
        }
        redirectAttributes.addFlashAttribute("message", "Successfully uploaded");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/submitSoundboardSound", method = RequestMethod.POST, headers = {"Content-Type=multipart/form-data"})
    @ResponseBody
    public  ResponseEntity<Void> create(@RequestBody MultipartFile file) {
        try {
            service.submitSoundboardSound(file);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.valueOf("File save failed"));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
