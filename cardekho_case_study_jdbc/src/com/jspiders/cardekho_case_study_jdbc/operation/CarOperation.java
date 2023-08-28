package com.jspiders.cardekho_case_study_jdbc.operation;

import com.jspiders.cardekho_case_study_jdbc.entity.Car;
import com.mysql.cj.protocol.x.ContinuousOutputStream;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class CarOperation {
	private static Connection connection;
	private static PreparedStatement preperedStatement;
	private static ResultSet resultSet;
	private static int result;
	private static FileInputStream file;
	private static Properties properties=new Properties();
	private static String filePath="D:\\WEJA2\\jdbc\\resources\\db_info.properties";
	private static String query;
	
	
	
	
	private static void openConnection() {
		try {
			
			file= new FileInputStream(filePath);
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath"));
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void closeConnection() {
		try {
			if(connection != null) {
				connection.close();
			}
			if(preperedStatement != null) {
				preperedStatement.close();
			}
			if(resultSet != null) {
				resultSet.close();
			}
			if (file != null) {
				file.close();
			}
			if(result != 0) {
				result =0;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addCarDetails() {
		//1. MYSQL query to create a table
		try {
			
			openConnection();
			
			Scanner sc =new Scanner(System.in);
			System.out.println("How many record you want to insert");
			int howMany=sc.nextInt();
			
			
		    for(int i=1; i<=howMany;i++) {
		    	
			query= "insert into car_details value(?,?,?,?,?,?)";
			preperedStatement=connection.prepareStatement(query);
			System.out.println("Enter Car_id:");
			int car_id=sc.nextInt();
			System.out.println("Enter Name:");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter Model:");
			String model = sc.nextLine();
			System.out.println("Enter Brand:");
			String brand = sc.nextLine();
			System.out.println("Enter Fuel_Type");
			String fuel_type = sc.nextLine();
			System.out.println("Enter Price");
			int price = sc.nextInt();
			
			
			preperedStatement.setInt(1,car_id);
			preperedStatement.setString(2,name);
			preperedStatement.setString(3,model);
			preperedStatement.setString(4,brand);
			preperedStatement.setString(5,fuel_type);
			preperedStatement.setInt(6, price);
			
			result = preperedStatement.executeUpdate();
			System.out.println(result+"row(s) affected");
			
			
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		}
	
	
	public static void removeCarDetails() {
		//2. insert record into emp
		
		try {
			getAllCarDetails(); 
			openConnection();
			Scanner sc=new Scanner(System.in);
			int car_id=sc.nextInt();
			query = "delete from car_details where car_id = ?";
			preperedStatement = connection.prepareStatement(query);
			preperedStatement.setInt(1, car_id);
			result = preperedStatement.executeUpdate();
			
			 
			System.out.println(result+"row(s) affected1");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		}
	  
	
	public static void searchByName() {
		//2. insert record into emp
		
		try {
			
			openConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter car name :");
			String name=sc.nextLine();
			query = "select *"
					+ " from car_details "
					+ "where name = ?";
			preperedStatement = connection.prepareStatement(query);
			preperedStatement.setString(1, name);
			resultSet = preperedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " | "
						+ resultSet.getString(2) + " | "
						+ resultSet.getString(3) + " | "
						+ resultSet.getString(4)+ " | "
						+ resultSet.getString(5)+ " | "
						+ resultSet.getString(6)); 
			}
			System.out.println(result+"row(s) affected1");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		}
	
	
	
	public static void searchByBrand() {
		//Display all record
		
		try {
			openConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Brand name:");
			String brand=sc.nextLine();
			query = "select *"
					+ " from car_details "
					+ "where brand =? ";
			preperedStatement = connection.prepareStatement(query);
			preperedStatement.setString(1, brand);
			resultSet = preperedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + " | "
						+ resultSet.getString(2) + " | "
						+ resultSet.getString(3) + " | "
						+ resultSet.getString(4)+ " | "
						+ resultSet.getString(5)+ " | "
						+ resultSet.getString(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		}




public static void searchByFuelType() {
	//Display all record
	
	try {
		openConnection();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Fuel_type name:");
		 String fuel_type=sc.nextLine();
		query = "select *"
				+ " from car_details "
				+ "where fuel_type = ?";
		preperedStatement = connection.prepareStatement(query);
		preperedStatement.setString(1, fuel_type);
		resultSet = preperedStatement.executeQuery();
		
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + " | "
					+ resultSet.getString(2) + " | "
					+ resultSet.getString(3) + " | "
					+ resultSet.getString(4)+ " | "
					+ resultSet.getString(5)+ " | "
					+ resultSet.getString(6));
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		closeConnection();
	}
	}
		
	public static void getAllCarDetails() {
		//Display all record
		
		try {
			openConnection();
			query = "select *"
					+ " from car_details ";
			preperedStatement = connection.prepareStatement(query);
			
			resultSet = preperedStatement.executeQuery();
			
			while (resultSet.next()) {
				Car car = new Car();
			
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setModel(resultSet.getString(3));
				car.setBrand(resultSet.getString(4));
				car.setFuel_type(resultSet.getNString(5));
				car.setPrice(resultSet.getDouble(6));
				
				System.out.println(car);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		}
		
		
		
		
		
		
	public static void editCarDetails() {
		//Display all record
		
		try {
			getAllCarDetails();
			openConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter set name which you want :");
			 String name=sc.nextLine();
		     System.out.println("Enter car_id which name you want change:");
				 int car_id=sc.nextInt();
			 
			query = "update car_details set name = ? where car_id= ?";
			preperedStatement = connection.prepareStatement(query);
			preperedStatement.setString(1, name);
			preperedStatement.setInt(2, car_id);
			result = preperedStatement.executeUpdate();
			
			System.out.println(result+"row(s) affected");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		}
			
	
	}
	
