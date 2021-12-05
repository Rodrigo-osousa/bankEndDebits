package com.bankenddebits.BankEndDebits.models;


public class DebitResponse {
    private String debitId;

    public DebitResponse(String debitId) {
        this.debitId = debitId;
    }

    public String getDebitId() {
        return debitId;
    }

    public void setDebitId(String debitId) {
        this.debitId = debitId;
    }
}
