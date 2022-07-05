package com.club27.web.controllers;

import com.club27.domain.Mem;
import com.club27.services.ListService;
import com.club27.services.MemyService;
import com.club27.web.dto.*;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/meme")
@Slf4j
@RequiredArgsConstructor

public class MemeController {

    private final ListService listService;
    private final MemyService service;

    @GetMapping("/{memeId}")
    public ResponseEntity<Mem> getMeme(@PathVariable("memeId") UUID id) {
        var mem = service.getMem(id);
        return new ResponseEntity<>(mem, HttpStatus.OK);
    }

    @PostMapping("/memes")
    public ResponseEntity<MemesWithCounterDto> getAllMemes(@RequestBody(required = false) PageListRequestDto pageListRequestDto) {
        int pageNumberInt = listService.validatePageListRequestPageDisplay(pageListRequestDto);
        int numberPerPageInt = listService.validatePageListRequestItemsPerPage(pageListRequestDto);
        var memes = service.getMemes(pageNumberInt, numberPerPageInt);
        return new ResponseEntity<>(memes, HttpStatus.OK);
    }

    @GetMapping("/{memeId}/like-add")
    public ResponseEntity<Void> giveOneLike(@PathVariable("memeId") UUID id) {
        log.info("give one like to meme : " + id);
        service.giveOneLike(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/meme-submit")
    public ResponseEntity<Void> submitMemeWithUrl(@Valid @RequestBody MemToUploadDto mem) {
        log.debug("submit mem called, " + mem.toString());
        service.submitMemWithUrl(mem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/meme-image-submit")
    public ResponseEntity<Void> submitMemeWithImage(@Valid @RequestParam(value = "file") MultipartFile file) {
        log.debug("submit file saved called, " + file.toString());
        try {
            service.submitFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.valueOf("File save failed"));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{memeId}/comments")
    public ResponseEntity<List<CommentDto>> getMemeAllComments(@PathVariable("memeId") UUID id) {
        log.debug("getting all comments for meme: " + id);
        var commentsList = service.getThisMemComments(id);
        return new ResponseEntity<>(commentsList, HttpStatus.OK);
    }

    @PostMapping("/meme-comment-submit")
    public ResponseEntity<Void> submitMemeComment(@Valid @RequestBody CommentToUploadDto comment) {
        log.debug("submit comment called, " + comment.toString());
        service.submitMemComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
