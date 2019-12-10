/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.priv_server.service;

import fr.utbm.priv_form.repository.ManageClient;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
/**
 *
 * @author simon
 */
@WebServlet(name="ClientServlet", urlPatterns={"/Client"})
public class ClientServlet extends HttpServlet{
    
    private static final long SerialVersionUID = 245869137506L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        if (request.getParameter("ClientId") != null){
            request.setAttribute("data",ManageClient.getClient(parseInt(request.getParameter("ClientId"))));
            this.getServletContext().getRequestDispatcher( "/Client.jsp" ).forward( request, response );
        }
        else{
            /*response.getWriter().println(ManageClient.listClient());*/
            request.setAttribute("data", ManageClient.listClient());
            this.getServletContext().getRequestDispatcher( "/Client.jsp" ).forward( request, response );
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String a = request.getParameter("lastname");
        String b = request.getParameter("firstname");
        String c = request.getParameter("address");
        String d = request.getParameter("email");
        String e = request.getParameter("phone");
        ManageClient.addClient(a, b, c, e, d);
        System.out.println(a+b+c+d+e);
        
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        ManageClient.updateClient(parseInt(request.getParameter("ClientId")),request.getParameter("lastname"), request.getParameter("firstname"), request.getParameter("address"), request.getParameter("phone"), request.getParameter("email"));
        response.getWriter().println("Done");
    }
}
