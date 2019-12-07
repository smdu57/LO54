/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.priv_form.service;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.utbm.priv_form.repository.ManageClient;
import java.io.IOException;
import static java.lang.Integer.parseInt;
/**
 *
 * @author simon
 */
@WebServlet(name="ClientServlet", urlPatterns={"/Client"})
public class ClientServlet extends HttpServlet{
    
    private static final long SerialVersionUID = 245869137506L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        if (request.getParameter("ClientId") != null){
            response.getWriter().println(ManageClient.getClient(parseInt(request.getParameter("ClientId"))));                   
        }
        else{
            response.getWriter().println(ManageClient.listClient());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        ManageClient.addClient(request.getParameter("lastname"), request.getParameter("firstname"), request.getParameter("address"), request.getParameter("phone"), request.getParameter("email"));
        response.getWriter().println("Done");
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        ManageClient.updateClient(parseInt(request.getParameter("ClientId")),request.getParameter("lastname"), request.getParameter("firstname"), request.getParameter("address"), request.getParameter("phone"), request.getParameter("email"));
        response.getWriter().println("Done");
    }
}
