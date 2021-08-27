<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.meghashroff.movierentals.models.*, java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.List, java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Information</title>
<link rel = "stylesheet" type="text/css" href="css/tran_complete.css">

</head>
<body>
<div class="register">
<a href="${pageContext.request.contextPath}/">Home</a>
</div>
<br>
<div class="register">
	  	<a href="${pageContext.request.contextPath}/logout">Logout</a>  
</div>

<h1>Account Information</h1>
<div class="tranPage" >
	<img src="images/movieBackground1.jpg" id="bgMovieList">
</div>
<%  
	User user = (User)request.getAttribute("currentUser");
	if(user!=null)
	{		%>
			
	
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
					<ul>
						<%
				
						Set<Movie> movieSet = rt.getMovies();
						for(Movie m : movieSet)
						{
						%>
							<li><%=m.getMovieName()%></li>
						<%
						}
						%>
						</ul>
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


	  	<a href ="${pageContext.request.contextPath}/changePassword">Change Password</a>
	<a href="${pageContext.request.contextPath}/deleteAccount">Delete Account</a>  		
	
</body>
</html>