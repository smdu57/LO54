<%-- 
    Document   : Client
    Created on : Dec 8, 2019, 3:54:37 PM
    Author     : simon
--%>

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
      <form  method="get" action="">
      <label  for="ClientId">Nom : </label>
		<div>
			<input id="ClientId" name="ClientId" class="element text medium" type="text" maxlength="255" value=""/> 
                        <input id="saveForm" type="submit" name="submit" value="Submit" />
		</div>
      </form>
      <h1>Liste des clients</h1> 
      <table align="center"> 
         <tr> 
          <th><b>Nom</b></th> 
          <th><b>Prénom</b></th> 
          <th><b>Adresse</b></th>
          <th><b>N° de Téléphone</b></th>
          <th><b>Email</b></th>
         </tr> 
        <%ArrayList<Client> std =  
            (ArrayList<Client>)request.getAttribute("data"); 
        for(Client s:std){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.getFirstname()%></td> 
                <td><%=s.getLastname()%></td> 
                <td><%=s.getAddress()%></td>
                <td><%=s.getPhone()%></td>
                <td><%=s.getEmail()%></td>
            </tr> 
            <%}%> 
        </table>  
        <hr/> 
        <input text="Nouveau Client" type="button" onclick="<%this.getServletContext().getRequestDispatcher( "/ClientNew.jsp" ).forward(request, response );%>"/>
    </body> 
</html> 
