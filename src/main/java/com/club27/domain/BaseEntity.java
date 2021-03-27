package com.club27.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    public BaseEntity(UUID id) {
        this.id = id;
        createdDate = Timestamp.valueOf(LocalDateTime.now());
    }
    public BaseEntity(){
        createdDate = Timestamp.valueOf(LocalDateTime.now());
    }

    @CreationTimestamp
    @Column(updatable = false)
    private final Timestamp createdDate;

}
