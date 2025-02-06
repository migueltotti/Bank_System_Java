package entity;

import java.util.ArrayList;
import java.util.List;

public class BankSystem {
	private List<BankAccount> accountList = new ArrayList<>();
	
	public BankSystem() {
		super();
	}

	public boolean addAccount(BankAccount account) {
		
		if(accountExists(account) == true) 
			return false;
		
		accountList.add(account);
		
		return true;
	}
	
	public boolean removeAccount(BankAccount account) {
		
		if(!accountExists(account)) 
			return false;
		
		accountList.remove(account);
		
		return true;
	}
	
	public boolean userExists(String email) {
		boolean userExists = false;
		
		if(email.isEmpty() || accountList.size() == 0)
			userExists = false;
		
		for(BankAccount ba : accountList) {
			if(ba.getHolder().getEmail().equals(email)) {
				userExists = true;
				break;
			}
		}
		
		return userExists;
	}
	
	
	private boolean accountExists(BankAccount account) {
		return accountList.contains(account);
	}
	
	
}
