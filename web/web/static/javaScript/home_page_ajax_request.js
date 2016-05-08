function get_video_func(userToken) {
    var base_url = 'http://localhost:8080/';
    var url = base_url + 'video/home';
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    var handleStateChange = function () {
        switch (xmlhttp.readyState) {
            case 0: // UNINITIALIZED
            case 1: // LOADING
            case 2: // LOADED
            case 3: // INTERACTIVE
                break;
            case 4: // COMPLETED
                var strJSON = xmlhttp.responseText;
                pickup_catalog(strJSON);
                break;
            default:
                alert("error");
        }
    }

    xmlhttp.onreadystatechange = handleStateChange;
    xmlhttp.open('POST', url, true);
    xmlhttp.setRequestHeader("token", userToken);
    xmlhttp.send();
}

function call_video_controller(token) {
    var proceed = true;
    if (proceed) { //everything looks good
        get_video_func(token);
    }
}