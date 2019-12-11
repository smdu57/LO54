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
import fr.utbm.priv_form.entity.Location;
import fr.utbm.priv_form.tools.HibernateUtil;
import java.util.ArrayList;
import java.util.List; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public class ManageLocation {
   private static final SessionFactory factory = HibernateUtil.getSessionFactory(); 
   
   /* Method to CREATE an employee in the database */
   public static Integer addLocation(String city){
            Session session = factory.openSession();
      Transaction tx = null;
      Integer locationID = null;

      try {
         tx = session.beginTransaction();
         Location location = new Location();
         location.setCity(city);
         locationID = (Integer) session.save(location); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return locationID;
   }
   
   /* Method to  READ all the employees */
   public static List listLocation( ){
      Session session = factory.openSession();
      List locations = new ArrayList();
      System.out.println("debut");
      try {
          System.out.println("try");
         locations = session.createQuery("FROM Location").list(); 
      } catch (HibernateException e) {
          System.out.println("catch");
         e.printStackTrace(); 
      } finally {
          System.out.println("finally");
         session.close(); 
      }
      return locations;
   }
   
   
   /* Method to UPDATE salary for an employee */
   public void updateLocation(Integer LocationID, String city ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Location location = (Location)session.get(Location.class, LocationID); 
         location.setCity(city);
         session.update(location); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to DELETE an employee from the records */
   public void deleteLocation(Integer LocationID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Location location = (Location)session.get(Location.class, LocationID); 
         session.delete(location); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}

