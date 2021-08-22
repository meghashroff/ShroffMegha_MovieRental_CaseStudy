<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.meghashroff.movierentals.models.*, java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.List, java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Information</title>
</head>
<body>

<div><a href="${pageContext.request.contextPath}/">Home</a>
	<span>|</span>
	  	<a href="${pageContext.request.contextPath}/logout">Logout</a>  
</div>

<h1>Account Information</h1>


<%   if(session.getAttribute("currentUser")!=null)
	{	 
		User user =  (User)session.getAttribute("currentUser");
		%>
			<h3 style="text-align: center"> <%=user.getFirstName()%></h3>
			<table>
				<thead>
					<tr>
						<th>Date</th>
						<th>Selected Movies</th>
					</tr>
				</thead>
		
		<%
			List<RentalTransaction> tranList = user.getRentalTrans();
			for(RentalTransaction rt : tranList)
			{
		%>		
			<tbody>
				<tr>
					<td><%=rt.getPaymentDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) %></td>
					<td>
					<table>
						<%
				
						Set<Movie> movieSet = rt.getMovies();
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
			<%
			} 
			%>
	</table>
	<%
		
	}
	%>


	
	<a href="${pageContext.request.contextPath}/deleteAccount">Delete Account</a>  		
	
</body>
</html>