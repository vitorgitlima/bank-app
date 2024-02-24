package spring.projects.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.projects.bankingapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
