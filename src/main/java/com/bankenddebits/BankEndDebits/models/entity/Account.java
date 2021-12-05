package com.bankenddebits.BankEndDebits.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String documentNumber;

    private String accountNumber;

    private int agency;

    private Double credit;

    private Double balance;

    private Boolean inactive;

    public Account(){

    }

    public Account(int id, String name, String documentNumber, String accountNumber, int agency, Double credit, Double balance, Boolean inactive) {
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.credit = credit;
        this.balance = balance;
        this.inactive = inactive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getInactive() {
        return inactive;
    }

    public void setInactive(Boolean inactive) {
        this.inactive = inactive;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", agency=" + agency +
                ", credit=" + credit +
                ", balance=" + balance +
                ", inactive=" + inactive +
                '}';
    }
}
