package com.example.springinitdemo.services;

import java.math.BigDecimal;

public interface AccountService {

    void withdrawMoney(BigDecimal amount, long id);
    void depositMoney(BigDecimal amount, long id);
}
