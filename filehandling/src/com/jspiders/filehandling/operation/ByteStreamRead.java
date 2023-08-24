package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;


public class ByteStreamRead {
	public static void main(String[] args) throws IOException {
		File file=new File("D:\\WEJA2\\filehandling\\Demo.text");
		
		if(file.exists()) {
			FileInputStream fileInputStream=new FileInputStream(file);
			System.out.println(fileInputStream.read());
			System.out.println("Data is Feched from the file ");
			fileInputStream.close();
		}
		else {
			System.out.println("File does not exists");
		}
	}

}
