package com.club27.services;

import com.club27.repositories.MemyRepository;
import com.club27.web.dto.MemDto;
import com.club27.web.mappers.MemMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemyService {
    private final MemyRepository memyRepository;
    private final MemMapper mapper;

    public MemyService(MemyRepository memyRepository, MemMapper mapper) {
        this.memyRepository = memyRepository;
        this.mapper = mapper;
    }

    public List<MemDto> getAllMemy() {
        var  memyAll = memyRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return mapper.mapAll(memyAll);
    }
}
