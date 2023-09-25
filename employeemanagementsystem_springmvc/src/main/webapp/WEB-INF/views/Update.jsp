<%@page import="com.jspiders.employeemanagementsystem_springmvc.pojo.EmployeePOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page= "NavBar.jsp"/>
    <%
    List<EmployeePOJO> employees=(List<EmployeePOJO>) request.getAttribute("employees");
    EmployeePOJO pojo= (EmployeePOJO) request.getAttribute("employee");
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
	     margin-top: -270px;
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
	margin-top: 80px;
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
          <%
          if(pojo == null){
          %>
		<fieldset>
			<legend>Select Employee to Update</legend>
			<form action="./update" method="post">
				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
				<input type="submit" value="SELECT">
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
		if(employees != null){
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
			for (EmployeePOJO employee : employees){
			%>
			<tr>
				<td><%=employee.getId()%></td>
				<td><%=employee.getName()%></td>
				<td><%=employee.getEmail()%></td>
				<td><%=employee.getContact()%></td>
				<td><%=employee.getAddress()%></td>
			</tr>
			<%
		     }
			%>
		</table>
		<%
          }
          } else{
		%>
		<fieldset>
			<legend>Update Student</legend>
			<form action="./updateEmployee" method="post">
				<table>
					<tr>
						<td>ID</td>
						<td><%=pojo.getId()%></td>
						<td><input type="text" name="id" value="<%=pojo.getId()%>" hidden="true"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"
							value="<%=pojo.getName()%>"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"
							value="<%=pojo.getEmail()%>"></td>
					</tr>
					<tr>
						<td>Contact</td>
						<td><input type="text" name="contact"
							value="<%=pojo.getContact()%>"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"
							value="<%=pojo.getAddress()%>"></td>
					</tr>
				</table>
				<input type="submit" value="UPDATE">
			</form>
		</fieldset>
		<%
		}
		%>
</div>	
</body>
</html>