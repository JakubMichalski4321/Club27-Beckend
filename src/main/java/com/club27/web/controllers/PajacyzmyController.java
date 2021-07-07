package com.club27.web.controllers;

import com.club27.services.PajacyzmyService;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pajacyzmy")
@Data
@Slf4j

public class PajacyzmyController {

    private PajacyzmyService service;

    public PajacyzmyController(PajacyzmyService pajacyzmyService){
        this.service = pajacyzmyService;
    }

    @GetMapping("/{pajacyzmId}")
    public ResponseEntity<PajacyzmDto> getPajacyzm(@PathVariable("pajacyzmId") UUID id){
        var pajacyzm = service.getPajacyzm(id);
        return new ResponseEntity<>(pajacyzm, HttpStatus.OK);
    }

    @GetMapping("/pajacyzmy-all")
    public ResponseEntity<List<PajacyzmDto>> getAllPajacyzmy(){
        log.debug("getting all pajacyzmy");
        var pajacyzmy = service.getAllPajacyzmy();
        return new ResponseEntity<>(pajacyzmy, HttpStatus.OK);
    }

    @PostMapping("/pajacyzm-submit")
    public ResponseEntity<Void> submitPajacyzm(@Valid @RequestBody PajacyzmDto pajacyzm){
        log.debug("submit pajacyzm called, " + pajacyzm.toString());
        service.submitPajacyzm(pajacyzm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
