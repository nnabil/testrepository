package demodemo.kata.domain;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import demo.kata.domain.Account;
import demo.kata.domain.Operation;
import demo.kata.exceptions.InsufficientFundException;
import demo.kata.exceptions.withdrawNotPossbile;



public class AccountTest {
	   private Account account;

	    @Before
	    public void init() {
	        account = new Account(1L, BigDecimal.ZERO, new ArrayList<Operation>());
	    }

	    @Test
	    public void should_have_deposit_amount_as_balance() throws withdrawNotPossbile {
	        BigDecimal currentAccountBalance = account.getBalance();

	        account.deposit(BigDecimal.valueOf(4000));

	        Assert.assertEquals(account.getBalance().subtract(currentAccountBalance), new BigDecimal(4000));
	    }

	    @Test
	    public void should_have_exact_balance_after_withdraw() throws withdrawNotPossbile {
	        account.deposit(new BigDecimal(5000));
	       

	        account.withdraw(BigDecimal.valueOf(2000));

	        Assert.assertEquals(account.getBalance(), new BigDecimal(3000));
	    }

	    @Test(expected = withdrawNotPossbile.class)
	    public void should_throw_withdrawNotPossbile_if_amount_to_deposit_is_negative() throws withdrawNotPossbile {
	        account.deposit(BigDecimal.valueOf(-300));
	    }

	    @Test(expected = withdrawNotPossbile.class)
	    public void should_throw_withdrawNotPossbile_if_amount_to_withdraw_is_negative() throws withdrawNotPossbile {
	        account.withdraw(BigDecimal.valueOf(-100));
	    }

	    @Test(expected = InsufficientFundException.class)
	    public void should_throw_InsufficientFundException_if_insufficient_fund_on_withdraw() throws InsufficientFundException, withdrawNotPossbile {
	        account.withdraw(BigDecimal.valueOf(100));
	    }

}
