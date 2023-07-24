package demo.kata.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import demo.kata.domain.Account;
import demo.kata.domain.Operation;
import demo.kata.exceptions.withdrawNotPossbile;

public class AccountServiceTest {

	private Account account;

	private AccountService accountService;

	@Before
	public void init() {
		account = new Account(1L, BigDecimal.ZERO, new ArrayList<Operation>());
		accountService = new AccountServiceImpl();
	}

	@Test
	public void should_return_account_with_expected_balance_after_deposit() throws withdrawNotPossbile {

		BigDecimal currentAccountBalance = account.getBalance();

		Account accountAfterDeposit =accountService.deposit(account, BigDecimal.valueOf(2000));

		Assert.assertEquals(accountAfterDeposit.getBalance().subtract(currentAccountBalance), new BigDecimal(2000));

	}

	@Test
	public void should_return_account_with_expected_balance_after_withdraw() throws withdrawNotPossbile {
		
		BigDecimal currentAccountBalance = account.getBalance();
	
		account.deposit(BigDecimal.valueOf(2000));

		Account accountAfterwithdraw = accountService.withdraw(account, BigDecimal.valueOf(2000));

		Assert.assertEquals(accountAfterwithdraw.getBalance(),currentAccountBalance);
	}
	
	 @Test
	    public void should_return_complete_account_operations_history() throws withdrawNotPossbile {
	        Operation operation1 = account.deposit(BigDecimal.valueOf(100)).getOperations().get(0);
	        Operation operation2 = account.deposit(BigDecimal.valueOf(100)).getOperations().get(1);
	        Operation operation3 = account.withdraw(BigDecimal.valueOf(100)).getOperations().get(2);
	        List<Operation> accountOperations = account.getOperations();
	        
	        List<Operation> accountOperationsfromService =accountService.getAccountOperationsHistory(account);
	        
	        Assert. assertTrue(accountOperationsfromService.size() == accountOperations.size() && accountOperationsfromService.containsAll(accountOperations) && accountOperations.containsAll(accountOperationsfromService));
	        assertThat(operation1).isEqualTo(accountOperations.get(0));
	        assertThat(operation2).isEqualTo(accountOperations.get(1));
	        assertThat(operation3).isEqualTo(accountOperations.get(2));

	    }

}
