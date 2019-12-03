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
import fr.utbm.priv_form.entity.Client;
import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageClient {
   private static SessionFactory factory; 
   
   /* Method to CREATE an employee in the database */
   public Integer addClient(String lastname, String firstname, String address, String phone, String email){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer clientID = null;
      
      try {
         tx = session.beginTransaction();
         Client client = new Client();
         client.setFirstname(lastname);
         client.setLastname(firstname);
         client.setAddress(address);
         client.setPhone(phone);
         client.setEmail(email);
         clientID = (Integer) session.save(client); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return clientID;
   }
   
   /* Method to  READ all the employees */
   public void listClient( ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List clients = session.createQuery("FROM Client").list(); 
         for (Iterator iterator = clients.iterator(); iterator.hasNext();){
            Client client = (Client) iterator.next();
            System.out.println(client.toString());
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
   public void updateClient(Integer ClientID, String address, String email, String lastname, String firstname, String phone ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Client client = (Client)session.get(Client.class, ClientID); 
         client.setFirstname(lastname);
         client.setLastname(firstname);
         client.setAddress(address);
         client.setPhone(phone);
         client.setEmail(email);
         session.update(client); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to DELETE an employee from the records */
   public void deleteClient(Integer ClientID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Client client = (Client)session.get(Client.class, ClientID); 
         session.delete(client); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}

