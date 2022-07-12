package com.club27.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor(force = true)
@Entity(name = "account_statement")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AccountStatement extends BaseEntity {

    private Double amount;
    private String title;
    private String description;
    private String deptUserId;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Dept dept;

    public AccountStatement(Double amount, String title, String description, String deptUserId, Dept dept) {
        super();
        this.amount = amount;
        this.title = title;
        this.description = description;
        this.deptUserId = deptUserId;
        this.dept = dept;
    }
}
