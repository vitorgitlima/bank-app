package spring.projects.bankingapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.projects.bankingapp.dto.AccountDto;
import spring.projects.bankingapp.entity.Account;
import spring.projects.bankingapp.mapper.AccountMapperManual;
import spring.projects.bankingapp.repository.AccountRepository;
import spring.projects.bankingapp.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapperManual mapperManual;

    @Override
    public AccountDto createAcount(AccountDto accountDto) {

        Account account = mapperManual.mapToAccount(accountDto);

        Account savedAccount = accountRepository.save(account);

        return mapperManual.mapToAccountDto(savedAccount);

    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));

        return mapperManual.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));

        double total = account.getBalance() + amount;
        account.setBalance(total);

        Account savedAccount = accountRepository.save(account);
        return mapperManual.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insuficient amount");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);

        Account save = accountRepository.save(account);

        return mapperManual.mapToAccountDto(save);
    }

    @Override
    public List<AccountDto> getAllAccounts() {

        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> mapperManual.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccout(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));

        accountRepository.deleteById(id);
    }
}
