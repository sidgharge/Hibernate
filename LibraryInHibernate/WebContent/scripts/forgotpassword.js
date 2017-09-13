
function validateReset(){
	var email = document.getElementById("email").value;
	var regEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(!regEx.test(email)){
    	alert("Incorrect Email Id")
    	return false;
    }
	
	var password = document.getElementById("password").value;
	var cpassword = document.getElementById("cpassword").value;
	if(password.length < 8){
		alert("Password must be at least 8 characters long");
		return false;
	}
	if(password != cpassword){
		alert("Both the password fields must be same");
		return false;
	}
	return true;
}