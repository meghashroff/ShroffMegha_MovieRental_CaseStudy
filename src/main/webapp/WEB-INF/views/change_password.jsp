<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
<title>Insert title here</title>
 <link rel = "stylesheet" type="text/css" href="css/login.css">
 <script src="js/login.js"></script>
</head>
<body>
    <div><a href="${pageContext.request.contextPath}/">Home</a></div>
    <h1>Change Password</h1>

<div class="changePwd_container">
<img src = "images/allMovies.jpg" alt="">
<form name="changePasswordForm" action ="${pageContext.request.contextPath}/updatePassword" method="post" onsubmit="return validateUserCredentials()" >
         
         <div>
			<label for="username">Username</label><br>
	        <input type="text" name = "username" id="username" placeholder="Please enter your username"/>
        </div> 
        
        <br>
      	<div>
	        <label for="oldPassword">Old Password</label><br>
	        <input type="password" name = "oldPassword" id="oldPassword" placeholder="Please enter your old password"/>
        </div> 
        <br>
        <div>
	        <label for="password">New Password</label><br>
	        <input type="password" name = "newPassword" id="newpassword" placeholder="Please enter your new password"/>
        </div>
        <br>
        <div>
	        <label for="confnewpassword">Confirm New Password</label><br>
	        <input type="password" name = "confnewpassword" id="confnewpassword" placeholder="Please re-enter your new password"/>
	    </div>
        <br><br>
        <div>
            <input type="submit" id="changePwd" value = "Change Password" />    
        </div>
        	
</form> 
<h2></h2>
           
</div>
</body>
</html>