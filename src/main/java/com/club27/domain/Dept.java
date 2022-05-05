package com.club27.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.mapstruct.control.MappingControl;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(force = true)
@Entity(name = "dept")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Dept extends BaseEntity{

    private Double balance;

    @ManyToMany(mappedBy = "userDepts")
    private List<UserAccount> userAccounts;

    @OneToMany(mappedBy = "dept")
    private List<AccountStatement> statements;

    public Dept(Double balance) {
        super();
        this.balance = balance;
    }

}
