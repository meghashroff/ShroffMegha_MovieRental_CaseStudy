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
		<div class="tranPage" >
			<img src="images/movieBackground1.jpg" id="bgMovieList">
		</div>
		<%  
		User user = (User)request.getAttribute("currentUser");
		if(user!=null)
		{
			%>
			<h1 style="text-align: center"> <%=user.getFirstName()%>'s Rental History</h1>
			<table id="transHistory">
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
		<br>
		<a href ="${pageContext.request.contextPath}/changePassword" class="optionLinks">Change Password</a>
		<a href="${pageContext.request.contextPath}/deleteAccount" class="optionLinks">Delete Account</a>  		
	</body>
</html>