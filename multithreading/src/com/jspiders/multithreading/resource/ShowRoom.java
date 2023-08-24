package com.jspiders.multithreading.resource;

public class ShowRoom {
	private int availableBikes;
	
	public synchronized void order(int orderedBikes) {
		System.out.println(orderedBikes+" are odered..");
		if (orderedBikes>availableBikes) {
			System.out.println(orderedBikes+" are not available please wait..");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(orderedBikes+" are now delivered");
			availableBikes-=orderedBikes;
			System.out.println("total available bikes are "+availableBikes);
			
		}
		
	}
	public synchronized void add(int addBike) {
		System.out.println("your are added "+addBike);
		availableBikes+=addBike;
		System.out.println("total availble biked are "+availableBikes);
		notifyAll();
	}

}
