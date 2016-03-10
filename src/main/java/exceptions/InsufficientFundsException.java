package exceptions;

import java.io.*;

public class InsufficientFundsException extends Exception {
	private double amountNeeded;

	public InsufficientFundsException(double amountNeeded) {
		//Make sure that the value is positive, makes no sense
		//To say you need negative money
		this.amountNeeded = Math.abs(amountNeeded);
		System.out.println("You do not have enough money in your account to withdraw");
		System.out.println("You need "+amountNeeded+"$ more to do that deposit");
	}

	public double getAmountNeeded() {
		return amountNeeded;
	}

}
