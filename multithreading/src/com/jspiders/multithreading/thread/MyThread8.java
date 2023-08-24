package com.jspiders.multithreading.thread;

public class MyThread8 extends Thread{
	@Override
            public void run() {
            	for(int i=1;i<=5;i++) {
            		if(i == 3) {
            			stop();
            		}
            		System.out.println(getName()+"is now running");
            	}
            }
}
