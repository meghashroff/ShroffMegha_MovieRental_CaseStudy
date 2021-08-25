<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.meghashroff.movierentals.models.*, java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Set" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction Page</title>
<link rel = "stylesheet" type="text/css" href="css/tran_complete.css">
    
</head>
<body>
<div class="navLinks">
	<a href="${pageContext.request.contextPath}/">Home</a><span>|</span><a href="${pageContext.request.contextPath}/logout">Logout</a>  
</div>

<h1>Transaction Page</h1>

<%  
User user = (User)request.getAttribute("currentuser");
if(user!=null)
	{	 
		%>
		<h3> <%=user.getFirstName()%></h3>
		<%
		RentalTransaction tran = (RentalTransaction)request.getAttribute("currentTransaction");
		Set<Movie> movieSet = tran.getMovies();
		%>
		
		<table>
		<thead>
			<tr>
			<th>Date</th>
			<th>Selected Movies</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=tran.getPaymentDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) %></td>
				<td>
					<table>
					<%
					for(Movie m : movieSet)
					{
					%>
						<tr> <td><%=m.getMovieName()%></td></tr>
					<%
					}
					%>
					</table>
				</td>
			</tr>
		</tbody>
	</table>
	<%
	}	
	%>
</body>
</html>