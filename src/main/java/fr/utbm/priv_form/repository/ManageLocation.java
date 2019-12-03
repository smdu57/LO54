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
import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageLocation {
   private static SessionFactory factory; 
   
   /* Method to CREATE an employee in the database */
   public Integer addLocation(String city){
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
   public void listLocation( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List locations = session.createQuery("FROM Location").list(); 
         for (Iterator iterator = locations.iterator(); iterator.hasNext();){
            Location location = (Location) iterator.next();
            System.out.println(location.toString());
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

