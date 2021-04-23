package com.learn;



import java.util.ArrayList;
import java.util.List;

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
	public static void main(String[] args)
	{
		
	  Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
	  
	  ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	  
	  SessionFactory sf = con.buildSessionFactory(reg);
	  
	  Session session = sf.openSession();
	  
	  Transaction tx = session.beginTransaction();
	
//	  Random r = new Random();
//	
//	  for( int i = 1 ; i <= 50 ; i++ )
//	  {
//		  Student stud = new Student();
//		  stud.setRollno(i);
//		  stud.setName("Student"+i);
//		  stud.setMarks(r.nextInt(101));
//		  session.save(stud);
//	  }
//	  
//	  
//	  tx.commit();
	  
	  Student stud1 = new Student();
	  stud1.setRollno(1);
	  stud1.setName("Student1");
	  stud1.setMarks(80);
	  
	  session.update(stud1);
	  tx.commit();
	  
	  Query q1 = session.createQuery("from Student");
	  
	  List<Student>list = q1.list();
	  
	  for( Student it : list)
	  {
		  System.out.println(it);
	  }
	   
	}
}
