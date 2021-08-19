 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="org.meghashroff.movierentals.models.Movie" %>
<%@ page import ="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rented List</title>
</head>
<body>
<h1>Movie List</h1>
	 <div>
	<a href="${pageContext.request.contextPath}/navToMoviesPage">Back</a></div>
    
	 <div>
    <%@ include file="navigation.html" %>
	</div>
	<div>
	

	 <% 
		Movie selectedMovie= (Movie)request.getAttribute("movieInformation");
	 //	List<Movie> moviesList = (List)session.getAttribute("selMovieList");
		//moviesList.add(selectedMovie);
		if(selectedMovie!=null){
	 %>
	<fieldset>
		<legend>Movie List</legend>
		 <table>
	 		<thead>
	 			<tr>
	 				<th> Movie Name </th>
	 				<th> </th>
				</tr>
			</thead>
	 		<tbody>
	 			<tr>
	 				<td> <%=selectedMovie.getMovieName() %> </td>
	 				<td> <a href="remove/<%=selectedMovie.getMovieId()%>">Remove</a></td>
	 			</tr>
	 		</tbody>
		 </table>
	</fieldset>
	</div>
	<form action="confirmPayment" method="get" >
	<input type="hidden" name="movieSel" value=<%=selectedMovie.getMovieId() %> /> 
	<input type="submit" value="Confirm" />
	</form>
	<%}
		else {
			out.print("No Movies selected");
			
		}
		%>
</body>
</html>