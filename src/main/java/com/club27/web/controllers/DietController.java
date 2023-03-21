package com.club27.web.controllers;

import com.club27.domain.Diet;
import com.club27.domain.DietStatement;
import com.club27.services.DietService;
import com.club27.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/diet")
@Slf4j
@RequiredArgsConstructor
public class DietController {

    private final DietService service;

    @GetMapping("/getdiet/{dietId}")
    public ResponseEntity<Diet> getDiet(@PathVariable String dietId) {
        return new ResponseEntity<>(service.getDietById(dietId), HttpStatus.OK);
    }

    @GetMapping("/getuserdiet/{userId}")
    public ResponseEntity<Diet> getUserDiet(@PathVariable String userId) {
        return new ResponseEntity<>(service.getDietByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/getdiets")
    public ResponseEntity<List<Diet>> getAllDiets() {
        return new ResponseEntity<>(service.getAllDiets(), HttpStatus.OK);
    }

    @GetMapping("/getdietstatements/{dietId}")
    public ResponseEntity<List<DietStatement>> getDietStatements(@PathVariable String dietId) {
        return new ResponseEntity<>(service.getDietStatementsByDietId(dietId), HttpStatus.OK);
    }

    @DeleteMapping("/deletediet/{dietId}")
    public ResponseEntity<List<JugoDto>> getAllSoundboard(@PathVariable String dietId) {
        service.deleteDiet(dietId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/adddiet")
    public ResponseEntity<Void> addDiet(@Valid @RequestBody AddDietAccountDto addDietAccountDto) {
        service.createDiet(addDietAccountDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/adddietstatement")
    public ResponseEntity<StringWrapper> addDietStatement(@Valid @RequestBody AddDietStatementDto addDietStatementDto) {
        StringWrapper result = new StringWrapper(service.addDietStatement(addDietStatementDto));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
