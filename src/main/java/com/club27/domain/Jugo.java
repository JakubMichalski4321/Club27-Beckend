package com.club27.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor(force = true)
@Data

public class Jugo extends BaseEntity{

    private final String title;
    private final String videoURL;
    private final String videoComment;
    private final int videoLikes;

    public Jugo(UUID id, String title, String videoURL, String videoComment, int videoLikes) {
        super(id);
        this.title = title;
        this.videoURL = videoURL;
        this.videoComment = videoComment;
        this.videoLikes = videoLikes;
    }

}
