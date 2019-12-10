/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.priv_server.service;

import fr.utbm.priv_form.entity.Course;
import fr.utbm.priv_form.entity.Location;
import fr.utbm.priv_form.repository.ManageCourse;
import fr.utbm.priv_form.repository.ManageCourseSession;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author simon
 */
@WebServlet(name="CourseSessionServlet", urlPatterns={"/CourseSession"})
public class CourseSessionServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        try { 
            request.setAttribute("data", ManageCourseSession.listCourseSessionFilter(parseInt(request.getParameter("location")), new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("startDate")), request.getParameter("mot")));
            request.setAttribute("location", ManageCourseSession.listLocation());
            this.getServletContext().getRequestDispatcher( "/CourseSession.jsp" ).forward( request, response );
        } catch (ParseException ex) {
            Logger.getLogger(CourseSessionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            ManageCourseSession.addCourseSession(new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("startDate")), new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("endDate")), parseInt(request.getParameter("max")), new Course(request.getParameter("courseId")), new Location(parseInt(request.getParameter("location"))));
        } catch (ParseException ex) {
            Logger.getLogger(CourseSessionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
