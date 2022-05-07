package com.club27.services;

import com.club27.domain.Pajacyzm;
import com.club27.exception.ObjectNotFoundException;
import com.club27.repositories.PajacyzmyRepository;
import com.club27.web.dto.PajacyzmDto;
import com.club27.web.mappers.PajacyzmMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PajacyzmyService {

    private final PajacyzmyRepository pajacyzmyRepository;
    private final PajacyzmMapper pajacyzmMapper;


    @Transactional
    public Pajacyzm getPajacyzm(UUID id) {
        var pajacyzm = pajacyzmyRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Pajacyzm not found!"));
        log.info(pajacyzm.toString());
        return pajacyzm;
    }

    public List<PajacyzmDto> getPajacyzmy(int pageNumberInt, int numberInt) {
        var pajacyzmy = pajacyzmyRepository.findAllPajacyzmy(PageRequest.of(pageNumberInt, numberInt, Sort.by(Sort.Direction.DESC, "createdDate")));
        return pajacyzmMapper.mapAll(pajacyzmy);
    }

    @Transactional
    public void submitPajacyzm(PajacyzmDto pajacyzmDto) {
        var pajacyzm = new Pajacyzm(pajacyzmDto.content(), pajacyzmDto.author());
        pajacyzmyRepository.save(pajacyzm);
    }

}
