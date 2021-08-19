document.addEventListener('submit', function (e) {
  
        e.preventDefault();
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
        

        isValid = checkCredentials(username, password);
        var h2 = document.querySelector("h2");

        if(isValid)
        {
                h2.innerHTML='Login Successful. <br>' +username +  
                            '         <a href="${pageContext.request.contextPath}/" style="color: #555">Click Here!</a>';
                                        // var win =window.history.back()
        }
        else {
            h2.innerHTML = 'Invalid credentials. Try again.. ';
        }

    }
)


function checkCredentials(username, password){
    var usernameList = ["demo@perscholas.com","user@gmail.com", "megha@gmail.com", "john@yahoo.com"];
    var passwordList = ["demo","user","megha","john"]
    for(i =0;i<usernameList.length;i++){    
        if(username==usernameList[i]){
            if(password==passwordList[i]){
            return true;
            }
        }
    }
    return false;
}

