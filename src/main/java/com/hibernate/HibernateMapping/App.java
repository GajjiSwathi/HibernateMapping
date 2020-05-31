package com.hibernate.HibernateMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Laptop laptop =new Laptop();
        laptop.setId(101);
        laptop.setLname("dell");
        
        Student student = new Student();
        student.setRollno(1);
        student.setName("swathi");
        student.setMarks(50);
        //student.setLaptop(laptop);
        student.getLaptop().add(laptop);
        
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        ServiceRegistry service= new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory= configuration.buildSessionFactory(service);
        Session session = sessionFactory.openSession();
        Transaction tx= session.beginTransaction();
        session.save(laptop);
        session.save(student);
        session.getTransaction().commit();
        
        
        
        
   
}
}