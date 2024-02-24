package spring.projects.bankingapp.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import spring.projects.bankingapp.dto.AccountDto;
import spring.projects.bankingapp.entity.Account;

@Component
public class AccountMapperManual {

    public Account mapToAccount(AccountDto accountDto) {

        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return account;
    }

    public AccountDto mapToAccountDto(Account account) {

        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );

        return accountDto;

    }

}
