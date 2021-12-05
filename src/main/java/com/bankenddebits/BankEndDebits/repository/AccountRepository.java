package com.bankenddebits.BankEndDebits.repository;

import com.bankenddebits.BankEndDebits.models.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;



public interface AccountRepository extends CrudRepository<Account, Integer> {
    Optional<Account> findByAccountNumber (String accountNumber);
}
