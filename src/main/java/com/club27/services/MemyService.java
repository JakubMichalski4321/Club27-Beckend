package com.club27.services;

import com.club27.domain.Mem;
import com.club27.repositories.MemyRepository;
import com.club27.web.dto.MemDto;
import com.club27.web.mappers.MemMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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
    public void submitMem(MemDto memDto) {
        var mem = new Mem(memDto.getTitle(), memDto.getAuthor(), memDto.getImagePath(), memDto.getMemeLikes());
        memyRepository.save(mem);
    }
}
