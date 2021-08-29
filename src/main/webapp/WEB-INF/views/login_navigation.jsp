<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.meghashroff.movierentals.models.User" %>
	<% 
   User user = (User)request.getAttribute("currentUser");
   if(user!=null)
   { 
   %>
	    <a href="${pageContext.request.contextPath}/accountInfo	"><% out.println(user.getFirstName()); %></a>
	  	<span>|</span>
	  	<a href="${pageContext.request.contextPath}/logout">Logout</a>  
   <% 		
   } 
   else 
   {
   %>
		<a href="${pageContext.request.contextPath}/SignUp">Sign Up</a>  <span>|</span> <a href="${pageContext.request.contextPath}/login" id="signIn">Sign In</a>
   <%
   } 
   %>
   