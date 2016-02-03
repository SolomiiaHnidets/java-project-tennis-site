function login_func() {
	var base_url = 'http://localhost:8080/';
	// var myForm = document.getElementById("auth_form");
	var login = document.getElementById("login").value;
	var password = document.getElementById("password").value;

	if ((login != "") && (password != "")) {
		var url = base_url + 'login/authentication';
		var params = "login=" + login + "&password=" + password;
		var result;
		var response;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera,
			// Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		var handleResponse = function(status, response) {
			alert(response)
		}
		var handleStateChange = function() {
			switch (xmlhttp.readyState) {
			case 0: // UNINITIALIZED
			case 1: // LOADING
			case 2: // LOADED
			case 3: // INTERACTIVE
				break;
			case 4: // COMPLETED
				// jQuery
				xmlhttp.abort();
				get_video_func();
				//window.location = base_url + "video.html";
				//handleResponse(xmlhttp.status, xmlhttp.responseText);
				break;
			default:
				alert("error");
			}
		}
		// xmlhttp.onreadystatechange = function() {
		// // Code inside here is executed each time the progress of the HTTP
		// // request advances.
		// if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		// // accessing to parent scope`s variable
		// result = xmlhttp.responseText;
		// alert(':) ' + xhr.responseText);
		// callback(result);
		// }
		// }
		xmlhttp.onreadystatechange = handleStateChange;
		xmlhttp.open('POST', url, true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send(params);

		// if (xmlhttp.status != 200) {
		// alert(xmlhttp.status + ': ' + xmlhttp.statusText);
		// //alert(xhr.status + ': ' + xhr.statusText);
		// }
		// if (xmlhttp.status == 200) {
		// alert(xmlhttp.status + ': ' + xmlhttp.statusText);
		// //alert(xhr.responseText);
		// }
	}
}
