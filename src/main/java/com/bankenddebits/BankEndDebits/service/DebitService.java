package com.bankenddebits.BankEndDebits.service;

import com.bankenddebits.BankEndDebits.models.DebitResponse;
import com.bankenddebits.BankEndDebits.models.entity.Account;
import com.bankenddebits.BankEndDebits.models.entity.Beneficiary;
import com.bankenddebits.BankEndDebits.models.request.DebitRequest;
import com.bankenddebits.BankEndDebits.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.logging.Logger;
import java.util.Optional;
import java.util.UUID;

@Service
public class DebitService {

    Logger logger = Logger.getLogger(DebitService.class.getName());

    @Autowired
    private AccountRepository accountRepository;


    public DebitResponse debitAccount(DebitRequest debitRequest) throws Exception {


        creditAccount(debitRequest.getAccountNumber(), debitRequest.getDebitValue() * -1);

        creditAccount(debitRequest.getBeneficiary().getAccountNumber(), debitRequest.getDebitValue());

        String debitID = UUID.randomUUID().toString();
        return new DebitResponse(debitID);

    }

    private void creditAccount(String accountNumber, Double amount) throws Exception {

        logger.info("Crediting account");

        Optional<Account> creditAccount = accountRepository.findByAccountNumber(accountNumber);

        if (creditAccount.isEmpty()) {
            logger.info("Error when locate account");
            throw new Exception("Account not exist");
        }

        // esse if começa a verificação pra quem vai ser creditado
        if (amount < 0) {
            logger.info("Checking balance");
            // saldo atual - valor para creditar não pode ser < 0
            // Se o valor dessa subtração for menor que 0 significa que o cara não tem o saldo, aí deve lançar o erro
            // tenta agora
            // coloquei como soma pq o Amount vem negativo
            if (creditAccount.get().getBalance() + amount < 0) {
                throw new Exception("Balance Insufficient");
            }

            // hoje eu precisava arrumar o seguinte bug
            // O cliente tinha 51 reais em conta, e o caixa eletrônico (banco 24h) só tinha notas de 50 reais
            // Se o cara não tiver taxa, ele consegue fazer o SAque normal. Até aí blz.
            // Mas e se o Saque dele for tarifado ? A tarifa do Saque é 6,9. Passa do saldo de 51 reais dele
            // Fiquei uns 30 minutos pensando como fazer isso....
            // Aí eu escrevi igual estou fazendo agora, aí eu fiz um passo a passo
            // Exemplo:

            // valor que sobra para ser taxado =  saldo - menor nota que posso sacar
            // valor que sobra pra ser taxado < taxa -> LANÇA ERRO
            // Escreve o Algoritmo no código como um passo a passo simples pra vc conseguir clarear a mente

        }
        Double amountToCredit = creditAccount.get().getBalance() + amount;

        creditAccount.get().setBalance(amountToCredit);

        accountRepository.save(creditAccount.get());


    }
}
