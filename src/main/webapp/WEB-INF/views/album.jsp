<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/x-icon" href="resources/upload.ico">
<meta charset="UTF-8">
<title>Album</title>
</head>
<body>
	<form action="/upload/action" method="post" enctype="multipart/form-data">
		<input placeholder="altitle" type="text" name="title">
		<input placeholder="alintro" type="text" name="intro">
		<input placeholder="album" type="text" name="album">
        <input type="submit">
    </form>
</body>
</html>