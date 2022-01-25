function fadeOut(target) {
	var level = 1;
	var outTimer = null;
	outTimer = setInterval( function() {
		level = fadeOutAction(target, level, outTimer);
	}, 50);
}
function fadeOutAction(target, level, outTimer) {
	level = level - 0.1;
	changeOpacity(target, level);
	if(level < 0) {
		clearInterval(outTimer);
	}
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
    const div = document.getElementById("symbol");
    fadeOut(div);
	setTimeout(function(){
		document.getElementById("bgcolor").style.backgroundColor = "#221436";
		setTimeout(function(){
			document.check.submit();
		}, 850);
	}, 500);
}, 4500);