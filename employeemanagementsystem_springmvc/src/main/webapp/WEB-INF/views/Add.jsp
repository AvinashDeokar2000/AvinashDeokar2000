<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String msg =(String) request.getAttribute("msg"); %>
    <jsp:include page= "NavBar.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 fieldset {
	     height: 130px;
	     width: 400px;
	     border: 4px solid black;
	     margin-top: -270px;
	     background-color: yellow;
}  
 input:hover {
               background-color: orange;
	
}
</style>
</head>

<body>

       <div  align="center">
           <fieldset>
               <legend>Add Employee Details</legend>
                 <form action="./add" method="post">
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>Contact</td>
						<td><input type="text" name="contact"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"></td>
					</tr>
				</table>
				<input type="submit" value="ADD">
			</form>
           </fieldset>
           <%
           if(msg != null){
           %>
           <h1><%=msg%>
           </h1>
           <%} %>
       </div>

</body>
</html>