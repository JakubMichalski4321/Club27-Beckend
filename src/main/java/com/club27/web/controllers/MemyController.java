package com.club27.web.controllers;

import com.club27.services.MemyService;
import com.club27.web.dto.MemDto;
import com.club27.web.dto.MemToUploadDto;
import com.club27.web.dto.MemToUploadImageDto;
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
@RequestMapping("/memy")
@Data
@Slf4j

public class MemyController {

    private MemyService service;

    public MemyController(MemyService memyService){
        this.service = memyService;
    }

    @GetMapping("/{memId}")
    public ResponseEntity<MemDto> getMem(@PathVariable("memId") UUID id){
        var mem = service.getMem(id);
        return new ResponseEntity<>(mem, HttpStatus.OK);
    }

    @GetMapping("/allMemy")
    public ResponseEntity<List<MemDto>> getAllPajacyzmy(){
        log.debug("getting all memy");
        var memy = service.getAllMemy();
        return new ResponseEntity<>(memy, HttpStatus.OK);
    }

    @PostMapping("/submitMeme")
    public ResponseEntity<Void> submitMemWithUrl(@Valid @RequestBody MemToUploadDto mem){
        log.debug("submit mem called, " + mem.toString());
        service.submitMemWithUrl(mem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/submitMemeImage")
    public ResponseEntity<Void> submitMemWithImage(@Valid @RequestParam(value = "file", required = true) MultipartFile file){
        log.debug("submit file saved called, " + file.toString());
        try {
            service.submitFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.valueOf("File save failed"));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
