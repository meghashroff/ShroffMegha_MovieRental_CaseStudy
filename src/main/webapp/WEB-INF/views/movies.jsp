 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="org.meghashroff.movierentals.models.Movie" %>

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
    <div id="main_container" >
        <img src="images/movieBackground1.jpg" id="bgMovieList">
        <header>
        <%@ include file="navigation.html" %>
        <!-- <div id="homePage"><a href="${pageContext.request.contextPath}/" >Home</a></div>-->
    	</header>
        <form>
        <div id="genre_container">
        <label for="movieList">Genre</label>
        <br>
            <select name ="movieGenre" id="genre" onchange="filterByGenre(this.value)">
                    <option value="all" selected>All</option>
                    <option value="Family">Family</option>
                    <option value="Action">Action</option>
                    <option value="Animation">Animation</option>
            </select> 
        </div>
        <br>
        <div>
            <table name="movieList" id="movieList">
            <thead>
                <tr class="header">
                    <!-- <th></th>  -->
                    <th >Movie</th>
                    <th>Name</th>
                    <th>Genre</th>
                    <th>Release</th>
                </tr>
            </thead>   
                 <tbody id="tbody">
    	<%
    	Iterable<Movie> movies = (Iterable<Movie>)request.getAttribute("movies");
       	for(Movie movie: movies) {
       	%>
       		<tr class= <%=movie.getMovieGenre()%>>
       	<%-- 		<td><input type="checkbox" name="movieCheckBox" value=<%=movie.getMovieId() %>> </td>
       	 --%>
       	 		<td><img src=<%=movie.getMovieImagePath()%> class="smallMovieImg"></td> 
       			<td><a href="MovieInfo/<%=movie.getMovieId() %>" ><%=movie.getMovieName() %></a></td>
       			<td><%=movie.getMovieGenre()%></td>
       			<td><%=movie.getMovieReleaseYear()%></td>
       		</tr><% 	
       	}
    	%>       
    	
       	</tbody>
        </table> 
         
        
        </div>
        
        </form>
        <!-- <form name="submitMoviesForRent" action="selMovieList" method="get">
        	<input type="submit" name="submitSelectedMovies" value="Rent Movies"/>
       	</form> -->
        <br>
        <!-- <footer>
             <a href= "${pageContext.request.contextPath}/">Home</a>
        </footer> -->
    </div>
</body>
</html>