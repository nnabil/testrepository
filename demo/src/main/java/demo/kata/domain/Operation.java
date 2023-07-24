package demo.kata.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Operation {
	  private final OperationsTypes operationsTypes;
	    private final LocalDateTime date;
	    private final BigDecimal amount;
	    private final BigDecimal balance;
	  	    
	    
		public Operation(demo.kata.domain.OperationsTypes operationsTypes,  BigDecimal amount,
				BigDecimal balance) {
			super();
			this.operationsTypes = operationsTypes;
			this.date = LocalDateTime.now();
			this.amount = amount;
			this.balance = balance;
		}


		@Override
		public String toString() {
			return "Operation [operationsTypes=" + operationsTypes + ", date=" + date + ", amount=" + amount
					+ ", balance=" + balance + "]";
		}
		
	    
}
