package com.bankenddebits.BankEndDebits.service;

import com.bankenddebits.BankEndDebits.models.DebitResponse;
import com.bankenddebits.BankEndDebits.models.entity.Account;
import com.bankenddebits.BankEndDebits.models.request.DebitRequest;
import com.bankenddebits.BankEndDebits.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class DebitService {

    Logger logger = Logger.getLogger(DebitService.class.getName());

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public DebitResponse debitAccount(DebitRequest debitRequest) throws Exception {


        creditAccount(debitRequest.getAccountNumber(), debitRequest.getDebitValue() * -1);

        creditAccount(debitRequest.getBeneficiary().getAccountNumber(), debitRequest.getDebitValue());

        String debitID = UUID.randomUUID().toString();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy HH:mm:ss");
        String todayFormated = sdf.format(new Date());
        kafkaTemplate.send("debitId", debitID + "|" + debitRequest.getDebitValue() + "|" + todayFormated);

        return new DebitResponse(debitID);

    }

    private void creditAccount(String accountNumber, Double amount) throws Exception {

        logger.info("Crediting account");

        Optional<Account> creditAccount = accountRepository.findByAccountNumber(accountNumber);

        if (creditAccount.isEmpty()) {
            logger.info("Error when locate account");
            throw new Exception("Account not exist");
        }

        if (amount < 0) {
            logger.info("Checking balance");

            if (creditAccount.get().getBalance() + amount < 0) {
                logger.info("Balance Insufficient");
                throw new Exception("Balance Insufficient");
            }

        }
        Double amountToCredit = creditAccount.get().getBalance() + amount;

        creditAccount.get().setBalance(amountToCredit);

        accountRepository.save(creditAccount.get());


    }
}
