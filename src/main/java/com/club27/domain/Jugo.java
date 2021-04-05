package com.club27.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;


@Data
@Entity(name = "jugo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(force = true)
public class Jugo extends BaseEntity{

    public Jugo(String title, String videoURL, String videoComment, int videoLikes) {
        super();
        this.title = title;
        this.videoURL = videoURL;
        this.videoComment = videoComment;
        this.videoLikes = videoLikes;
    }

    public Jugo(UUID id, String title, String videoURL, String videoComment, int videoLikes) {
        super(id);
        this.title = title;
        this.videoURL = videoURL;
        this.videoComment = videoComment;
        this.videoLikes = videoLikes;
    }

    private String title;
    private String videoURL;
    private String videoComment;
    private int videoLikes;

}
