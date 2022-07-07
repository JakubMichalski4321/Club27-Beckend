package com.club27.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(force = true)
@Entity(name = "dept")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Dept extends BaseEntity {

    private Double balance;
    private String deptAccountName;

    @ManyToMany(mappedBy = "userDepts")
    private List<UserAccount> userAccounts;

    @OneToMany(mappedBy = "dept")
    private List<AccountStatement> statements;

    public Dept(Double balance, String deptAccountName) {
        super();
        this.balance = balance;
        this.deptAccountName = deptAccountName;
    }

}
