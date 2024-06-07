<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
fieldset table {
	margin: auto;
	text-align: left;
}


legend {
	color: white;
	background-color: #333;
}
</style>
</head>
<body>

	<div align="center">
		<fieldset>
			<legend>PythonVideos</legend>
			<form action="./pythonVideo" method="post">
				<video width="320" height="240" controls>
					<source src="movie.mp4" type="video/mp4">
					<source src="movie.ogg" type="video/ogg">
					Your browser does not support the video tag.
				</video>

				<video width="320" height="240" controls>
					<source src="movie.mp4" type="video/mp4">
					<source src="movie.ogg" type="video/ogg">
					Your browser does not support the video tag.
				</video>

				<video width="320" height="240" controls>
					<source src="movie.mp4" type="video/mp4">
					<source src="movie.ogg" type="video/ogg">
					Your browser does not support the video tag.
				</video>
			</form>
		</fieldset>
	</div>

</body>
</html>
