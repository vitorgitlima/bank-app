package spring.projects.bankingapp.service;

import spring.projects.bankingapp.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAcount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccout(Long id);
}
