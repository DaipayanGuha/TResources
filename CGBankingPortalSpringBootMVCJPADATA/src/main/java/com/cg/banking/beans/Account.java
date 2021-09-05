package com.cg.banking.beans;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;


@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long accountNo;
	
	private int pinNumber;
	
	@NotEmpty
	private String accountType;
	
	@NotEmpty
	private String accountStatus;
	
	@NotEmpty
	private float accountBalance;
	
	private int invalidPinAttempts;
	
	@OneToMany(mappedBy="account")
	@MapKey
	private Map<Integer,Transaction> transactions;
	
	public int getPinAttempts() {
		return invalidPinAttempts;
	}

	public int incrPinAttempts() {
		return invalidPinAttempts++;
	}
	
	public void resetPinAttempts() {
		invalidPinAttempts = 0;
		
	}
	
	public Account() {
		super();
	}
	
	public Account(String accountType, float accountBalance) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public Account(int pinNumber, String accountType, String accountStatus, float accountBalance) {
		super();
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
	}
	

	public Account(long accountNo, String accountType, String accountStatus, float accountBalance) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
	}

	public Account(long accountNo, int pinNumber, String accountType, String accountStatus, float accountBalance) {
		super();
		this.accountNo = accountNo;
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
	}

	public Account(long accountNo, int pinNumber, String accountType, String accountStatus, float accountBalance,
			HashMap<Integer, Transaction> transactions) {
		super();
		this.accountNo = accountNo;
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.transactions = transactions;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	

	public Map<Integer, Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Map<Integer, Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", pinNumber=" + pinNumber + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + ", accountBalance=" + accountBalance + ", invalidPinAttempts="
				+ invalidPinAttempts + ", transactions=" + transactions + "]";
	}
	
	
	
}
