package com.jspiders.multithreading.resource;

public class Pizza2 {
	private int availablePizza;
	
	public synchronized void orderPizza(int orderPizza) {
		System.out.println("Trying to order "+orderPizza +"Pizza");
		
		if(availablePizza < orderPizza) {
			System.out.println(orderPizza+"Pizza not available "+"please wait...!!");
			
			try {
				this.wait();
				
			}catch(InterruptedException e){
				e.printStackTrace();
				
			}
		}
		availablePizza -=orderPizza;
		System.out.println(orderPizza +"Pizza deliverd");
		System.out.println(availablePizza +"Pizza available ");
	}
	public synchronized void bakePizza(int bakedPizza) {
		System.out.println("Baking "+bakedPizza+"Pizza");
		availablePizza += bakedPizza;
		System.out.println(bakedPizza+"Pizza baked ");
		System.err.println(availablePizza+"Pizza available");
		
		this.notify();
	}

}
