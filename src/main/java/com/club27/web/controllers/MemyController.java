package com.club27.web.controllers;

import com.club27.services.MemyService;
import com.club27.web.dto.MemDto;
import com.club27.web.dto.PajacyzmDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("submitMem")
    public ResponseEntity<Void> submitMem(@Valid @RequestBody MemDto mem){
        log.debug("submit mem called, " + mem.toString());
        service.submitMem(mem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
