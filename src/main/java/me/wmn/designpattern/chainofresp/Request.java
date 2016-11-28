package me.wmn.designpattern.chainofresp;

public class Request {
	
	private double amount;

	public Request(double amount){
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
