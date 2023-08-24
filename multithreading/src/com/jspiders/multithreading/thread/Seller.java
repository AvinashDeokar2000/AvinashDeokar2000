package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.ShowRoom;

public class Seller extends Thread {
	 ShowRoom showRoom;

	public Seller(ShowRoom showRoom) {
		this.showRoom = showRoom ;
	}
	
	@Override
	public void run() {
		showRoom.add(5);
	}
	 
}
