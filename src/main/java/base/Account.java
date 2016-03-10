package base;

import java.util.Date;
import exceptions.InsufficientFundsException;
public class Account {
	private int id;
	double balance;
	double annualInterestRate;
	private Date dateCreated;

	public Account() {
		this(0, 0, 0);
	}

	public Account(int id, double balance, double annualInterestRate) {
		super();
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		dateCreated = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public double getMonthlyInterestRate() {
		return getAnnualInterestRate() / 12;
	}

	public void deposit(double amount) {
		setBalance(getBalance()+amount);
	}
	public void withdraw(double amount) throws InsufficientFundsException{
		if (getBalance()-amount>0){
			setBalance(getBalance()-amount);	
		}
		else{
			double amountNeeded = getBalance()-amount;
			throw new InsufficientFundsException(amountNeeded);
		}
	}
}
