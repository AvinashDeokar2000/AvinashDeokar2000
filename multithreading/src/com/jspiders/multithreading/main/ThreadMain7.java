package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread7;

public class ThreadMain7 {

	public static void main(String[] args) {
		MyThread7 myThread7=new MyThread7();
		Thread thread=new Thread(myThread7);
		thread.setName("MyThread7");
		thread.setPriority(6);
		thread.start();

	}

}
