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
<title>Trifa's Music</title>
</head>
<body style="background-color: #221436;">
	<div id="left">
		<div class="lct">
		
		</div>
	</div>
	<div id="selected">
		<div class="sct">
			<div class="pic">
				<img class="alpic" src="resources/img/alpic/${aid}" onerror="this.src='resources/mis.png'">
			</div>
			<div class="info">
				<p class="title">${title}</p>
				<p class="album">${atitle}</p>
				<p class="artist">${artist}</p>
				<p class="date">${date}</p>
			</div>
			<div class="intro">
				<p class="introcon">${intro}</p>
			</div>
		</div>
	</div>
	<div id="right">
		<div class="rct">
		
		</div>
	</div>
</body>
</html>