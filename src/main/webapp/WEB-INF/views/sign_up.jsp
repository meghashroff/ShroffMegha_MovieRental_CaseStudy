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
    <link rel = "stylesheet" type="text/css" href="css/signUp.css">
      <script src="js/signUp.js"></script> 
    
</head>
<style>
	.form-errors{
		color: red;
	}
</style>
<body>
    <img src = "images/movieBackground3.jpg" >
    <div><a href="${pageContext.request.contextPath}/">Home</a></div>
    <h1>Sign Up</h1>     
    
    <div class="signIn_container">
    <form:form name="signUpForm" id="signUpForm" method="post" action="createUser" modelAttribute="user" onsubmit="return validateUser()">
    		<div>
			<form:label path="firstName">First Name</form:label> <form:errors path="firstName" class="form-errors"/> 
			<br>
			<form:input type="text" name = "firstName" class="boxSize" placeholder="Please enter the first name" path="firstName" />
			<br>
			<%-- <form:errors path="firstName" class="form-errors"/> --%>
		</div>
		<br>
		<div>
			<form:label path="LastName">Last Name</form:label>
			<br>
			<form:input type="text" name = "LastName" class="boxSize" placeholder="Please enter the last name" path="lastName" />
			<br>
			<form:errors path="lastName" class="form-errors"/>
		</div>
		<br>
    	<div>
			<form:label path="email">Email</form:label>	<form:errors path="email" class="form-errors"/>
		
			<br>
			<form:input type="email" name = "email" class="boxSize" placeholder="Please enter an email address" path="email" />
			<br>
			<%-- <form:errors path="email" class="form-errors"/> --%>
		</div>
		<br>
		<div>
			<form:label path="password">Password</form:label> <form:errors path="password" class = "form-errors"/>
			<br>
			<form:input type="password" name = "password" class="boxSize" placeholder="Please enter the password" path="password" />
			<br>
			<%-- <form:errors path="password" class = "form-errors"/> --%>
		</div>
		<br>
		<div>
			<label for="password">Confirm Password</label><br>
        	<input type="password" name = "confpassword" class="boxSize" placeholder="Please re-enter the password" id="confpassword" />
        </div>
		<br>
			<div>
			<form:label path="phoneNo">Phone Number</form:label>
						<form:errors path="phoneNo" class="form-errors"/>
			
			<br>
			<form:input type="text" name = "phoneNo" class="boxSize" placeholder="Please enter a phone number" path="phoneNo" />
			<br>
			<%-- <form:errors path="phoneNo" class="form-errors"/> --%>
		</div>
		<br>
		
		<div>
            <input type="submit" id="login" value = "Sign Up">    
        </div>
        <br>
        <div>
		<a href="${pageContext.request.contextPath}/LoginPage" id="signIn" style="margin: 30px;">Already registered, login here</a>
		</div> <h2></h2>
		</form:form>
           
</div>
</body>
</html>