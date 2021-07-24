package tests.factory;

import entities.Account;

public class AccountFactory {
	
	public static Account CreateEmptyAccount() {
		return new Account(1L, 0.0);
	}
	
	public static Account CreateAccount(double initialBalance) {
		return new Account(1L, initialBalance);
	}
}
