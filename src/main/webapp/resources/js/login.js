function validateUserCredentials(){
	let h4 = document.querySelector("h2");
	var isValid= false;
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
    let pwdMatch=  matchPassword(newpassword,confnewpassword);
	if(pwdMatch)
	{
		isValid=true;
    } 
    else
    {
        document.getElementById("newpassword").value='';
    	document.getElementById("confnewpassword").value='';
	    h4.innerHTML="The passwords do not match";
   	}
    return isValid;
}

function matchPassword(pass, confPass){
    if (pass==confPass)
        return  true;
    else    
        return false;
}


        

