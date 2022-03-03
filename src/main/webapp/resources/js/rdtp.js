function fadeOut(target, ma) {
	var level = 1;
	var outTimer = null;
	outTimer = setInterval( function() {
		level = fadeOutAction(target, level, outTimer, ma);
	}, 50);
}
function fadeOutAction(target, level, outTimer, ma) {
	level = level - ma;
	changeOpacity(target, level);
	if(level < 0) {
		clearInterval(outTimer);
	}
	return level;
}
function fadeIn(target, ma) {
	var level = 0;
	var inTimer = null;
	inTimer = setInterval( function() {
		level = fadeInAction(target, level, inTimer, ma);
	}, 50);
}
function fadeInAction(target, level, inTimer, ma) {
	level = level + ma;
	changeOpacity(target, level);
	if(level>1) clearInterval(inTimer);
	return level;
}
function changeOpacity(target, level) {
	var obj = target;
	obj.style.opacity = level;
	obj.style.MozOpacity = level;
	obj.style.KhtmlOpacity = level;
	obj.style.MsFilter = "'progid: DXImageTransform.Microsoft.Alpha(Opacity=" + (level * 100) + ")'";
	obj.style.filter = "alpha(opacity=" + (level * 100) + ");";
}



setTimeout(function(){
	const set = document.getElementsByName("set")[0];
	set.click();
	set.remove();
	document.getElementsByClassName("lra")[0].style.pointerEvents = "none";
	document.getElementsByClassName("lra")[1].style.pointerEvents = "none";
    var sted = document.getElementById("selected");
	fadeIn(sted, 0.1);
	var title = document.getElementsByClassName("t0")[0];
    		var intro = document.getElementsByClassName("i0")[0];
    		var artist = document.getElementsByClassName("at0")[0];
    		var album = document.getElementsByClassName("a0")[0];
    		var date = document.getElementsByClassName("d0")[0];
    		title.style.display="block";
    		intro.style.display="block";
    		artist.style.display="block";
    		album.style.display="block";
    		date.style.display="block";
			setTimeout(function(){
				fadeIn(title, 0.1);
					setTimeout(function(){
						fadeIn(album, 0.1);
						setTimeout(function(){
							fadeIn(artist, 0.1);
							setTimeout(function(){
								fadeIn(date, 0.1);
								setTimeout(function(){
									fadeIn(intro, 0.1);
									setTimeout(function(){
										document.getElementsByClassName("lra")[0].style.pointerEvents = "";
										document.getElementsByClassName("lra")[1].style.pointerEvents = "";
									}, 100)
								}, 100);
							}, 100);
						}, 100);
					}, 100);
				}, 400);
	setTimeout(function(){
    	var left = document.getElementById("left");
		fadeIn(left, 0.1);
		var right = document.getElementById("right");
		fadeIn(right, 0.1);s
	}, 600);
}, 200);
