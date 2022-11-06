package com.club27.services;

import com.club27.domain.Calendar;
import com.club27.exception.ObjectNotFoundException;
import com.club27.repositories.CalendarRepository;
import com.club27.repositories.UserAccountRepository;
import com.club27.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository calendarRepository;
    private final UserAccountRepository userRepository;

    public List<UserWithCheckedHours> getCalendarForWeek(CalendarWeekDto dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime weekStartDate =  LocalDateTime.parse(dto.weekStartDate() + " 00:00", formatter);
        LocalDateTime weekEndDate =  LocalDateTime.parse(dto.weekEndDate() + " 23:59", formatter);

        List<UserWithCheckedHours> result = new ArrayList<>();

        var calendars = calendarRepository.findByWeekStartDateAndWeekEndDate(weekStartDate, weekEndDate);

        Map<String, List<Calendar>> calendarsGroupUsername = calendars.stream().collect(Collectors.groupingBy(Calendar::getUsername));

        for (Map.Entry<String, List<Calendar>> userCalendars : calendarsGroupUsername.entrySet()) {
            List<CheckedHour> checkedHours = new ArrayList<>();
            userCalendars.getValue().forEach(calendar -> {
                checkedHours.add(new CheckedHour(
                        calendar.getId().toString(),
                        calendar.getDay(),
                        calendar.getHour()
                ));
            });
            result.add(new UserWithCheckedHours(checkedHours, userCalendars.getKey()));
        }
        return result;
    }

    @Transactional
    public String addUserCalendar(CalendarAddDto dto) {
        if(userRepository.findByName(dto.username()).isEmpty()) {
           throw new ObjectNotFoundException("Cannot find user" + dto.username() + " in database");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        Calendar newCalendar = calendarRepository.save(new Calendar(
                dto.username(),
                dto.userId(),
                dto.day(),
                dto.hour(),
                LocalDateTime.parse(dto.weekStartDate() + " 00:00", formatter),
                LocalDateTime.parse(dto.weekEndDate() + " 23:59", formatter)
        ));
        return newCalendar.getId().toString();
    }

    public boolean removeCalendar(String id) {
        calendarRepository.deleteById(UUID.fromString(id));
        return true;
    }
}
