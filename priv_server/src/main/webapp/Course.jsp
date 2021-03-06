<%-- 
    Document   : Course
    Created on : Dec 8, 2019, 3:54:37 PM
    Author     : simon
--%>

<%@page import="fr.utbm.priv_form.entity.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.utbm.priv_form.entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
  <head> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
   <title>Liste des clients</title> 
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  </head> 
  <body> 
      <h1>Liste des courses</h1> 
      <table align="center"> 
         <tr> 
          <th><b>Id</b></th> 
          <th><b>Nom</b></th>
         </tr> 
        <%ArrayList<Course> std =  
            (ArrayList<Course>)request.getAttribute("data"); 
        for(Course s:std){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.getCode()%></td> 
                <td><%=s.getTitle()%></td>
            </tr> 
            <%}%> 
        </table>  
        <hr/> 
    </body> 
</html> 

