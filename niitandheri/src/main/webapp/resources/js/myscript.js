/* window.onbeforeunload = function () {
    return "Are you sure";
}; */

$(function(){
	$("#ms_timer").countdowntimer({
				minutes : 30,
                seconds : 00,
                size : "xs",
          
                
               	
	});
}); 


/*function setCounter(count) {
    $('#counter').text(9000 - count);
}
 get the time passed from the cookie, if one is set 
var count = parseInt(($.cookie('mytimeout') || 0), 10);

 set an interval that adds seconds to the count 
setCounter(count);
var interval = setInterval(function () {
    count++;
    setCounter(count);
     plus, you can do something you want to do every second here, 
     like display the countdown to the user 
}, 1000);

 set a timeout that expires 900000 Milliseconds (15 Minutes) - 
   the already passed time from now 
var timeout = setTimeout(function () {
     put here what you want to do once the timer epires 
}, 900000 - count * 1000);

 before the window is reloaded or closed, store the current timeout in a cookie. 
   For cookie options visit jquery-cookie 
window.onbeforeunload = function () {
    $.cookie('mytimeout', count, {
        expires: 7,
        path: '/'
    });
};*/
setInterval(submit_me, 1800000); // (30 mins*60 = 1800secs output (1 sec = 1000 so 1800000))

function submit_me() {	
	alert('Your time is up. Submit your test');
	document.getElementById("form").submit();
	}
document.addEventListener("contextmenu", function(e){
    e.preventDefault();
}, false);


function disableF5(e) { if ((e.which || e.keyCode) == 116) e.preventDefault(); };
$(document).on("keydown", disableF5);
