package com.jspiders.multithreading.thread;

public class MyThread7 extends Thread{
	public void run() {
		
		System.out.println("Thread name:"+Thread.currentThread().getName());
		System.out.println("Priority of thread:"+Thread.currentThread().getPriority());
	}

}
