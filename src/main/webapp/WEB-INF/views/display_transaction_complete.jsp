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

	<div class = register>
	 	<%@ include file="navigation.html" %>
	</div>
	<br>
	<div class = register>
		<a href="${pageContext.request.contextPath}/logout">Logout</a>  
	</div>
	<h1>Transaction Page</h1>
	<%  
		User user = (User)request.getAttribute("currentuser");
		if(user!=null)
		{	 
			%>
			<h3> <%-- <%=user.getFirstName()%> --%></h3>
			<div class="tranPage" >
				<img src="images/movieBackground2.jpg" id="bgMovieList">
	    	</div>
	    	<div class="tranPage" >
			<%
				RentalTransaction tran = (RentalTransaction)request.getAttribute("currentTransaction");
				Set<Movie> movieSet = tran.getMovies();
			%>
				<table>
					<tbody>
					<tr>
						<td>Date</td>
						<td><%=tran.getPaymentDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) %></td>
					</tr>
					<tr>
						<td>Selected Movies</td>
						<td>
							<ul>
								<%
								for(Movie m : movieSet)
								{
								%>
									<li><%=m.getMovieName()%></li>
								<%
								}
								%>
							</ul>
						<td>
					</tr>
					</tbody>
				</table>
			</div>
			<%
		}	
	%>
</body>
</html>