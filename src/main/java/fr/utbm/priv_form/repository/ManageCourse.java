/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.priv_form.repository;

/**
 *
 * @author simon
 */
import fr.utbm.priv_form.entity.Course;
import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageCourse {
   private static SessionFactory factory; 
   
   /* Method to CREATE an employee in the database */
   public Integer addCourse(String title){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer courseID = null;
      
      try {
         tx = session.beginTransaction();
         Course course = new Course();
         course.setTitle(title);
         courseID = (Integer) session.save(course); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return courseID;
   }
   
   /* Method to  READ all the employees */
   public void listCourse( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List courses = session.createQuery("FROM Course").list(); 
         for (Iterator iterator = courses.iterator(); iterator.hasNext();){
            Course course = (Course) iterator.next();
            System.out.println(course.toString());
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to UPDATE salary for an employee */
   public void updateCourse(Integer CourseID, String title ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Course course = (Course)session.get(Course.class, CourseID); 
         course.setTitle(title);
         session.update(course); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to DELETE an employee from the records */
   public void deleteCourse(Integer CourseID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Course course = (Course)session.get(Course.class, CourseID); 
         session.delete(course); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}

