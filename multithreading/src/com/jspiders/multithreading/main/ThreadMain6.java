package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread6;

public class ThreadMain6 {

	public static void main(String[] args) {
		MyThread6 myThread6=new MyThread6();
		myThread6.setName("Thread");
		myThread6.setPriority(7);
		myThread6.start();

	}

}
