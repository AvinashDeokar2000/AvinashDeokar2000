package com.jspiders.multithreading.resource;

public class Account2 {
		   private int balance;
		   
		   public Account2(int balance) {
			   this.balance=balance;
		   }
		   public int checkBalance() {
			   return balance;
		   }
		   
		   public synchronized void deposite(int amount) {
			   System.out.println("Trying to deposite :"+amount+"Rs");
			   balance+=amount;
		       System.out.println("deposite successful");
		       System.out.println("Balance:"+ checkBalance());
		   }
		   public synchronized void withdraw(int amount) {
			   System.out.println("Trying to withdraw :"+amount+"Rs");
			   balance-=amount;
			   System.out.println("withdraw successful");
			   System.out.println("Balance:"+checkBalance());
		   }
		   
		   
		}
