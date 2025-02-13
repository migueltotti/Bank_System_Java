package entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankSystem {
	private List<BankAccount> accountList;
	
	public BankSystem() {
		super();
		accountList = new ArrayList<>();
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
	
	public boolean userExists(int id) {
		boolean userExists = false;
		
		if(accountList.size() == 0)
			userExists = false;
		
		for(BankAccount ba : accountList) {
			if(ba.getHolder().getId() == id) {
				userExists = true;
				break;
			}
		}
		
		return userExists;
	}
	
	public BankAccount getAccount(int holderId) {
		BankAccount account = null;
		
		if(accountList.size() == 0)
			account = null;
		
		for(BankAccount ba : accountList) {
			if(ba.getHolder().getId() == holderId) {
				account = ba;
				break;
			}
		}
		
		return account;
	}
	
	
	public BankAccount getAccount(String holderEmail) {
		BankAccount account = null;
		
		if(holderEmail.isEmpty() || accountList.size() == 0)
			account = null;
		
		for(BankAccount ba : accountList) {
			//System.out.println(ba.getHolder().getId());
			if(ba.getHolder().getEmail().equals(holderEmail)) {
				account = ba;
				break;
			}
		}
		
		//System.out.println(account);
		
		return account;
	}
	
	
	private boolean accountExists(BankAccount account) {
		return accountList.contains(account);
	}
}
