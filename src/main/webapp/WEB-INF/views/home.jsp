<%@ page import ="org.meghashroff.movierentals.models.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel = "stylesheet" type="text/css" href="css/home.css">
	<script src="js/login.js"></script>
    <style>
       span {
            color: wheat;
        }
    </style>
</head>
<body>
	<div class="register">
   		<%@ include file="login_navigation.jsp" %>
	</div>
	<div>
   		<img style="position:fixed;top:0px;left:0px;width:100%;height:100%;z-index:-1;" name="backgroundImg" src= "images/movieBackground.jpg" alt=""/> 
	</div>
	<h1 >All the movies in one place! </h1>
    <section id="about">
    <div class="about_container">
        <p style="font-size: xx-large; text-align: center">
        	Missing out on movies? Want to watch at the comfort of your own home?
        </p>
        <p style="font-size: xx-large;">
            Movie Rentals offers offers a wide selection of movies to select from so that you can watch movies in your own home, at your own time. 
            We give you the best way to discover new content, completely free.
		</p>
	    <br />
    </div>
    <form action ="${pageContext.request.contextPath}/Movies" method="get">
		<div id="rent">
    		<input type="submit" value="View Movies">
    	</div>
    </form>
	</section>
</body>
</html>