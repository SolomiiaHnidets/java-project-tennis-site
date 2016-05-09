/**
 * Created by John on 08.05.2016.
 */
function rand(n) {
    return ( Math.floor(Math.random() * n + 1) );
}
var videos = new Array();

function populate_catalog(strJSON) {
    var jsonData = JSON.parse(strJSON);
    for (var i = 0; i < jsonData.length; i++) {
        var video = jsonData[i];
        //console.log(video.url);
        videos[i] = video.url;
    }
}

function pickup_catalog(strJSON) {
    populate_catalog(strJSON);
    var numberOfVideos = videos.length;
    var num;
    var index;
    for (var i = 0; i < numberOfVideos; i++) {
        num = rand(numberOfVideos) - 1;
        index = i + 1;
        document.getElementById("video_" + index).src = videos[num];
        document.getElementById("video_number_" + index).value = num;
    }
}

