package com.club27.services;

import com.club27.domain.Pajacyzm;
import com.club27.repositories.PajacyzmyRepository;
import com.club27.web.dto.PajacyzmDto;
import com.club27.web.mappers.PajacyzmMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.PrinterJob;
import java.util.List;


@Service
public class PajacyzmyService {
    private final PajacyzmyRepository pajacyzmyRepository;
    private final PajacyzmMapper pajacyzmMapper;

    public PajacyzmyService(PajacyzmyRepository pajacyzmyRepository, PajacyzmMapper pajacyzmMapper) {
        this.pajacyzmyRepository = pajacyzmyRepository;
        this.pajacyzmMapper = pajacyzmMapper;
    }

    public List<PajacyzmDto> getAllPajacyzmy() {
        var pajacyzmyAll = pajacyzmyRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return pajacyzmMapper.mapAll(pajacyzmyAll);
    }

    @Transactional(rollbackOn = {})
    public void submitPajacyzm(PajacyzmDto pajacyzm) {

        var pajacyzm = new Pajacyzm(
                pajacyzm.
        )

    }
}
