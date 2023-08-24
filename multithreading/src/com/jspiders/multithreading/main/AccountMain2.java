package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.Account2;
import com.jspiders.multithreading.thread.Husband2;
import com.jspiders.multithreading.thread.Wife2;

public class AccountMain2 {
		public static void main(String[] args) {
			
		
		Account2 account = new Account2(10000);
		Husband2 husband=new Husband2(account);
		Wife2 wife =new Wife2(account);
		husband.start();
		wife.start();
		}

	}
