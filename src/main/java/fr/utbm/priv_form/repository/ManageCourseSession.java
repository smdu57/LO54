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
import fr.utbm.priv_form.entity.CourseSession;
import fr.utbm.priv_form.entity.Location;
import java.util.Date;
import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageCourseSession {
   private static SessionFactory factory; 
   
   /* Method to CREATE an employee in the database */
   public Integer addCourseSession(Date start_date, Date end_date, Integer max, Course courseCode, Location locationId){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer courseSessionID = null;
      
      try {
         tx = session.beginTransaction();
         CourseSession courseSession = new CourseSession();
         courseSession.setStartDate(start_date);
         courseSession.setEndDate(end_date);
         courseSession.setMax(max);
         courseSession.setCourseCode(courseCode);
         courseSession.setLocationId(locationId);
         courseSessionID = (Integer) session.save(courseSession); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return courseSessionID;
   }
   
   /* Method to  READ all the employees */
   public void listCourseSession( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List courseSessions = session.createQuery("FROM CourseSession").list(); 
         for (Iterator iterator = courseSessions.iterator(); iterator.hasNext();){
            CourseSession courseSession = (CourseSession) iterator.next();
            System.out.println(courseSession.toString());
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
   public void updateCourseSession(Integer CourseSessionID, Date start_date, Date end_date, Integer max, Course courseCode, Location locationId ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         CourseSession courseSession = (CourseSession)session.get(CourseSession.class, CourseSessionID); 
         courseSession.setStartDate(start_date);
         courseSession.setEndDate(end_date);
         courseSession.setMax(max);
         courseSession.setCourseCode(courseCode);
         courseSession.setLocationId(locationId);
         session.update(courseSession); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to DELETE an employee from the records */
   public void deleteCourseSession(Integer CourseSessionID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         CourseSession courseSession = (CourseSession)session.get(CourseSession.class, CourseSessionID); 
         session.delete(courseSession); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}

