package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Pizza2;

public class Friends extends Thread {
	private Pizza2 pizza;
	
	public Friends(Pizza2 pizza) {
		this.pizza=pizza;
	}
	@Override
	public void run() {
			pizza.orderPizza(5);
		}
	}


