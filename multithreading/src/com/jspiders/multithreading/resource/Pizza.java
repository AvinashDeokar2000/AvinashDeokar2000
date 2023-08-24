package com.jspiders.multithreading.resource;

public class Pizza {
	private int availablePizza;
	public synchronized void orderPizza(int orderPizza) {
		System.out.println("Trying to order "+orderPizza+"pizza");
		if(availablePizza < orderPizza) {
			System.out.println(orderPizza +"pizza not available"+"please wait...!!");
			try {
				this.wait();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
	    }
    }
}
