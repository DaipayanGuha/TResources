package com.cg.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.TransactionDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;

public class BankingServicesImpl implements BankingServices {
	
	@Autowired
	private AccountDAO custData1;
	
	@Autowired
	private TransactionDAO transacData;
	
	private final static float minBalance = 1000;
	private final static int maxInvalidPinAttempts = 3;

	@Override
	public Account openAccount(Account account)
			throws InvalidAccountTypeException, InvalidAmountException, BankingServicesDownException {
		if (account.getAccountBalance() <= minBalance)
			throw new InvalidAmountException();
		Account cust = custData1.save(account);
		transacData.save(new Transaction(account.getAccountBalance(), "Deposit",cust));
		return cust;
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account customers = null;
		customers = getAccountDetails(accountNo);
		if(customers==null)
			throw new AccountNotFoundException("Account does not exsit!");
		else if (customers.getAccountStatus().equalsIgnoreCase("Blocked"))
			throw new AccountBlockedException();
		else
			customers.setAccountBalance(customers.getAccountBalance() + amount);
		
		//this.custData1.update(customers);
		//transacData.save(customers));
		Transaction t = new Transaction(amount, "Deposit", customers);
		transacData.save(t);
		
		return customers.getAccountBalance();
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account customers = null;
		customers = getAccountDetails(accountNo);
		if(customers==null)
			throw new AccountNotFoundException("Account does not exsit!");
		else if (customers.getAccountStatus().equalsIgnoreCase("Blocked"))
			throw new AccountBlockedException("Account Blocked!");
		else if (customers.getPinNumber() != pinNumber) {
			customers.incrPinAttempts();
			System.out.println("Invalid Pin, Try again");
			if (customers.getPinAttempts() == maxInvalidPinAttempts) {
					customers.setAccountStatus("Blocked");
					throw new AccountBlockedException();
				}
			throw new InvalidPinNumberException();
		}
		else if(customers.getPinAttempts() > 0 && !(customers.getAccountStatus().equalsIgnoreCase("Blocked")))
			customers.resetPinAttempts();
		else if (customers.getAccountBalance() - amount <= minBalance)
			throw new InsufficientAmountException();
		else
			customers.setAccountBalance(customers.getAccountBalance() - amount);
		//this.custData1.update(customers);
		//transacData.save(customers, new Transaction(amount, "Withdraw"));
		//return customers.getAccountBalance();
		
		this.custData1.save(customers);
		Transaction t = new Transaction(amount, "Withdraw", customers);
		transacData.save(t);
		
		return customers.getAccountBalance();

	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, BankingServicesDownException,
			AccountBlockedException, InvalidPinNumberException {

		Account customerTo = getAccountDetails(accountNoTo);
		Account customerFrom = getAccountDetails(accountNoFrom);
		if (customerFrom.getAccountBalance() - transferAmount <= minBalance)
			throw new InsufficientAmountException();
		else if (customerFrom.getPinNumber() != pinNumber)
			throw new InvalidPinNumberException();
		else {
			/*
			 * this.custData1.update(customerTo); this.custData1.update(customerFrom);
			 * transacData.save(customerFrom,new Transaction(transferAmount,"Withdraw"));
			 * transacData.save(customerTo,new Transaction(transferAmount,"Deposit"));
			 * withdrawAmount(customerFrom.getAccountNo(), transferAmount,
			 * customerFrom.getPinNumber()); depositAmount(customerTo.getAccountNo(),
			 * transferAmount);
			 */
			customerFrom.setAccountBalance(customerFrom.getAccountBalance()-transferAmount);
			this.custData1.save(customerFrom);
			this.custData1.save(customerTo);
			transacData.save(new Transaction(transferAmount, "Withdraw", customerFrom));
			transacData.save(new Transaction(transferAmount, "Deposit", customerTo));
			depositAmount(customerTo.getAccountNo(), transferAmount);
			withdrawAmount(accountNoFrom, transferAmount, pinNumber);
		}

		return true;
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		return custData1.findById(accountNo).orElseThrow(()-> new AccountNotFoundException("Associate Details not found for : " + accountNo));
	}

	@Override
	public List<Account> getAllAccountDetails() throws BankingServicesDownException {
		List<Account> customers = custData1.findAll();
		return customers;
	}

	//@Override
	//public List<Transaction> getAccountAllTransaction(long accountNo)throws BankingServicesDownException, AccountNotFoundException {
	//	return transacData.findAllById(accountNo);
	//}

	@Override
	public String accountStatus(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Account customers = custData1.findById(accountNo).orElseThrow(()-> new AccountNotFoundException("Associate Details not found for : " + accountNo));
		 if (customers.getAccountStatus().equalsIgnoreCase("Blocked"))
			throw new AccountBlockedException();
		return customers.getAccountStatus();
	}

}
