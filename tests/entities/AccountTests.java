package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.CreateEmptyAccount();
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void depositShouldDoNotthingWhenNegativeAmount() {
		double amount = -200.0;
		double expectedValue = 100;
		Account acc = AccountFactory.CreateAccount(expectedValue);
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void fullWithdrawShouldClearBalance() {
		double initialBalance = 800.0;
		double expectedValue = 0.0;
		Account acc = AccountFactory.CreateAccount(initialBalance);
		
		double result = acc.fullwithdraw();
		
		Assertions.assertTrue(expectedValue==acc.getBalance());
		Assertions.assertTrue(result==initialBalance);
	}
	
	@Test
	public void withDrawShouldDecreaseBalanceWhenSufficientBalance() {	
		Account acc = AccountFactory.CreateAccount(800.0);
		acc.withdraw(500.0);
		Assertions.assertEquals(300.0, acc.getBalance());
	}
	
	@Test
	public void withDrawShouldThrowExceptionWhenInsufficientBalance() {	
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			Account acc = AccountFactory.CreateAccount(800.0);
			acc.withdraw(801.0);
		});
	}
}
