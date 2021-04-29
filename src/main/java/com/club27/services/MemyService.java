package com.club27.services;

import com.club27.domain.Mem;
import com.club27.repositories.MemyRepository;
import com.club27.web.dto.MemDto;
import com.club27.web.dto.MemToUploadDto;
import com.club27.web.mappers.MemMapper;
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
public class MemyService {
    private final MemyRepository memyRepository;
    private final MemMapper mapper;

    public MemyService(MemyRepository memyRepository, MemMapper mapper) {
        this.memyRepository = memyRepository;
        this.mapper = mapper;
    }

    @Transactional
    public MemDto getMem(UUID id) {
        var mem = memyRepository.findById(id);
        return mapper.memOptionalToDto(mem);
    }

    public List<MemDto> getAllMemy() {
        var  memyAll = memyRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return mapper.mapAll(memyAll);
    }

    @Transactional
    public void giveOneLike(UUID id) throws Exception {
        var mem = memyRepository.findById(id);
        if(mem.isEmpty()){
            throw new Exception("Cannot find the record");
        }
        mem.get().setMemeLikes(mem.get().getMemeLikes() + 1);
    }

    @Transactional
    public void submitMemWithUrl(MemToUploadDto memToUploadDto) {
        var mem = new Mem(memToUploadDto.getTitle(), memToUploadDto.getAuthor(), memToUploadDto.getImagePath(), 0);
        memyRepository.save(mem);
    }

    public void submitFile(MultipartFile file) throws IOException {
        System.out.println("Image upload");
        String saveFileDir = "C:\\Users\\1234c\\Desktop\\club27\\club27-frontend\\src\\assets\\";
        byte[] fileInBytes = file.getBytes();
        Path path = Paths.get(saveFileDir + file.getOriginalFilename());
        Files.write(path, fileInBytes);
    }
}
