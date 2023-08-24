package com.jspiders.filehandling.operation;

import java.io.File;

public class DeleteFile {
public static void main(String[] args) {
	File file=new File("D:\\\\WEJA2\\\\filehandling\\\\Demo.text");
	
	if (file.exists()) {
		
		file.delete();
		System.out.println("File is Deleted ");
		
	}
	else {
		System.out.println("File not exists");
	}
	
}
}
