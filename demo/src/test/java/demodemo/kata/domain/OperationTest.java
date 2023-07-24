package demodemo.kata.domain;





import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import demo.kata.domain.Account;
import demo.kata.domain.Operation;

public class OperationTest {
	
	  private Account account;

	    @Before
	    public void init() {
	        account =new Account(1L, BigDecimal.ZERO, new ArrayList<Operation>());
	    }

	    @Test
	    public void should_return_account_operations_history() {
	        Operation operation1 = account.deposit(BigDecimal.valueOf(5000)).getOperations().get(0);
	        Operation operation2 = account.withdraw(BigDecimal.valueOf(1000)).getOperations().get(1);

	        List<Operation> accountOperations = account.getOperations();
	        List<Operation> operationList = new ArrayList<>();
	        operationList.add(operation1);
	        operationList.add(operation2);
	       
	        Assert. assertTrue(operationList.size() == accountOperations.size() && operationList.containsAll(accountOperations) && accountOperations.containsAll(operationList));
	        Assert.assertEquals(operation1,accountOperations.get(0));
	        Assert.assertEquals(operation2,accountOperations.get(1));
	        Assert.assertNotEquals(operation1, operation2);
	        
	    }

}
