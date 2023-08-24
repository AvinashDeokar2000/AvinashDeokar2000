package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.main.ShowRoomMain1;
import com.jspiders.multithreading.resource.ShowRoom;

public class Avi extends Thread {
	
	 ShowRoom showroom;

	 public Avi(ShowRoom showroom) {
			this.showroom = showroom;
		}
	

	@Override
	public void run() {
		showroom.order(5);
	}

}