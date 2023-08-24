package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Account2;

public class Wife2 extends Thread {
		private Account2 account;
		public Wife2(Account2 account) {
			// TODO Auto-generated constructor stub
			this.account=account;
		}
		@Override
		public void run() {
			account.deposite(2000);
			account.withdraw(5000);
		}

	}
