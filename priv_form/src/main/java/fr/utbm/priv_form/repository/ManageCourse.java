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
import fr.utbm.priv_form.tools.HibernateUtil;
import java.util.ArrayList;
import java.util.List; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public class ManageCourse {
   private static final SessionFactory factory = HibernateUtil.getSessionFactory(); 
   
   /* Method to CREATE an employee in the database */
   public static String addCourse(String code, String title){
      Session session = factory.openSession();
      Transaction tx = null;
      String courseID = null;
      
      try {
         tx = session.beginTransaction();
         Course course = new Course();
         course.setCode(code);
         course.setTitle(title);
         courseID = session.save(course).toString(); 
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
   public static List listCourses( ){
      Session session = factory.openSession();
      List courses = new ArrayList();
      try {
         courses = session.createQuery("FROM Course").list(); 
      } catch (HibernateException e) {
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return courses;
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

