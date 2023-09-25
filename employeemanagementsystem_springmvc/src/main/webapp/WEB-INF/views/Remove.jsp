<%@page import="com.jspiders.employeemanagementsystem_springmvc.pojo.EmployeePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page= "NavBar.jsp"/>
    <%
    List<EmployeePOJO> employees=(List<EmployeePOJO>) request.getAttribute("employees");
    String msg=(String) request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
fieldset {
	     height: 150px;
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
	margin-top: 60px;
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
			<legend>Remove Employee Details</legend>
			<form action="./remove" method="post">
				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="REMOVE">
			</form>
		</fieldset>
		<%
		if (msg != null) {
		%>
		<h3>
			<%=msg%>
		</h3>
		<%
		}
		%>
		<%
		if (employees != null) {
		%>
		<table id="data">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>CONTACT</th>
				<th>ADDRESS</th>
			</tr>
			<%
			for (EmployeePOJO pojo : employees) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getContact()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
</div>

</body>
</html>