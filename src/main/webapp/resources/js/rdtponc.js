var ra = [];
var d = "resources/img/albumart/cover/";
var lf = 4;
var ce = 0;
var ri = 1;

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
		}, 700)
	}, 250);
}
function next(lr){
	rdInfo(ce);
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
		setlr(lf, ce, ri, 0.25);
		setInfo(ce);
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
		setlr(lf, ce, ri, 0.25);
		setInfo(ce);
	}
}
function toplay(){
	
	var url = "";
	var form = document.createElement('form');
    form.setAttribute('method', 'post');
    form.setAttribute('action', url);
    
    var hiddenField = document.createElement('input');
    hiddenField.setAttribute('type', 'hidden');
    hiddenField.setAttribute('name', 'id');
    hiddenField.setAttribute('value', ra[ce]);
    
    var hiddenField2 = document.createElement('input');
    hiddenField2.setAttribute('type', 'hidden');
    hiddenField2.setAttribute('name', 'che');
    hiddenField2.setAttribute('value', 'suc');
    
    form.appendChild(hiddenField);
    form.appendChild(hiddenField2);
    
    document.body.appendChild(form);
    form.submit();
}
function rdInfo(i){
	var title = document.getElementsByClassName("t"+i)[0];
    var intro = document.getElementsByClassName("i"+i)[0];
    var artist = document.getElementsByClassName("at"+i)[0];
    var album = document.getElementsByClassName("a"+i)[0];
    var date = document.getElementsByClassName("d"+i)[0];
    title.style.display="none";
    intro.style.display="none";
    artist.style.display="none";
    album.style.display="none";
    date.style.display="none";
    title.style.opacity="0";
    intro.style.opacity="0";
    artist.style.opacity="0";
    album.style.opacity="0";
    date.style.opacity="0";
}
function setInfo(i){
	var title = document.getElementsByClassName("t"+i)[0];
    var intro = document.getElementsByClassName("i"+i)[0];
    var artist = document.getElementsByClassName("at"+i)[0];
    var album = document.getElementsByClassName("a"+i)[0];
    var date = document.getElementsByClassName("d"+i)[0];
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
						fadeIn(intro, 0.2);
					}, 70);
				}, 70);
			}, 70);
		}, 70);
	}, 200);
}