/*
function validateUserCredentials(){
        var isValid = true;
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        
        
        if(username==null||username=="")
        {
            alert("Please enter the username.");
            isValid=false;
            return false;
        }
        if(password==null||password=="")
        {
            alert("Please enter the password.");
            isValid=false;
            return false;
        }
}
*/

var h4 = document.querySelector("h2");
   
function validateUserCredentials(){
        var isValid = true;
        let username = document.getElementById("username").value;
        let oldpassword = document.getElementById("oldPassword").value;
        let newpassword = document.getElementById("newpassword").value;
        let confnewpassword = document.getElementById("confnewpassword").value;
        
        if(username==null||username=="")
        {
            alert("Please enter the username.");
            isValid=false;
            return false;
        }
        if(oldpassword==null||oldpassword=="")
        {
            alert("Please enter the password.");
            isValid=false;
            return false;
        }
        if(newpassword==null||newpassword=="")
        {
            alert("Please enter the new password.");
            isValid=false;
            return false;
        }
        if(confnewpassword==null||confnewpassword=="")
        {
            alert("Please re-enter the password.");
            isValid=false;
            return false;
        }
        
        var pwdMatch=  matchPassword(newpassword,confnewpassword);
    	alert(pwdMatch);
    	console.log(pwdMatch);
   		if(pwdMatch){
  			return true;
        
   		} else {
        h4.innerHTML="The passwords do not match";
        alert("The passwords do not match");
        document.getElementById("newpassword").value='';
        document.getElementById("confnewpassword").value='';
  		return false;      
    }
}

function matchPassword(pass, confPass){
    if (pass==confPass)
        return  true;
    else    
        return false;
}


        

