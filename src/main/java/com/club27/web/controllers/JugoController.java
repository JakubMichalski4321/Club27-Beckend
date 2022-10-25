package com.club27.web.controllers;

import com.club27.domain.Jugo;
import com.club27.services.JugoService;
import com.club27.services.ListService;
import com.club27.web.dto.JugoDto;
import com.club27.web.dto.PageListRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jugo")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor

public class JugoController {

    private final ListService listService;
    private final JugoService service;

    @GetMapping("/{jugoId}")
    public ResponseEntity<Jugo> getJugo(@PathVariable("jugoId") UUID id) {
        var jugo = service.getJugo(id);
        return new ResponseEntity<>(jugo, HttpStatus.OK);
    }

    @GetMapping("/jugos")
    public ResponseEntity<List<JugoDto>> getAllSoundboard(@RequestBody(required = false) PageListRequestDto pageListRequestDto) {
        int pageNumberInt = listService.validatePageListRequestPageDisplay(pageListRequestDto);
        int numberPerPageInt = listService.validatePageListRequestItemsPerPage(pageListRequestDto);
        var jugos = service.getJugos(pageNumberInt, numberPerPageInt);
        return new ResponseEntity<>(jugos, HttpStatus.OK);
    }

    @PostMapping("/jugo-submit")
    public ResponseEntity<Void> submitJugo(@Valid @RequestBody JugoDto jugoDto) {
        log.debug("submit jugo called, " + jugoDto.toString());
        service.submitJugo(jugoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{jugoId}/like-add")
    public ResponseEntity<Void> giveOneLike(@PathVariable("jugoId") UUID id) {
        log.info("give one like to jugoId : " + id);
        service.giveOneLike(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
