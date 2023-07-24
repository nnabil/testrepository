package demo.kata.service;

import java.math.BigDecimal;
import java.util.List;

import demo.kata.domain.Account;
import demo.kata.domain.Operation;
import demo.kata.exceptions.InsufficientFundException;
import demo.kata.exceptions.withdrawNotPossbile;

public class AccountServiceImpl implements AccountService {

	/**
	 * Make a Deposits to account.
	 *
	 * @param account       account
	 * @param depositAmount deposit operation amount
	 *
	 * @return operation account
	 * @throws withdrawNotPossbile if deposit amount is negative
	 */
	public Account deposit(Account account, BigDecimal depositAmount) throws withdrawNotPossbile {
		return account.deposit(depositAmount);
	}

	/**
	 * Withdraws from account.
	 *
	 * @param account the account for which the operation is requested
	 * @param amount  the amount of money to withdraw
	 *
	 * @return the account of the current operation
	 * @throws withdrawNotPossbile       if the amount to withdraw is negative
	 * @throws InsufficientFundException if the account doesn't have enough funds
	 *                                   for the operation
	 */
	public Account withdraw(Account account, BigDecimal amount) throws withdrawNotPossbile, InsufficientFundException {
		return account.withdraw(amount);
	}

	public List<Operation> getAccountOperationsHistory(Account account) {
		return account.getOperations();
	}

}
