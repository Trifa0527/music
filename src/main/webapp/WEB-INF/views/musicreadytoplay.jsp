<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="resources/logo.ico">
<link rel="stylesheet" href="resources/css/rdtp.css">
<link rel="stylesheet" href="resources/css/rdtpobj.css">
<script src="resources/js/rdtp.js"></script>
<script src="resources/js/rdtponc.js"></script>
<title>Trifa's Music</title>
</head>
<body style="background-color: #221436;">
	<input type="hidden" name="set" onclick="get(${ra1}, ${ra2}, ${ra3}, ${ra4}, ${ra5}); set();">
	<div id="left">
		<div class="lct lrt">
			<a class="lra" href="" onclick="next(1); return false;">
				<img class="lfpic alpic lrpic" src="" onerror="this.src='resources/mis.png'">
			</a>
		</div>
	</div>
	<div id="selected">
		<div class="sct">
			<div class="pic">
				<a class="cea" href="" onclick="toplay(); return false;">
					<img class="alpic alpicbor cepic" src="resources/img/alpic/${aid}" onerror="this.src='resources/mis.png'">
				</a>
			</div>
			<div class="info">
				<p class="title n t0">${title0}</p><p class="title n t1">${title1}</p><p class="title n t2">${title2}</p><p class="title n t3">${title3}</p><p class="title n t4">${title4}</p>
				<p class="album n a0">${atitle0}</p><p class="album n a1">${atitle1}</p><p class="album n a2">${atitle2}</p><p class="album n a3">${atitle3}</p><p class="album n a4">${atitle4}</p>
				<div class="artistdiv">
					<p class="artist n at0">${artist0}</p><p class="artist n at1">${artist1}</p><p class="artist n at2">${artist2}</p><p class="artist n at3">${artist3}</p><p class="artist n at4">${artist4}</p>
				</div>
				<p class="date noselect n d0">${date0}</p><p class="date noselect n d1">${date1}</p><p class="date noselect n d2">${date2}</p><p class="date noselect n d3">${date3}</p><p class="date noselect n d4">${date4}</p>
			</div>
			<div class="intro">
				<p class="introcon n i0">${intro0}</p><p class="introcon n i1">${intro1}</p><p class="introcon n i2">${intro2}</p><p class="introcon n i3">${intro3}</p><p class="introcon n i4">${intro4}</p>
			</div>
		</div>
	</div>
	<div id="right">
		<div class="rct lrt">
			<a class="lra" href="" onclick="next(2); return false;">
				<img class="ripic alpic lrpic" src="" onerror="this.src='resources/mis.png'">
			</a>
		</div>
	</div>
</body>
</html>