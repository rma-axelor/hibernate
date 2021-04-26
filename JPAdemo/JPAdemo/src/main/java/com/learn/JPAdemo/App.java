package com.learn.JPAdemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@PersistenceContext
public class App 
{
   	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
	
    private static EntityManager em = emf.createEntityManager();
	
	private static void save(student stud)
	{
		em.getTransaction().begin();
		em.persist(stud);
		em.getTransaction().commit();
	}
	
	private static void update(student stud)
	{
		em.getTransaction().begin();
		em.merge(stud);
		em.getTransaction().commit();
	}
	
	private static void delete(student stud)
	{
		em.remove(stud);
	}
    
	private static student get_stud(int rollno)
	{
		student stud = em.find(student.class, rollno);
		return stud;
	}
	
    public static void main( String[] args )
    {
    	student stud = new student();
    	stud.setRollno(101010);
    	stud.setName("navya");
    	stud.setMarks(90);
 
    	//save object
    	save(stud);
    	
    	//find object
    	student stud1 = get_stud(101010);
    	System.out.println("stud1 = "+stud1);
    	
    	//upate
    	stud.setRollno(101111);
    	update(stud);
    	student stud2 = get_stud(101111);
    	System.out.println("stud = "+stud2);
    	
    	//delete
    	delete(stud);
    	
    }
}
