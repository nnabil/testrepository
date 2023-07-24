package demo.kata.domain;

import java.math.BigDecimal;
import java.util.List;

import demo.kata.exceptions.InsufficientFundException;
import demo.kata.exceptions.withdrawNotPossbile;

public class Account {
	
	
	private final Long accountId;
    private BigDecimal balance;
    private List<Operation> operations;
    
    public Account(Long accountId, BigDecimal balance, List<Operation> operations) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.operations = operations;
	}
    
    /**
     * Make a deposit and log operation.
     *
     * @param amount the amount to be deposited
     * @return current account
     * @throws withdrawNotPossbile if the amount to withdraw is negative
     */
    public Account deposit(BigDecimal amount) throws withdrawNotPossbile {
    	checkTransactionAmount(amount);
        balance = balance.add(amount);
        this.addOperation(OperationsTypes.DEPOSIT, amount, balance, this.operations);
        return this;
    }
    
    /**
     * Withdraws funds from account if it has enough funds, and the supplied amount is positive.
     * Saves operation in the account operations.
     *
     * @param amount the amount of money to withdraw
     * @return the current account
     * @throws withdrawNotPossbile    if the amount to withdraw is negative
     * @throws InsufficientFundException if the account doesn't have enough funds for operation
     */
    public Account withdraw(BigDecimal amount) throws withdrawNotPossbile,InsufficientFundException {
    	this.checkTransactionAmount(amount);
        this.checkFund(amount, balance);
        balance = balance.subtract(amount);
        this.addOperation(OperationsTypes.WITHDRAW, amount, balance, this.operations);

        return this;
    }
    
    /**
     * Check if  account have sufficient fund or not.
     *
     * @param transactionAmount transaction amount to be checked
     * @throws InsufficientFundException if account have insufficient fund
     */
    private  void checkFund(BigDecimal transactionAmount, BigDecimal balance) {
        if (balance.compareTo(transactionAmount) < 0) throw new InsufficientFundException();
    }

	
	/**
	 * check if the transation amount is more than 0
	 * @param amount
	 * @throws withdrawNotPossbile if the amount to withdraw is negative
	 */
	private void checkTransactionAmount(BigDecimal amount) throws withdrawNotPossbile {
		if (amount.compareTo(BigDecimal.ZERO) <= 0)
			throw new withdrawNotPossbile();
	}
	
	 /**
     * Adds the requested operation with the amount to the operations history.
     *
     * @param transactionAmount the amount of money to validate
     * @param balance account balance
     * @param operationsTypes type of operation to be added
     * @param operations account operations list
     */
    private  void addOperation(OperationsTypes operationsTypes,BigDecimal transactionAmount, BigDecimal balance, List<Operation> operations) {
		Operation operation = new Operation(operationsTypes, transactionAmount, balance);
		operations.add(operation);
    }

	public List<Operation> getOperations() {
		return operations;
	}

	public BigDecimal getBalance() {
		return balance;
	}
    
    

}
