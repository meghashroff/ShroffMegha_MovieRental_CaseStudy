<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel = "stylesheet" type="text/css" href="css/login.css">
   
</head>
<body>
	<div>
	<a href="${pageContext.request.contextPath}/navToLoginPage">Back</a></div>
    
    <div><a href="${pageContext.request.contextPath}/">Home</a></div>
    <h1>Change Password</h1>

<div class="changePwd_container">
<form name="changePasswordForm" action ="${pageContext.request.contextPath}/updatePassword" method="post">
        <!-- <div>
			<label for="email">Username</label><br>
	        <input type="email" name = "email" id="email" placeholder="Please enter your email id"/>
        </div> 
         -->
         
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
</div>
</body>
</html>