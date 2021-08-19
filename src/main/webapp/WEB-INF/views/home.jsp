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
        @import url('https://fonts.googleapis.com/css2?family=Merienda:wght@700&display=swap');
       span {
            color: wheat;
        }
    </style>
</head>
<body>
   <div class="register">
   <% 
   if(session.getAttribute("currentUser")!=null)
   { 
   		User user =  (User)session.getAttribute("currentUser");
   %>
	    <a href="#"><% out.println("Welcome "+ user.getFirstName()); %></a>
	  	<span>|</span>
	  	<a href="${pageContext.request.contextPath}/logout">Logout</a>  
   <% 		
   } 
   else 
   {
   %>
		<a href="${pageContext.request.contextPath}/SignUp">Sign Up</a>  <span>|</span> <a href="${pageContext.request.contextPath}/LoginPage" id="signIn">Sign In</a></div>
   <%
   } 
   %>
   </div>
   <div>
   	<img style="position:fixed;top:0px;left:0px;width:100%;height:100%;z-index:-1;" name="backgroundImg" src= "images/movieBackground.jpg"/> 
    </div>
	<h1 style="font-family: 'Merienda', cursive; color: gold; text-transform: uppercase;" >All the movies in one place! </h1>
   
    <section id="about">
    <div class="about_container">
        <p>
        	Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean placerat metus eros, finibus mattis lorem ornare vel. Nunc eu quam hendrerit, ornare nunc eu, aliquet dui. Maecenas facilisis consequat sem vel consequat. Proin lacinia sed nulla vel dapibus. Fusce at arcu quis quam feugiat posuere a non ligula. Morbi ac sagittis justo, eu vestibulum dui. Maecenas augue purus, ullamcorper non dignissim sit amet, aliquam vitae ante.
        </p>
        <p>
            Phasellus convallis laoreet sapien, ut molestie libero vehicula nec. Etiam feugiat ex quis metus efficitur semper. 
            Vivamus dapibus lectus orci, non auctor augue tempus ac. Quisque semper ex sem, sed condimentum urna placerat id. 
            Suspendisse bibendum lectus nulla, nec viverra neque iaculis vel. Morbi lorem velit, eleifend quis condimentum vitae, semper suscipit 
            libero. Donec ante arcu, facilisis ut suscipit non, convallis sit amet ante. In tellus ante, fringilla et metus quis, sagittis porta velit.
            Aliquam laoreet laoreet eros non mattis. In ut vestibulum dolor. Phasellus dignissim aliquam leo, eu efficitur enim convallis eget.
            Donec pharetra ex non nulla tempus scelerisque. Sed lobortis egestas aliquet. Sed suscipit ex in nunc congue, a dignissim massa congue.
        </p>
        
        <br />
    </div>
    <button><a href="${pageContext.request.contextPath}/Movies">View Movies</a></button>
    
	</section>
</body>
</html>