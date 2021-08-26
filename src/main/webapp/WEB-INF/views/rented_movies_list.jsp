 <%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="org.meghashroff.movierentals.models.Movie" %>
<%@ page import ="java.util.Set, java.util.HashSet" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rented List</title>
<link rel="stylesheet" type="text/css" href="css/movieList.css" />
</head>
<body>
	     <div class = register>
    		<%@ include file="navigation.html" %>
	<a href="${pageContext.request.contextPath}/navToMoviesPage" onclick="return confirm('This will clear all your selections. Are you sure?' )">Back</a></div>
	
		</div>
	
<!-- <h1>Movie List</h1> -->
	<div id="movielist_container" >
    	<div>
		<form action="${pageContext.request.contextPath}/payment" method="post" >
	
	<%-- 	<form action="confirmPayment" method="get" > --%>
	
			<fieldset>
				<legend class="legend">Movies Selected List</legend>
				<br>
				<table>
			 	 	<% 
						Set<Movie> movies = (HashSet<Movie>)session.getAttribute("selectedMovies");
					if(!movies.isEmpty()){	
			 	 	for(Movie selectedMovie: movies){
					%> 
					<tbody>
 						<tr>
 							<td> <%=selectedMovie.getMovieName() %> </td>
 							<td> <a href="${pageContext.request.contextPath}/remove/<%=selectedMovie.getMovieId()%>">Remove</a></td>
 							<td> <input type="hidden" name="movieSel" value=<%=selectedMovie.getMovieId() %> /> </td>
 						</tr>
 					</tbody>
				<%
					}
			 
				%>
	 			</table>
			</fieldset>
			<br><br>
			<div id=rent>	<%-- <input type="hidden" name="movieSel" value=<%=selectedMovie.getMovieId() %> />  --%>
			<input type="submit" value="Confirm" />
			<%
			} 
					else {
						out.println("No movies selected. ");
					} %>
			</div>
			
			
		</form>	
	</div>
		
</body>
</html>