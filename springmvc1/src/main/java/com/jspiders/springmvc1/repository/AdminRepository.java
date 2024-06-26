package com.jspiders.springmvc1.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.springmvc1.pojo.AdminPOJO;

@Repository
public class AdminRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("mvc");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public AdminPOJO getAdmin() {
		openConnection();
		transaction.begin();
		
		String jpql = "from AdminPOJO";
		query = manager.createQuery(jpql);
		List<AdminPOJO> admins = query.getResultList();
		
		if (admins.isEmpty() == false) {
			for (AdminPOJO pojo : admins) {
				transaction.commit();
				closeConnection();
				return pojo;
			}
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}

	public AdminPOJO createAccount(String username, String email,long contact, String city, String password, String confirmPassword) {
		openConnection();
		transaction.begin();
		
		AdminPOJO pojo = new AdminPOJO();
		pojo.setUsername(username);
		pojo.setEmail(email);
		pojo.setContact(contact);
		pojo.setCity(city);
		pojo.setPassword(password);
		pojo.setConfirmPassword(confirmPassword);
		
		manager.persist(pojo);
		
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public AdminPOJO login(String username, String password) {
		openConnection();
		transaction.begin();
		
		String jpql = "from AdminPOJO "
					+ "where username = '" + username + "' "
					+ "and password = '" + password + "'";
		
		query = manager.createQuery(jpql);
		
		List<AdminPOJO> admins = query.getResultList();
		if (admins.isEmpty() == false) {
			for (AdminPOJO pojo : admins) {
				transaction.commit();
				closeConnection();
				System.out.println(pojo);
				return pojo;
			}
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}

}