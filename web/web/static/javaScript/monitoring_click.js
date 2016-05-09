/**
 * Created by John on 08.05.2016.
 */
//$('#video_1').contents().find("body").mousedown(function(event) {
//    switch (event.which) {
//        case 1:
//            alert('Left mouse button pressed');
//            break;
//        case 2:
//            alert('Middle mouse button pressed');
//            break;
//        case 3:
//            alert('Right mouse button pressed');
//            break;
//        default:
//            alert('You have a strange mouse');
//    }
//});
function onClickFunction(clicked_id){
    var x = document.getElementById(clicked_id);
    alert(x.value);

}
//$('#open').click(function(e) {
//    e.preventDefault();
//   alert("hhj");
//});
//var test = document.getElementById("d1");
//function whatClicked(evt) {
//    alert(evt.target.id);
//}
//
//test.addEventListener("click", whatClicked, false);
//document.getElementById("d1").onmousedown = function () {
//    alert("User moused down");
//    return true; // Not needed, as long as you don't return false
//};
//
//document.getElementById("d1").onclick = function(e) {
//    e = e || event
//    var target = e.target || e.srcElement
//// variable target has your clicked element
//    innerId = target.id;
//    //  do your stuff here.
//    alert("Clicked!");
//
//}
//$('a.video').click(function () {
//    var id = $(this).attr('data-youtube');
//    var src = id;
//    //<iframe height="200" id="video_1" frameborder="0" allowfullscreen></iframe>
//    var iframe = '<iframe id="youtube" width="560" height="315" frameborder="0" src="'+src+'" allowfullscreen></iframe>';
//    $(".video-wrapper").html(iframe);
//    return false;
//});
//$("html").click(function (e)
//{
//    if (e.target == document.getElementById("div1"))
//        alert("In");
//    else
//        alert("Out!");
//});
//$('#video_1').load(function(){
//
//    var iframe = $('#video_1').contents();
//
//    iframe.find("#choose_pics").click(function(){
//        alert("test");
//    });
//});
//var monitor = setInterval(function(){
//    var elem = document.activeElement;
//    if(elem && elem.tagName == "video_1" ){
//        clearInterval(monitor);
//        alert('clicked!');
//    }
//}, 100);