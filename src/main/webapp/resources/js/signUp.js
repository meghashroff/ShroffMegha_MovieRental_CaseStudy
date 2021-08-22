
function validateUser(){
	
    var isValid = true;
    let  isNewUser= false;

    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let phoneNo = document.getElementById("phoneNo").value;
    let password = document.getElementById("password").value;
    let confPassword = document.getElementById("confpassword").value;
    
  
   var h2 = document.querySelector("h2");
   
    
/*    if(firstName==null||firstName=="")
    {
   //     alert("Please enter the first name.");
        isValid=false;
        return false;
    }
    if(lastName==null||lastName=="")
    {
     //   alert("Please enter the last name.");
        isValid=false;
        return false;
    }
    if(email==null||email=="")
    {
       // alert("Please enter the email ID.");
        isValid=false;
        return false;
    }
    if(password==null||password=="")
   {
        //alert("Please enter the password.");
        isValid=false;
        return false;
    } */
    
    if(confPassword==null||confPassword=="")
   {
   
   	     h2.innerHTML="Re-enter the password";
   
   //     alert("Please re-enter the password.");
        isValid=false;
        return false;
    }
   /* if(phoneNo==null||phoneNo=="")
   {
   //     alert("Please enter the phone number.");
        isValid=false;
        return false;
    }*/

    var pwdMatch=  matchPassword(password,confPassword);
    
    if(pwdMatch){
  	return true;
        
   } else {
        h2.innerHTML="The passwords do not match";
        document.getElementById("password").value='';
        document.getElementById("confpassword").value='';
  		return false;      
    }
}

function matchPassword(pass, confPass){
    if (pass==confPass)
        return  true;
    else    
        return false;
}


