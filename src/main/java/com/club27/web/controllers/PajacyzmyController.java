package com.club27.web.controllers;

import com.club27.domain.Pajacyzm;
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
@Slf4j
@RequiredArgsConstructor

public class PajacyzmyController {

    private final PajacyzmyService service;

    @GetMapping("/{pajacyzmId}")
    public ResponseEntity<Pajacyzm> getPajacyzm(@PathVariable("pajacyzmId") UUID id){
        log.info("Getting pajacyzm called");
        var pajacyzm = service.getPajacyzm(id);
        return new ResponseEntity<>(pajacyzm, HttpStatus.OK);
    }

    @GetMapping("/pajacyzmy-all")
    public ResponseEntity<List<PajacyzmDto>> getAllPajacyzmy(){
        log.info("Getting all pajacyzmy");
        var pajacyzmy = service.getAllPajacyzmy();
        return new ResponseEntity<>(pajacyzmy, HttpStatus.OK);
    }

    @PostMapping("/pajacyzm-submit")
    public ResponseEntity<Void> submitPajacyzm(@Valid @RequestBody PajacyzmDto pajacyzm){
        log.info("Submit pajacyzm called, " + pajacyzm.toString());
        service.submitPajacyzm(pajacyzm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
