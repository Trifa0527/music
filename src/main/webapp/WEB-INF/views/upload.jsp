<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/x-icon" href="${ a}">
<meta charset="UTF-8">
<title>Uploads</title>
</head>
<body>
	<form action="./upload/action" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
		<input placeholder="title" type="text" name="title">
		<textarea placeholder="intro" name="intro"></textarea>
		<input placeholder="artist" type="text" name="artist">
		<input placeholder="album" type="text" name="album">
        <input type="submit">
    </form>
</body>
</html>