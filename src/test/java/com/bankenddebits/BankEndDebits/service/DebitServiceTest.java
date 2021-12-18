package com.bankenddebits.BankEndDebits.service;

import com.bankenddebits.BankEndDebits.models.entity.Account;
import com.bankenddebits.BankEndDebits.models.entity.Beneficiary;
import com.bankenddebits.BankEndDebits.models.request.DebitRequest;
import com.bankenddebits.BankEndDebits.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
class DebitServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private DebitService debitService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void debitAccountWithoutBalance() {
        Account account = new Account();
        account.setBalance(0.0);
        account.setDocumentNumber("999999999");
        account.setAccountNumber("9999");


        Account account2 = new Account();
        account2.setBalance(0.0);
        account2.setDocumentNumber("123123123");
        account2.setAccountNumber("1234");

        when(accountRepository.findByAccountNumber(anyString())).thenReturn(Optional.of(account));

        DebitRequest debitRequest = new DebitRequest();
        debitRequest.setDebitDate(Date.from(Instant.now()));
        debitRequest.setDebitValue(100.0);
        debitRequest.setName("Tabajara Macedo");
        debitRequest.setDocumentNumber("999999999");
        debitRequest.setAccountNumber("9999");

        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setAccountNumber("1234");
        beneficiary.setAccountNumber("123123123");
        beneficiary.setName("Ubirajara Santos");
        debitRequest.setBeneficiary(beneficiary);


        Assertions.assertThrows(Exception.class, () ->
                debitService.debitAccount(debitRequest));

    }
}