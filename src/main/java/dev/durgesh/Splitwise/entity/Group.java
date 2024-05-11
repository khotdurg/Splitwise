package dev.durgesh.Splitwise.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "SPLITWISE_GROUP") //because syntax error in sql
public class Group extends BaseModel{
    private String name;
    @ManyToOne
    private User createdBy;
    private LocalDateTime creationDate;
    private double totalAmountSpent;
    @ManyToMany
    private List<User> members;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<SettlementTransaction> settlementTransactions;

}
/*
        Group       User
          1          1
          M          1

          Group:User -> M:1
 */