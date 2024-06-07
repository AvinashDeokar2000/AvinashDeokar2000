<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>
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

fieldset {
	/* margin: 15px 520px; */
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-size: 100%;
}
input{
       margin:5px;
}
#c{
 margin-left:50px;
 margin-right:-15px;
}
.a{
width:60px;
}
</style>
</head>
<body>

	<div align="center">
		<%
		if (msg != null) {
		%>
		<h4>
			<%=msg%>
		</h4>
		<%
		}
		%>
		<fieldset>
			<legend>Login Page</legend>
			<form action="./login" method="post">
				<table>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input id="c" type="submit" value="LOGIN">
				<a href="http://localhost:8080/springmvc1/createAccount"><input id="c" class="a" type="text" value="SING UP"></a>
			</form>

		</fieldset>
		
	</div>

</body>
</html>
