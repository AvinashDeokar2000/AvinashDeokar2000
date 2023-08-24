package com.jspiders.multithreading.thread;

public class MyThread6 extends Thread {
	public void run() {
		System.out.println("Thread name:"+getName());
		System.out.println("Prioroty of thread:"+getPriority());
	}

}
