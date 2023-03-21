package com.club27.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
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

    private String requestToRemove;

}
