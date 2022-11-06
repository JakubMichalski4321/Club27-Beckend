package com.club27.web.controllers;

import com.club27.services.CalendarService;
import com.club27.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/calendar")
@Slf4j
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @PostMapping("/getWeek")
    public ResponseEntity<List<UserWithCheckedHours>> getCalendar(@Valid @RequestBody CalendarWeekDto calendarWeekDto) {
        var response = calendarService.getCalendarForWeek(calendarWeekDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<StringWrapper> addCalendar(@Valid @RequestBody CalendarAddDto calendarAddDto) {
        String newCalendarId = calendarService.addUserCalendar(calendarAddDto);
        if(newCalendarId != null) {
            return new ResponseEntity<>(new StringWrapper(newCalendarId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<Void> removeCalendar(@PathVariable("id") String id) {
        if(calendarService.removeCalendar(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
