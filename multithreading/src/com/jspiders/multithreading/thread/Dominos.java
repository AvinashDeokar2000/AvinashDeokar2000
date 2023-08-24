package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Pizza2;

public class Dominos extends Thread {
	private Pizza2 pizza;
	public Dominos(Pizza2 pizza) {
		this.pizza=pizza;
	}
	@Override
	public void run() {
		pizza.bakePizza(5);
	}

}
