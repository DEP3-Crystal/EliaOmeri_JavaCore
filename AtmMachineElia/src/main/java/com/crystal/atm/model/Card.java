package com.crystal.atm.model;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)

@Data
public class Card {
    private final   String idCard;
    private final String AccountId;
    private String pin;
    private final String cvv;
    private  int validMonth ;
    private  int validYear;

    public Card(String idCard, String accountId, String pin, String cvv, int validMonth, int validYear) {
        this.idCard = idCard;
        AccountId = accountId;
        this.pin = pin;
        this.cvv = cvv;
        this.validMonth = validMonth;
        this.validYear = validYear;
    }
}
