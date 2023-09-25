<%@page import="com.jspiders.employeemanagementsystem_springmvc.pojo.EmployeePOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page= "NavBar.jsp"/>
     <%
     EmployeePOJO pojo=(EmployeePOJO) request.getAttribute("employee");
     String msg=(String) request.getAttribute("msg");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
fieldset {
	     height: 100px;
	     width: 400px;
	     border: 4px solid black;
	     margin-top: -250px;
	     background-color: yellow;
}  
 input:hover {
               background-color: orange;
	
}
#data {
    
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 3px solid black;
	margin-top: 70px;
}

#data th{
    border: 3px solid black;
	text-align: center;
	background-color: orange;
}

#data td {
	border: 3px solid black;
	text-align: center;
	background-color: yellow;
}

</style>
</head>
<body>
<div align="center">
		<fieldset>
			<legend>Search Employee Details</legend>
			<form action="./search" method="post">
				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="SEARCH">
			</form>
		</fieldset>
		<%
		if(msg != null){
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>
		<%
		if (pojo != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>ADDRESS</th>
			</tr>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getContact()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
		</table>
		<%
		}
		%>
</div>
</body>
</html>