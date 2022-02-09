var ra = [];
var d = "resources/img/albumart/cover/";
var lf = 0;
var ce = 1;
var ri = 2;

function set(){
	document.getElementsByClassName("lfpic")[0].src = d + ra[lf] + ".png";
	document.getElementsByClassName("cepic")[0].src = d + ra[ce] + ".png";
	document.getElementsByClassName("ripic")[0].src = d + ra[ri] + ".png";
};

function get(a, b, c, d, e){
	ra[0] = a;
	ra[1] = b;
	ra[2] = c;
	ra[3] = d;
	ra[4] = e;
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
		document.getElementsByClassName("lfpic")[0].src = d + ra[lf] + ".png";
		document.getElementsByClassName("cepic")[0].src = d + ra[ce] + ".png";
		document.getElementsByClassName("ripic")[0].src = d + ra[ri] + ".png";
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
		document.getElementsByClassName("lfpic")[0].src = d + ra[lf] + ".png";
		document.getElementsByClassName("cepic")[0].src = d + ra[ce] + ".png";
		document.getElementsByClassName("ripic")[0].src = d + ra[ri] + ".png";
	}
}