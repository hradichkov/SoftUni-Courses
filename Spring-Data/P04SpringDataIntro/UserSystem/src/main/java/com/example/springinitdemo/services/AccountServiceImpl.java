package com.example.springinitdemo.services;

import com.example.springinitdemo.models.Account;
import com.example.springinitdemo.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, long id) {
        Optional<Account> account = this.accountRepository.findById(id);

        if (account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }

        BigDecimal currentBalance = account.get().getBalance();

        if (currentBalance.compareTo(amount) < 0){
            throw new RuntimeException("Cannot withdraw");
        }

        account.get().setBalance(currentBalance.subtract(amount));
        this.accountRepository.save(account.get());
    }

    @Override
    public void depositMoney(BigDecimal amount, long id) {
        Account account = this.accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));

        BigDecimal balance = account.getBalance().add(amount);
        account.setBalance(balance);

        this.accountRepository.save(account);
    }
}
