<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import ="org.meghashroff.movierentals.models.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <link rel = "stylesheet" type="text/css" href="css/login.css">
    <!-- <script src="js/login.js"></script>  -->
    
</head>
<body>
    <img src = "images/allMovies.jpg" >
    <div><a href="${pageContext.request.contextPath}/">Home</a></div>
    <h1>Login Page</h1>     
    
    <div class="login_container">
  	<%-- <form:form action="/login" modelAttribute="user" method="post">
  		<div>
  			<form:label for="username" path="email">Username</form:label><br>
  			<form:input type="email" name = "username" id="username" placeholder="Please enter your email id" path="email"/>
  		</div>
  		<br>
  		<div>
  			<form:label for="password" path="password">Password</form:label><br>
  			<form:input type="password" name = "password" id="password" placeholder="Please enter your password" path="password" />
  		</div>
  		  <div>
            <input type="submit" id="login" value = "Log In"  />    
        </div>    
      
  		<br><br>
	 </form:form> --%> 
  
      <form name="loginForm" action ="login" method="post">
        <div>
        <label for="username">Username</label><br>
        <input type="email" name = "username" id="username" placeholder="Please enter your email id">
        </div> 
        <br>
        <div>
        <label for="password">Password</label><br>
        <input type="password" name = "password" id="password" placeholder="Please enter your password">
        </div>
        <br><br>
        <div>
            <input type="submit" id="login" value = "Log In" >    
        </div>    
        	<a href ="${pageContext.request.contextPath}/changePassword" style="font-size: medium;margin: 120px; text-decoration:none; text-align: center; color: white;">Change Password</a>
        
        <h2></h2>
        </form>
  
</div>
</body>
</html>