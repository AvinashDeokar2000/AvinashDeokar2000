package com.jspiders.multithreading.main;

import java.nio.channels.SelectableChannel;

import com.jspiders.multithreading.resource.ShowRoom;
import com.jspiders.multithreading.thread.Avi;
import com.jspiders.multithreading.thread.Seller;

public class ShowRoomMain1 {
	 public static void main(String[] args) {
		
		 ShowRoom showRoom = new ShowRoom();
		 
		 Avi avi = new Avi(showRoom);
		 Seller seller= new Seller(showRoom);
		 
		 avi.start();
		 seller.start();
		 
		  		
	}
}
