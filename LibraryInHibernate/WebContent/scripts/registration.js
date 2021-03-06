
function validateForm(){
	
	var name = document.getElementById("name").value;
	if(name.length < 3){
		alert("Name is too short");
		return false;
	}
	console.log("before email");
	var email = document.getElementById("email").value;
	var regEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(!regEx.test(email)){
    	alert("Incorrect Email Id")
    	return false;
    }
	
	var contact = document.getElementById("mobno").value;
	if(isNaN(contact)){
		alert("Invalid contact number");
		return false;
	}
	if(contact.toString().length != 10){
		alert("Contact number must have 10 digits");
		return false;
	}
	
	var male = document.getElementById("male").checked;
	var female = document.getElementById("female").checked;
	if(!male && !female){
		alert("Please select a gender");
		return false;
	}
	
	var password = document.getElementById("password").value;
	if(password.length < 8){
		alert("Password must be at least 8 characters long");
		return false;
	}
	
	return true;
}

$(document).ready(function(){
	$('#register-button').click(function(){
		if(validateForm()){
			var isMaleChecked = $("#male").is(":checked");
			var gender = "";
			if(isMaleChecked){
				gender = "Male";
			} else{
				gender = "Female";
			}
			$.ajax({
				type : "post",
				url : "Register",
				data : {
					name : $('#name').val(),
					email : $('#email').val(),
					contact : $('#mobno').val(),
					gender : gender,
					password : $('#password').val()
				},
				success : function(data){
					console.log("Ajax success");
					if(data == "Success"){
						window.location = "PreLogIn";
					} else{
						alert("Email ID is already used...");
					}
				}
			});
		} else{
			console.log("Validation failed");
		}		
	});
});