function rand ( n )
{
  return ( Math.floor ( Math.random ( ) * n + 1 ) );
}

// Store youtube [CHANGES NEEDED IN THE 3 URLS BELOW]
var vids = new Array ( );
vids[0] = "http://www.youtube.com/embed/XGSy3_Czz8k" ;
vids[1] = "https://www.youtube.com/embed/YQHsXMglC9A";
vids[2] = "https://www.youtube.com/embed/DfG6VKnjrVw";
vids[3] = "https://www.youtube.com/embed/--Wokwe4-i0";
vids[4] = "https://www.youtube.com/embed/D8HqRH5cHPo";
vids[5] = "http://www.youtube.com/embed/D4L0KpqNzkU";
vids[6] = "https://www.youtube.com/embed/BsZCzeRKYcs";
vids[7] = "https://www.youtube.com/embed/yGNejPfg2e4";

// Pick a random video from the list
function pick_vid ( )
{
  var numberOfImages = vids.length; //[CHANGE THE 3 TO THE TOTAL NUMBER OF VIDS YOU USE]
  var num;
  var index;
  for (i = 0; i < vids.length; i++) { 
	  num = rand(numberOfImages)-1;
	  index = i + 1; 
	  document.getElementById("video_"+ index).src = vids[num];
	}
 
}

