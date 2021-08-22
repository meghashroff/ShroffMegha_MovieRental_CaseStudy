
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

