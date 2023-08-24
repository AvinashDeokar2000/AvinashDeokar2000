package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread5;

public class ThreadMain5 {

	public static void main(String[] args) {
		MyThread5 myThread5=new MyThread5();
		System.out.println("Name of thread:"+myThread5.getName());
		System.out.println("Priority of thread"+myThread5.getPriority());
	    myThread5.start();
	}

}
