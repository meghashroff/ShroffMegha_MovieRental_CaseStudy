 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="org.meghashroff.movierentals.models.Movie" %>
<%@ page import ="org.meghashroff.movierentals.models.User" %>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Movies</title>
	    <script src="js/movieList.js">
	    </script>
	    <link rel="stylesheet" type="text/css" href="css/movieList.css" />
	</head>
	<body>
		<div class = register>
			<%@ include file="navigation.html" %>
		   	<br>
		   	<%@ include file="login_navigation.jsp" %>
		</div>
		<div id="main_container" >
			<img src="images/movieBackground1.jpg" id="bgMovieList">
		    <br>
			<form name="selGenre" action="selGenre" method="post"> 
		    	<div id="genre_container">
					<label for="movieList">Genre</label>
		        	<br>
		            <select name ="movieGenre" id="genre" >
		            	<option value="All">All</option>
	                    <option value="Family">Family</option>
	                    <option value="Action">Action</option>
	                    <option value="Animation">Animation</option>
		            </select> 
					<input type="submit" value="GO">
		        </div>
			</form> 
		    <br>
		    <form name="submitMoviesForRent" action="selMovieList" method="post"  onsubmit= "return movieSel()" >
		    	<div><h4></h4></div>
		        <div>
		        <%
			    	Iterable<Movie> movies = (Iterable<Movie>)request.getAttribute("movies");
			       	if(movies!=null)
			       	{
			        	%>
			            <table name="movieList" id="movieList">
				            <thead>
				                <tr class="header">
				                    <th><!-- <input type="checkbox" onClick="toggle(this)"> --></th>
				                    <th >Movie</th>
				                    <th>Name</th>
				                    <th>Genre</th>
				                    <th>Release</th>
				                </tr>
				            </thead>   
							<tbody id="tbody">
			        		<%	
			        			for(Movie movie: movies) {
			       				%>
			       				<tr class= <%=movie.getMovieGenre()%>>
				       	 			<td><input type="checkbox" name="selectedMovies" value=<%=movie.getMovieId()%> id="checkedMovies" /> </td>
				       	 			<td><img src=<%=movie.getMovieImagePath()%> class="smallMovieImg"></td> 
				       				<td><a href="MovieInfo/<%=movie.getMovieId() %>" target="_blank"><%=movie.getMovieName() %></a></td>
				       				<td><%=movie.getMovieGenre()%></td>
				       				<td><%=movie.getMovieReleaseYear()%></td>
				       			</tr>
				       			<% 	
			       				}
			    			%>       
				    		</tbody>
						</table> 
		         	</div>
		        	<br>
		      	<div id="rent">
		        	<input type="submit" name="submitSelectedMovies" value="Rent Movies" />
		       	</div>
		       	<%
		       	} 
			%>
		    </form>
		    <br>
		</div>
	</body>
</html>