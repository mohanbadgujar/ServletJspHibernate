var request;
function sendInfo() {

	var email = document.vinform.email.value;

	var url = "emailfinder.jsp?email=" + email

	//An object of XMLHttpRequest is used for asynchronous communication between client and server.
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}

	try {
		request.onreadystatechange = getInfo;
		request.open("GET", url, true);

		request.send();
	} catch (e) {
		alert("Unable to connect to server");
	}
}

function getInfo() {
	
	//Ready state represents the state of the request if 4 The operation is completed fully.
	if (request.readyState == 4) {
		var val = request.responseText;

		document.getElementById('Error').innerHTML = val;
		document.getElementById("Error").style.color = "red";
		console.log("value==" + val);
	}
}

function sendInform() {

	var pass = document.vinform.pass.value;
	var url = "passwordValidator.jsp?pass=" + pass

	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}

	try {
		request.onreadystatechange = getInform;
		request.open("GET", url, true);
		request.send();
	} catch (e) {
		alert("Unable to connect to server");
	}
}

function getInform() {
	if (request.readyState == 4) {
		var val = request.responseText;
		document.getElementById('ErrorPass').innerHTML = val;
		document.getElementById("ErrorPass").style.color = "red";
	}
}

function ValidateLogin(email, pass) {

	var text;

	var EmailRegx = /^^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;

	var PassRegx = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{7,15}$/;

	if (email.match(EmailRegx)) {
		if (pass.match(PassRegx)) {
			return true;
		} else {

			text = "Wrong Password. Try again.";

			document.getElementById("passwordError").innerHTML = text;
			document.getElementById("passwordError").style.color = "red";

			/*alert('Wrong Password...!')*/
			return false;
		}
	} else {

		text = "Couldn't find your Todo account.";

		document.getElementById("userNameError").innerHTML = text;
		document.getElementById("userNameError").style.color = "red";
		console.log("namesdfdsf");
		//  	alert('Wrong UserName...!')
		return false;
	}

}

function ValidateRegistration() {

	var name = document.getElementById("name").value;
	var Email = document.getElementById("Email").value;
	var Pass = document.getElementById("Pass").value;
	var RePass = document.getElementById("RePass").value;
	var mobile = document.getElementById("mobile").value;

	/*	text = "Name must contain two words First Name and Last Name and one space between them.";
		
		document.getElementById("userNameError").innerHTML = text;
		document.getElementById("userNameError").style.color = "red"; */

	var NameRegx = /^\w+\s{1}\w+$/;
	/*
	 w - word 
	 s - space
	 + Quantifier — Matches between one and unlimited times, as many times as possible
	 to add more word and space = \s{1}\w+
	 */

	var EmailRegx = /^^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;

	var PassRegx = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;

	var MobileRegx = /^\d{10}$/;

	/*	#Match the beginning of the string [789] #Match a 7, 8 or 9
		\d    #Match a digit (0-9 and anything else that is a "digit" in the regex engine)
		{9}   #Repeat the previous "\d" 9 times (9 digits)
		$     #Match the end of the string */

	

	if (name.match(NameRegx)) {
		document.getElementById("userNameError").innerHTML = "";

		if (Email.match(EmailRegx)) {
			document.getElementById("userEmailError").innerHTML = "";

			if (Pass.match(PassRegx)) {
				document.getElementById("userPassError").innerHTML = "";

				if (Pass == RePass) {
					document.getElementById("userRepassError").innerHTML = "";

					if (mobile.match(MobileRegx)) {
						document.getElementById("userMobileError").innerHTML = "";

						return true;
					} else {
						//alert('Wrong Mobile Number...!Mobile Number must have 10 Number and start with 789 indian format')
						text = "Mobile Number must have 10 Digit";
						document.getElementById("userMobileError").innerHTML = text;
						document.getElementById("userMobileError").style.color = "red";

						return false;
					}
				} else {
					//alert('Repeated Password not match...!')
					text = "Repeated Password not match.";
					document.getElementById("userRepassError").innerHTML = text;
					document.getElementById("userRepassError").style.color = "red";
					return false;
				}
			} else {
				//alert('Wrong Password...! Password must consists of at least six characters that are a combination of letters, numbers and symbols (@, #, $, %, etc.)')
				text = "Password must consists of at least six characters that are a combination of letters, numbers and symbols (@, #, $, %, etc.)";
				document.getElementById("userPassError").innerHTML = text;
				document.getElementById("userPassError").style.color = "red";
				return false;
			}
		} else {
			//alert('Wrong Email...!Email should be like abc@gmail.com')  
			text = "Email should be like abc@gmail.com";
			document.getElementById("userEmailError").innerHTML = text;
			document.getElementById("userEmailError").style.color = "red";
			return false;
		}
	} else {
		//alert('Wrong Name...!\n Name must contain two words First Name and Last Name and one space between them')  
		text = "Name must contain two words First Name and Last Name and one space between them.";
		document.getElementById("userNameError").innerHTML = text;
		document.getElementById("userNameError").style.color = "red";
		return false;
	}
}	