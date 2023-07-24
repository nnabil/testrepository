package demo.kata;

import java.math.BigDecimal;
import java.util.ArrayList;

import demo.kata.domain.Account;
import demo.kata.domain.Operation;
import demo.kata.service.AccountService;
import demo.kata.service.AccountServiceImpl;

public class BankAccountApp {

	public static void main(String[] args) {

		Account account = new Account(1L, BigDecimal.ZERO, new ArrayList<Operation>());
		AccountService accountService = new AccountServiceImpl();

		accountService.deposit(account, BigDecimal.valueOf(1000));
		accountService.withdraw(account, BigDecimal.valueOf(200));
		accountService.deposit(account, BigDecimal.valueOf(1230));
		accountService.withdraw(account, BigDecimal.valueOf(30));
		
		accountService.getAccountOperationsHistory(account).forEach(operation -> System.out.println(operation.toString()));

	}

}
