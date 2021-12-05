package com.bankenddebits.BankEndDebits.controller;

import com.bankenddebits.BankEndDebits.models.DebitResponse;
import com.bankenddebits.BankEndDebits.models.request.DebitRequest;
import com.bankenddebits.BankEndDebits.service.DebitService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Debit")
@CrossOrigin(origins = "*")
@Api(value = "Debits")

public class DebitController {

    @Autowired
    private DebitService debitService;

    @PutMapping("/")
    public DebitResponse debitResponse(@Valid @RequestBody DebitRequest debitRequest) throws Exception{
    return debitService.debitAccount(debitRequest);
    }
}
