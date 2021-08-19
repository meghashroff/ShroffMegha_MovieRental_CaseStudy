document.addEventListener('submit', function (e) {
    e.preventDefault();
    var nameOnCard  = document.getElementById("nameOnCard").value;
    var cardNo  = document.getElementById("cardNo").value;
    var cvv  = document.getElementById("cvv").value;
    var street1  = document.getElementById("street1").value;
    var street2  = document.getElementById("street2").value;
    var city  = document.getElementById("city").value;
    var state  = document.getElementById("state").value;
    var zip  = document.getElementById("zip").value;
    
  
    if( !lettersAndSpaceCheck(nameOnCard)){
        alert("Name can contain only letters and spaces");
        return false;
    }

    
    if (isNaN(cardNo))
    {
        alert("Card Number is not valid");
        return false;
    }

    
    if (isNaN(cvv))
    {
        alert("CVV must be a number");
        return false;

    }

    if( !alphanumericCheck(street1)){
        alert("Street can contain only letters, numbers and spaces");
        return false;
    }

    if(street2!==''){
        if( !alphanumericCheck(street2)){
            alert("Street can contain only letters, numbers and spaces");
            return false;
        }
    }

    
    if( !lettersAndSpaceCheck(city)){
        alert("City name can contain only letters and spaces");
        return false;
    }


    if( !lettersAndSpaceCheck(state)){
        alert("State can contain only letters and spaces");
        return false;
    }

    
    if (isNaN(zip))
    {
        alert("Zip Code is invalid");
        return false;
    }
    
    
       
    var h2 = document.querySelector("h2");
    h2.innerHTML="Payment Confirmed. Enjoy the movie!!";
    h2.style.textAlign = "center";
    
    //document.paymentForm.submit();
    }
)

function lettersAndSpaceCheck(name)
{
   var regEx = /^[A-Za-z ]*$/;
   if(name.match(regEx)){
      return true;
   }
   else{
       return  false;
    }
}    

function alphanumericCheck(val){
    var regExp = /^[0-9a-zA-Z ]+$/;
       if(val.match(regExp)){
      return true;
   }
   else{
       return  false;
    }
}