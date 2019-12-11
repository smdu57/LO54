
import fr.utbm.priv_form.entity.Client;
import fr.utbm.priv_form.entity.Course;
import fr.utbm.priv_form.entity.CourseSession;
import fr.utbm.priv_form.entity.Location;
import fr.utbm.priv_form.repository.ManageClient;
import fr.utbm.priv_form.repository.ManageCourse;
import fr.utbm.priv_form.repository.ManageCourseSession;
import fr.utbm.priv_form.repository.ManageLocation;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simon
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Client c = new Client(0,"p","p","p","0614253647");
        
        ManageClient.addClient(c.getFirstname(), c.getLastname(), c.getAddress(), c.getPhone(), c.getEmail());
        System.out.println("ajout");
        List<Client> l =ManageClient.listClient();
        System.out.println(l);*/
        // TODO code application logic here
        Location l = new Location(1,"belfort");
        System.out.println(l);
        ManageLocation.addLocation("belfort");
        List<Location> t = ManageLocation.listLocation();
        System.out.println(t);
        Course c = new Course("LO54","JEE");
        
        ManageCourse.addCourse(c.getCode(), c.getTitle());
        
        System.out.println(ManageCourse.listCourses());
        
        CourseSession cs = new CourseSession(1, new Date("11/12/2019"), new Date("18/12/2019"), 10, c, l);
        
        ManageCourseSession.addCourseSession(cs.getStartDate(), cs.getEndDate(), cs.getMax(), c, l);
        
        System.out.println(ManageCourseSession.listCourseSession());
        
        
        
    }
    
}
