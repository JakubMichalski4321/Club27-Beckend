package com.club27.web.controllers;

import com.club27.services.MemyService;
import com.club27.web.dto.MemDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/allMemy")
    public ResponseEntity<List<MemDto>> getAllPajacyzmy(){
        log.debug("getting all memy");
        var memy = service.getAllMemy();
        return new ResponseEntity<>(memy, HttpStatus.OK);
    }
}
