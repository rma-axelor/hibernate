package com.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Main {
	
	private static Configuration con = new Configuration().configure().addAnnotatedClass(Student.class)
			.addAnnotatedClass(Laptop.class);

	private static ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

	private static SessionFactory sf = con.buildSessionFactory(reg);

	private static Session se = sf.openSession();
	
	//Save the new student
	private static void addStudent(Student stud)
	{
		Transaction tx = se.beginTransaction();
		se.save(stud);
		tx.commit();
	}
	
	private static Student getStudent(int rollno)
	{
		Transaction tx = se.beginTransaction();
		Student stud = (Student) se.get(Student.class, rollno);
		tx.commit();
		return stud;
	
	}
	
	private static void updateStudent(Student stud)
	{
		Transaction tx = se.beginTransaction();
		se.update(stud);
		tx.commit();
	}
	
	private static void removeStudent(Student stud)
	{
		Transaction tx = se.beginTransaction();
		se.delete(stud);
		tx.commit();
	}
		
	public static void main(String[] args) {
		
		Laptop lpt = new Laptop();
		lpt.setLid(12301);
		lpt.setName("Hp");
		lpt.setPrice(55000);
		
		
		Student stud = new Student();
		stud.setName("Aqub");
		stud.setRollno(1201);
		stud.setMarks(89);
		stud.getList().add(lpt);
		
		lpt.setStd(stud);
		
		//call for adding student
		addStudent(stud);
		
		//fetching student using rollno
		Student std = getStudent(1201);
		System.out.println("studnt = "+std);
		
		//updating 
		stud.setName("Kyle");
		updateStudent(stud);
		
		
		//fetching student after updating the student
		Student std1 = getStudent(1201);
		
		//deleting user
		removeStudent(stud);
		

	}
}
