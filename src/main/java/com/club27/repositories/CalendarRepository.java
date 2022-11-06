package com.club27.repositories;

import com.club27.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, UUID> {
    List<Calendar> findByWeekStartDateAndWeekEndDate(LocalDateTime weekStartDate, LocalDateTime weekEndDate);
}
