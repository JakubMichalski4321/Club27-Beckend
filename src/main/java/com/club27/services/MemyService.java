package com.club27.services;

import com.club27.domain.Mem;
import com.club27.domain.Comment;
import com.club27.exception.ObjectNotFoundException;
import com.club27.repositories.CommentRepository;
import com.club27.repositories.MemyRepository;
import com.club27.web.dto.CommentDto;
import com.club27.web.dto.CommentToUploadDto;
import com.club27.web.dto.MemDto;
import com.club27.web.dto.MemToUploadDto;
import com.club27.web.mappers.MemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemyService {

    private final MemyRepository memyRepository;
    private final CommentRepository commentRepository;
    private final MemMapper mapper;

    @Transactional
    public Mem getMem(UUID id) {
        return memyRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Meme not found!"));
    }

    public List<MemDto> getAllMemy() {
        var  memyAll = memyRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return mapper.mapAll(memyAll);
    }

    @Transactional
    public void giveOneLike(UUID id) {
        var mem = memyRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Meme not found!"));
        mem.setMemeLikes(mem.getMemeLikes() + 1);
    }

    @Transactional
    public void submitMemWithUrl(MemToUploadDto memToUploadDto) {
        var mem = new Mem(memToUploadDto.getTitle(), memToUploadDto.getAuthor(), memToUploadDto.getImagePath(), 0);
        memyRepository.save(mem);
    }

    public void submitFile(MultipartFile file) throws IOException {
        System.out.println("Image upload");
        String saveFileDir = "/var/www/html/assets/memeImages/";
        byte[] fileInBytes = file.getBytes();
        Path path = Paths.get(saveFileDir + file.getOriginalFilename());
        Files.write(path, fileInBytes);
    }

    public List<CommentDto> getThisMemComments(UUID id) {
        var selectedMeme = memyRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Meme not found!"));
        return mapper.mapAllMemeComments(selectedMeme.getMemeComments());
    }

    @Transactional
    public void submitMemComment(CommentToUploadDto comment) {
        var selectedMeme = memyRepository.findById(comment.getMemeId()).orElseThrow( () -> new ObjectNotFoundException("Meme not found!"));
        var commentToSave = new Comment(comment.getContent(), comment.getAuthor(), selectedMeme);
        commentToSave.setMem(selectedMeme);
        selectedMeme.getMemeComments().add(commentToSave);
        commentRepository.save(commentToSave);
    }

}
