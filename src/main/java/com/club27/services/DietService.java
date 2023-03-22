package com.club27.services;

import com.club27.domain.Diet;
import com.club27.domain.DietStatement;
import com.club27.domain.UserAccount;
import com.club27.exception.ObjectNotFoundException;
import com.club27.repositories.DietRepository;
import com.club27.repositories.DietStatementRepository;
import com.club27.repositories.UserAccountRepository;
import com.club27.web.dto.AddDietAccountDto;
import com.club27.web.dto.AddDietStatementDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DietService {

    private final DietRepository dietRepository;
    private final DietStatementRepository dietStatementRepository;
    private final UserAccountRepository userAccountRepository;

    public List<Diet> getAllDiets() {
        return dietRepository.findAll();
    }

    public Diet getDietById(String dietId) {
        return dietRepository.findById(UUID.fromString(dietId)).orElseThrow(() -> new ObjectNotFoundException("No diet with id " + dietId));
    }

    public Diet getDietByUserId(String userId) {
        return dietRepository.findAll().stream().filter(d -> d.getUserAccount().getId().equals(UUID.fromString(userId))).findFirst().orElse(null);
    }

    public List<DietStatement> getDietStatementsByDietId(String dietId) {
        return dietStatementRepository.findAll().stream().filter(dS -> UUID.fromString(dietId).equals(dS.getDiet().getId())).collect(Collectors.toList());
    }

    public void createDiet(AddDietAccountDto addDietAccountDto) {
        UserAccount user = userAccountRepository.getOne(UUID.fromString(addDietAccountDto.userAccountId()));
        Diet newDiet = new Diet();
        newDiet.setDietBalance(addDietAccountDto.currentWeight());
        newDiet.setDietName(addDietAccountDto.dietName());
        newDiet.setUserAccount(user);
        dietRepository.save(newDiet);
        dietRepository.flush();
        addFirstDietStatement(newDiet);
    }

    private void addFirstDietStatement(Diet newDiet) {
        dietStatementRepository.save(new DietStatement(newDiet.getDietBalance(), "Pierwsze ważenie byczku", newDiet));
    }

    public void deleteDiet(String dietId) {
        dietRepository.deleteById(UUID.fromString(dietId));
    }

    public String addDietStatement(AddDietStatementDto addDietStatementDto) {
        Diet diet = dietRepository.findById(UUID.fromString(addDietStatementDto.dietId())).orElseThrow(() -> new ObjectNotFoundException("Diet not found!"));
        DietStatement newDietStatement = new DietStatement(addDietStatementDto.weight(), addDietStatementDto.description(), diet);
        List<DietStatement> lastDietStatement = dietStatementRepository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "createdDate")))
                .stream()
                .filter(dS -> dS.getDiet().getId().equals(diet.getId()))
                .toList();
        if(CollectionUtils.isEmpty(lastDietStatement)) {
            dietStatementRepository.save(newDietStatement);
            dietRepository.flush();
            return "Saved";
        } else if (isAddedToday(lastDietStatement.get(0).getCreatedDate())) {
            return "Already added today";
        } else {
            dietStatementRepository.save(newDietStatement);
            dietRepository.flush();
            return "Saved";
        }
    }

    private boolean isAddedToday(Timestamp createdDate) {
        int year = createdDate.toLocalDateTime().getYear();
        int yearDay = createdDate.toLocalDateTime().getDayOfYear();
        return LocalDate.now().getYear() == year && LocalDate.now().getDayOfYear() == yearDay;
    }

}
