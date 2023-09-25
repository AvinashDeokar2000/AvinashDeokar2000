<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style type="text/css">
  #box{
         height: 350px;
         width: 300px;
         border: 4px solid black;
         background: orange;
         margin-top: 50px;
         margin-left: 50px;
  }
  li:hover{ 
              
             background-color: yellow;
  }
  
</style>
</head>
<body>
	<ul id="box">
	    <li><h1><a style="color: black;" href="./home">Home</a></h1></li>
		<li><h1><a style="color: black;" href="./add">Add Employee</a></h1></li>
		<li><h1><a style="color: black;" href="./update">Update Employee</a></h1></li>
		<li><h1><a style="color: black;" href="./remove">Remove Employee</a></h1></li>
		<li><h1><a style="color: black;" href="./search">Search Employee</a></h1></li>
		<li><h1><a style="color: black;" href="./logout">Logout</a></h1></li>
	</ul>
</body>
</html>