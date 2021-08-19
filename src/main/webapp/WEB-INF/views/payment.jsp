 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import ="org.meghashroff.movierentals.models.Movie" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rent Page</title>
    <link rel="stylesheet" type="text/css" href="css/payment.css">
 <!--   <script src="js/payment.js"></script> -->
</head>
<body>
   <div>
    <%@ include file="navigation.html" %>
	</div>
	
    <img src="images/paymentBG1.jpg">
    <h1>Payment Information</h1>
    <div class="payment_container">
        <form name="paymentForm">
    <table >
        <tr>
            <td><label for="cardName">Name on Card</label></td>
            <td><input type = "text"  name="nameOnCard" id="nameOnCard" required /></td>
        </tr>
        <tr>
            <td><label for="cardNumber">Card Number</label></td>
            <td><input type = "text"  name="cardNo"  id = "cardNo"  minlength="15" maxlength="16" required/></td>
        </tr>
        <tr>
            <td><label for="cardExpiry">Expiry (mm/yyyy)</label></td>
            <td><select name="month" required> 
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
            </select>
            <label>/</label>
            <select name="year" required>
                <option>2021</option>
                <option>2022</option>
                <option>2023</option>
                <option>2024</option>
                <option>2025</option>
            </select>
            </td>
        </tr>
        <tr>
            <td><label for="cvv">CVV</label>
            </td>
            <td> <input type = "text"  name="cvv" id="cvv" minlength="3" maxlength="4" required/></td>
        </tr>
        <tr>
            <td>
                <label name="address">Address</label> <br></td>
        </tr>
        <tr>
            <td><label name="address">Street 1</label></td>
            <td><input  type="text" name="street1" id="street1" required> </td>
        </tr>
        <tr>
            <td><label name="address">Street 2</label></td>
            <td><input  type="text" name="street2" id="street2"> </td>
        </tr>
        <tr>
            <td><label name="city">City</label></td>
            <td><input  type="text" name="city" id="city" required> </td>
        </tr>
        <tr>
            <td><label name="state">State</label></td>
            <td><input  type="text" name="state" id="state" required> </td>
        </tr>
        <tr>
            <td><label name="country">Country</label></td>
            <td><input  type="text" name="country" disabled placeholder="US"></td>
        </tr>
        <tr>
            <td> <label name="zip">Zip</label></td>
            <td> <input  type="text" name="zip" id="zip" minlength="5" maxlength="5" required></td>
        </tr>
        
    </table>
    <br>
    <div>
    <% 
    	Movie movie = (Movie)request.getAttribute("movie");
        Integer movieId =  Integer.parseInt(request.getParameter("movieSel"));  		
            		
    %>
    
    </div>
    

</form>
	
    	<form action="${pageContext.request.contextPath}/payment" method="post">
    	<input type="hidden" name="movieId" value="<%=movieId %>"/>
        <input type="submit" value="CONFIRM" id="confirm" /> 
        </form>
    
    </div>
    <h2></h2>    
</body>
</html>