package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

public class CharStreamWrite {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\WEJA2\\filehandling\\Demo.text");
		
		if(file.exists()) {
			FileWriter fileWriter=new FileWriter(file);
			
			fileWriter.write("Data From the java Program");
			System.out.println("Data written to the file");
			fileWriter.close();
		}
		else {
			file.createNewFile();
			System.out.println("File is created...");
			
			FileWriter fileWriter=new FileWriter(file);
			fileWriter.write("Data from the java Program");
			fileWriter.close();
		}
	}

}
