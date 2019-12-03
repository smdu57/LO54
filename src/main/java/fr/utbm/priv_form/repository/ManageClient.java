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
import java.util.ArrayList;
import java.util.List; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;

public class ManageClient {
   private static SessionFactory factory; 
   
   /* Method to CREATE an employee in the database */
   public static Integer addClient(String lastname, String firstname, String address, String phone, String email){
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
   
   /* Method to  READ all the clients */
   public static List listClient( ){
      Session session = factory.openSession();
      List clients = new ArrayList();
      try {
         clients = session.createQuery("FROM Client").list(); 
         
      } catch (HibernateException e) { 
      } finally {
         session.close(); 
   }
      return clients;
  }
   
   public static Client getClient(int id){
      Client client = new Client();
       try{
         Session session = factory.openSession();
         client = (Client) session.load(Client.class, id); 
      } catch (HibernateException e) {
      }
   return client;
   }
   
   /* Method to UPDATE salary for an employee */
   public static void updateClient(Integer ClientID, String address, String email, String lastname, String firstname, String phone ){
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

