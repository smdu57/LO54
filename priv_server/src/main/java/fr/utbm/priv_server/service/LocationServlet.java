/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.priv_server.service;

import fr.utbm.priv_form.repository.ManageLocation;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author simon
 */
@WebServlet(name="LocationServlet", urlPatterns={"/Location"})
public class LocationServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.getWriter().println(ManageLocation.listLocation());
    }
}
