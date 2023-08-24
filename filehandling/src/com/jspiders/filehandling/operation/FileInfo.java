package com.jspiders.filehandling.operation;

import java.io.File;


public class FileInfo {
	public static void main(String[] args) {
		File file=new File("D:\\WEJA2\\filehandling\\Demo.text1");
		
		System.out.println(file.getName());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.length());
		
		if(file.canRead()) {
			System.out.println("File is Readable");
		}
		else {
			System.out.println("File is not readable");
		}
		if(file.canWrite()) {
			System.out.println("File is Writeble");
		}
		else
		{
			System.out.println("File is Not writeble");
		}
		if(file.canExecute()) {
			System.out.println("File is executable");
		}
		else
		{
			System.out.println("File is Not Executable");
		}
	}

}
