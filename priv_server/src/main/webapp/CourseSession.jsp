<%-- 
    Document   : CourseSession
    Created on : Dec 8, 2019, 3:54:37 PM
    Author     : simon
--%>

<%@page import="fr.utbm.priv_form.entity.CourseSession"%>
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
       <form class="navbar-form navbar-right" role="search" action="CoursesSearch" method="GET">
        <div class="form-group">
            <input type="text" name="mot" class="form-control" placeholder="Key word">
        </div>
        <ul class="nav navbar-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Advanced search <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li>
                        <div class="col-xs-12">                 		

                            <label class="label label-default">Recherche par lieux</label>
                            <br/>
                            <div class="input-group">
                                <select name="city" id="location" class="form-control">
                                    <c:forEach items="<%request.getParameter("location") %>" var="location">
                                        <option id="city" name="city" value="${location}">${location}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </li>
                    <li>.......................................................................</li>
                        <br />
                        <div class="col-xs-12">                 		
                            <label class="label label-default">Search by date</label>
                            <br/>
                            <div class="input-group">
                                <input type="date" id="date" name="date" class="form-control" placeholder="date" autocomplete="off">
                            </div>     
                        </div>
                </ul>
            </li>
        </ul>
        <button type="submit" class="btn btn-default">Rechercher</button>
       </form>
      <h1>Liste des Sessions</h1> 
      <table align="center"> 
         <tr> 
          <th><b>ID de Session</b></th> 
          <th><b>Date de début</b></th> 
          <th><b>Date de fin</b></th>
          <th><b>Max</b></th>
          <th><b>Code de la course</b></th>
          <th><b>Code de l'emplacement</b></th>
         </tr> 
        <%ArrayList<CourseSession> std =  
            (ArrayList<CourseSession>)request.getAttribute("data"); 
        for(CourseSession s:std){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.getId()%></td> 
                <td><%=s.getStartDate()%></td> 
                <td><%=s.getEndDate()%></td>
                <td><%=s.getMax()%></td>
                <td><%=s.getCourseCode()%></td>
                <td><%=s.getLocationId()%></td>
            </tr> 
            <%}%> 
        </table>  
        <hr/> 
        <input text="Nouvelle Session" type="button" onclick="<%this.getServletContext().getRequestDispatcher( "/CourseSessionNew.jsp" ).forward(request, response );%>"/>
    </body> 
</html> 
