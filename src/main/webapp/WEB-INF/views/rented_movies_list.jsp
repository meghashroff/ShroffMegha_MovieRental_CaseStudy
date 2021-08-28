<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="org.meghashroff.movierentals.models.Movie" %>
<%@ page import ="java.util.Set, java.util.HashSet" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rented List</title>
<link rel="stylesheet" type="text/css" href="css/display_selection.css" />
<style>
@import url('https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap');


div>a {
     
    text-align: right;          
    margin-top: 10px;
    margin-left: 80%;
    text-transform: capitalize;
    font-size: large;
    color: tan;  
     padding: 20px;  
    /* justify-content: right; */
    font-family: 'Kaushan Script', cursive;
   text-decoration: none;
}

h1 {
             
    margin-top: 40px;
    text-align: center;  
    text-transform: uppercase;
    font-size: xx-large;
    /* color: white; */
    /* color: rgb(235, 62, 76);   */
    /* color:rgb(114, 84, 245) , white, red; */
    color: tan;
    padding: 20px; 
}

.pageCenter {
	margin-left: auto;
	margin-right: auto;
	max-width: 600px;
	float: none;
	border: 1px black; /* Added red border to see the div better */
}

.tranPage{
	margin-left: auto;
	margin-right: auto;
	border: 1px black; /* Added red border to see the div better */
	
	max-width: 900px; 
}

thead tr th {
 /* background-color: rgb(75, 73, 73); */
    font-size: 30px;
}
td, th {
    /* color: white; */
    font-size: 20px;
    border:  1;
    border-color:rgb(241, 235, 235);
    

    /* border-right-style: dotted; */
    border-width: 1px;
    border-bottom-style: groove;
    /* border-style: ; */
    border-color: 555;
    padding : 150,0,0,150;
    margin: 150,10,10,150;
    background-color: rgba(240, 233, 233, 0.747);
    font-family: 'Kaushan Script', cursive;
}

table{
    width: 75%;
    margin-left: 15%;
    text-align: left;
    border: 5px double black;
    border-collapse: collapse;
  }



img {
    width: 100%;
    filter: blur(2px);
    position: fixed;
    top: 0px;
    left: 0px;
    width: 100%;
    height: 100%;
    z-index: -1;
}

#rent{
    text-align: center;
	
}

.register{
    text-align: right;
}

</style>
</head>
<body>
    <div class = register>
  		<%@ include file="navigation.html" %>
	</div>
	<br>
	<div class = register>
<a href="${pageContext.request.contextPath}/logout">Logout</a>  
</div>
<h1>Movie List</h1>
<br>
	<div class="pageCenter" >
		<img src="images/movieBackground2.jpg" id="bgMovieList" style=   "width: 100%;
    filter: blur(2px);
    position: fixed;
    top: 0px;
    left: 0px;
    width: 100%;
    height: 100%;
    z-index: -1;
		">
    	<div>
			<form action="${pageContext.request.contextPath}/payment" method="post" >
	<%-- 	<form action="confirmPayment" method="get" > --%>
			<fieldset style="margin: auto;">
				<!-- <legend class="legend">Movies Selected List</legend> -->
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
 							<td> <a href="${pageContext.request.contextPath}/selMovieList/remove/<%=selectedMovie.getMovieId()%>">Remove</a></td>
 							<td> <input type="hidden" name="movieSel" value=<%=selectedMovie.getMovieId() %> /> </td>
 						</tr>
 					</tbody>
				<%
					}
			 
				%>
	
	 			</table>
			<div>	<a href="${pageContext.request.contextPath}/navToMoviesPage" 
			onclick="return confirm('This will clear all your selections. Are you sure?' )" >Back</a></div>
	
			 </fieldset>
			<br><br>
			<div id=rent>	<%-- <input type="hidden" name="movieSel" value=<%=selectedMovie.getMovieId() %> />  --%>
					<input type="submit" value="Confirm" />
			<%
			} 
					else {
						out.println("No movies selected. ");
					} 
			%>
			</div>
			
			
		</form>	
	</div>
	</div>
		
</body>
</html>