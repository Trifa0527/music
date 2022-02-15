var ra = [];
var d = "resources/img/albumart/cover/";
var lf = 0;
var ce = 1;
var ri = 2;

function get(a, b, c, d, e){
	ra[0] = a;
	ra[1] = b;
	ra[2] = c;
	ra[3] = d;
	ra[4] = e;
}
function set(){
	document.getElementsByClassName("lfpic")[0].src = d + ra[lf] + ".png";
	document.getElementsByClassName("cepic")[0].src = d + ra[ce] + ".png";
	document.getElementsByClassName("ripic")[0].src = d + ra[ri] + ".png";
};
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
function setlr(lf, ce, ri, s){
	document.getElementsByClassName("lra")[0].style.pointerEvents = "none";
	document.getElementsByClassName("lra")[1].style.pointerEvents = "none";
	fadeOut(document.getElementsByClassName("lfpic")[0], s);
	fadeOut(document.getElementsByClassName("cepic")[0], s);
	fadeOut(document.getElementsByClassName("ripic")[0], s);
	setTimeout(function(){
		document.getElementsByClassName("lfpic")[0].src = d + ra[lf] + ".png";
		document.getElementsByClassName("cepic")[0].src = d + ra[ce] + ".png";
		document.getElementsByClassName("ripic")[0].src = d + ra[ri] + ".png";
		fadeIn(document.getElementsByClassName("lfpic")[0], s);
		fadeIn(document.getElementsByClassName("cepic")[0], s);
		fadeIn(document.getElementsByClassName("ripic")[0], s);
		setTimeout(function(){
			document.getElementsByClassName("lra")[0].style.pointerEvents = "";
			document.getElementsByClassName("lra")[1].style.pointerEvents = "";
		}, 100)
	}, 250);
}
function next(lr){
	if(lr == 1){
		lf -= 1;
		ce -= 1;
		ri -= 1;
		if(lf == -1){
			lf = 4;
		}else if(ce == -1){
			ce = 4;
		}else if(ri == -1){
			ri = 4;
		}
		setlr(lf, ce, ri, 0.25)
	}else if(lr == 2){
		lf += 1;
		ce += 1;
		ri += 1;
		if(lf == 5){
			lf = 0;
		}else if(ce == 5){
			ce = 0;
		}else if(ri == 5){
			ri = 0;
		}
		setlr(lf, ce, ri, 0.25)
	}
}