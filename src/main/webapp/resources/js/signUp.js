/* var usernameList = ["demo@perscholas.com","user@gmail.com", "megha@gmail.com", "john@yahoo.com"];
var passwordList = ["demo","user","megha","john"];
*/
document.addEventListener('submit', (e) => {
  
    e.preventDefault();
    var isValid = true;
    let  isNewUser= false;

    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let phoneNo = document.getElementById("phoneNo").value;
    let password = document.getElementById("password").value;
    let confPassword = document.getElementById("confpassword").value;
    
  
  
    
    if(firstName==null||firstName=="")
    {
        alert("Please enter the first name.");
        isValid=false;
        return false;
    }
    if(lastName==null||lastName=="")
    {
        alert("Please enter the last name.");
        isValid=false;
        return false;
    }
    if(email==null||email=="")
    {
        alert("Please enter the email ID.");
        isValid=false;
        return false;
    }
    if(password==null||password=="")
   {
        alert("Please enter the password.");
        isValid=false;
        return false;
    }
    if(confPassword==null||confPassword=="")
   {
        alert("Please re-enter the password.");
        isValid=false;
        return false;
    }
    if(phoneNo==null||phoneNo=="")
   {
        alert("Please enter the phone number.");
        isValid=false;
        return false;
    }

    var pwdMatch=  matchPassword(password,confPassword);
    var h2 = document.querySelector("h2");
    
    if(pwdMatch){
    /*
         isNewUser = checkUserNameExists(email);
        // console.log(" isNewUseer: "+isNewUser);
        if(isNewUser)
        {
            // console.log("newuser");
     */       
                h2.innerHTML='Registration successful <br>' +email+  
                            '         <a href="${pageContext.request.contextPath}/createUser" style="color: #555">Click Here!</a>';
                                        // var win =window.history.back()
            // document.getElementById("password").value='';
            // document.getElementById("confpassword").value='';
       /* 
        }
        else {
            // console.log("Already exists");
         
            h2.innerHTML = 'User name '+ username +' already exists. Try again..';
            // document.getElementById("username").value ='';
            // document.getElementById("password").value='';
            // document.getElementById("confpassword").value='';
        }
        
        document.getElementById("username").value ='';
        */
        document.getElementById("password").value='';
        document.getElementById("confpassword").value='';
    } else {
        h2.innerHTML="The passwords do not match";
        document.getElementById("password").value='';
        document.getElementById("confpassword").value='';
        
    }
} 
)
/*
alert(document.getElementById("signUpForm").value);
*/
function matchPassword(pass, confPass){
    if (pass==confPass)
        return  true;
    else    
        return false;
}


function checkUserNameExists(username){
    // var usernameList=[];
    // var passwordList=[];
    var exists = false;
    for(i =0;i<usernameList.length;i++){    
        if(username==usernameList[i]){
                exists = true;
                return false;
        }
    }
    if(!exists) {
            usernameList.push(username);
            console.log(usernameList)
            passwordList.push(password);
               return true;
        }
    }
