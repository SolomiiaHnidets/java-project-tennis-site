function get_video_func(userToken) {
	var base_url = 'http://localhost:8080/';
	var url = base_url + 'video/home';
	var params = "token=" + userToken;
	var result;
	var response;
	if (window.XMLHttpRequest) {
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
			alert("response");
			window.location = base_url + "video.html";
			// handleResponse(xmlhttp.status, xmlhttp.responseText);
			break;
		default:
			alert("error");
		}
	}

	xmlhttp.onreadystatechange = handleStateChange;
	xmlhttp.open('POST', url, true);
	xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send(params);

}
