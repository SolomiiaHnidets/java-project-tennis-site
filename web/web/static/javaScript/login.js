function login() {
    var xhr = new XMLHttpRequest();

    xhr.open('GET', 'http://localhost:8080/login/fake', true);

    xhr.send();
    if (xhr.status != 200) {
        alert( xhr.status + ': ' + xhr.statusText );
        alert( xhr.status + ': ' + xhr.statusText );
    } else {
        alert( xhr.responseText );
    }
}