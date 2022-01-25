<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="resources/logo.ico">
<link rel="stylesheet" href="resources/css/musicmain.css">
<link rel="preload" href="resources/logo.png">
<link rel="preload" href="resources/letter.mp4">
<script src="resources/js/musicmainanime.js"></script>
<title>Trifa's music</title>
</head>
<body id="bgcolor">
	<div id="symbol">
		<div class="logo">
			<img class="logopng" src="resources/logo.png">
		</div>
		<div class="letter">
			<video width="100%" autoplay muted>
				<source src="resources/letter.mp4" type="video/mp4">
				<source src="resources/letter.webm" type="video/webm">
			</video>
		</div>
	</div>
	<form name="check" method="POST" action="player">
		<input type="hidden" name="che" value="suc">
	</form>
</body>
</html>