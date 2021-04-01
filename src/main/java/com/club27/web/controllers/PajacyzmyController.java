package com.club27.web.controllers;

import com.club27.services.PajacyzmyService;
import com.club27.web.dto.PajacyzmDto;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pajacyzmy")
@Data
@Slf4j

public class PajacyzmyController {

    private PajacyzmyService service;

    public PajacyzmyController(PajacyzmyService pajacyzmyService){
        this.service = pajacyzmyService;
    }

    @GetMapping("/allPajacyzmy")
    public ResponseEntity<List<PajacyzmDto>> getAllPajacyzmy(){
        log.debug("getting all pajacyzmy");
        var pajacyzmy = service.getAllPajacyzmy();
        return new ResponseEntity<>(pajacyzmy, HttpStatus.OK);
    }

    @PostMapping("submitPajacyzm")
    public ResponseEntity<Void> submitPajacyzm(@Valid @RequestBody PajacyzmDto pajacyzm){
        log.debug("submit pajacyzm called, " + pajacyzm.toString());
        service.submitPajacyzm(pajacyzm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
