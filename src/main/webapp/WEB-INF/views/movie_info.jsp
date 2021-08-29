<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="org.meghashroff.movierentals.models.Movie" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Movie Information</title>
		<link rel="stylesheet" type="text/css" href="./../css/confirm.css">
	</head>
	<body>
		<% 
			Movie movie = (Movie)request.getAttribute("movieInformation");
	  	%>
		<img src="./../<%=movie.getMovieImagePath() %>" style="position: fixed; z-index: -1;  width: 100%;  height: 100%">
		<table>
	    	<tr>
	            <th><%=movie.getMovieName() %></th>
	        </tr>
	        <tr>
	            <td><%=movie.getMovieDescription() %></td>
	        </tr>
	    </table>
	    <br><br>
		<%--
		<div id="confirmRent">
			<section>
		        <form method="get" action="${pageContext.request.contextPath}/addMovie">
			    	<input type="hidden" name="movieToRent" value="<%=movie.getMovieId()%>"/>					
				</form>		 
			        
		        <!-- <input type="submit" value = "Back" > -->
	        	<!-- <button type="submit" name="movieToRent" value=""  >Rent</button> -->
					
	         	<!-- <button id="toRent" > -->
	         	 <a href="${pageContext.request.contextPath}/addMovie/<%=movie.getMovieId()%>"  name="movieToRent">Rent</a>
	         	<!-- </button> --><br>
	        	<br>
		       	<!-- <button ><a href="./Movies.html">Back</a></button>-->
		        <!--  <button><a href="./Home.html">Home</a></button> -->
			</section>
		</div>
		--%>	
 </body>
</html>