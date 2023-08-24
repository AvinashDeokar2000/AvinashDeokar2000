package com.jspiders.multithreading.thread;

public class MyThread4 implements Runnable {
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println("MyThread four is now running");
		}
	}

}
