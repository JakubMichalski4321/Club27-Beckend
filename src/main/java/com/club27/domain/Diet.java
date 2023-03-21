package com.club27.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(force = true)
@Entity(name = "diet")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Diet extends BaseEntity{
    private String dietName;
    private Double dietBalance;
    @OneToOne
    private UserAccount userAccount;
    @OneToMany(mappedBy = "diet")
    private List<DietStatement> statements;

    public Diet(String dietName, Double dietBalance) {
        super();
        this.dietName = dietName;
        this.dietBalance = dietBalance;
    }

}
