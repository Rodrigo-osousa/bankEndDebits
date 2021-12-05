package com.bankenddebits.BankEndDebits.models.entity;

public class Beneficiary {


    private String name;

    private String documentNumber;

    private String accountNumber;

    public Beneficiary(String name, String documentNumber, String accountNumber) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.accountNumber = accountNumber;

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

    @Override
    public String toString() {
        return "Beneficiary{" +
                ", name='" + name + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }

}
