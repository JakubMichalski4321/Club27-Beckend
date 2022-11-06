package com.club27.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "calendar")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(force = true)
public class Calendar extends BaseEntity {

    private String username;
    private String userId;
    private int day;
    private int hour;
    private LocalDateTime weekStartDate;
    private LocalDateTime weekEndDate;

    public Calendar(String username, String userId, int day, int hour, LocalDateTime weekStartDate, LocalDateTime weekEndDate) {
        super();
        this.username = username;
        this.userId = userId;
        this.day = day;
        this.hour = hour;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
    }

    public Calendar(UUID id, String username, String userId, int day, int hour, LocalDateTime weekStartDate, LocalDateTime weekEndDate) {
        super(id);
        this.username = username;
        this.userId = userId;
        this.day = day;
        this.hour = hour;
        this.weekStartDate = weekStartDate;
        this.weekEndDate = weekEndDate;
    }

}
