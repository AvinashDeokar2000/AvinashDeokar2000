package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Account2;

	public class Husband2 extends Thread {
		private Account2 account;
		public Husband2(Account2 account) {
			// TODO Auto-generated constructor stub
			this.account=account;
		}
		@Override
		public void run() {
			account.deposite(5000);
			account.withdraw(2000);
			
		}

	}


