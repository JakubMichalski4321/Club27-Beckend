package com.club27.services;

import com.club27.domain.Pajacyzm;
import com.club27.repositories.PajacyzmyRepository;
import com.club27.web.dto.PajacyzmDto;
import com.club27.web.mappers.PajacyzmMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
public class PajacyzmyService {
    private final PajacyzmyRepository pajacyzmyRepository;
    private final PajacyzmMapper pajacyzmMapper;

    public PajacyzmyService(PajacyzmyRepository pajacyzmyRepository, PajacyzmMapper pajacyzmMapper) {
        this.pajacyzmyRepository = pajacyzmyRepository;
        this.pajacyzmMapper = pajacyzmMapper;
    }

    @Transactional
    public PajacyzmDto getPajacyzm(UUID id) {
        var pajacyzm = pajacyzmyRepository.findById(id);
        return pajacyzmMapper.pajacyzmOptionalToDto(pajacyzm);
    }

    public List<PajacyzmDto> getAllPajacyzmy() {
        var pajacyzmyAll = pajacyzmyRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return pajacyzmMapper.mapAll(pajacyzmyAll);
    }

    @Transactional
    public void submitPajacyzm(PajacyzmDto pajacyzmDto) {
        var pajacyzm = new Pajacyzm(pajacyzmDto.getContent(), pajacyzmDto.getAuthor());
        pajacyzmyRepository.save(pajacyzm);
    }

}
