<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page= "NavBar.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
           <div align="center">
           <h1>Welcome To The Spring MVC Application</h1>
          
		
		<div>
		<h2>Select Course</h2>
		<a href="http://localhost:8080/springmvc1/javaVideo"><input id="c" class="a" type="text" value="Java"></a>
		<a href="http://localhost:8080/springmvc1/pythonVideo"><input id="c" class="a" type="text" value="Python"></a>
		<a href="http://localhost:8080/springmvc1/communicationVideo"><input id="c" class="a" type="text" value="C++"></a>
		<a href="http://localhost:8080/springmvc1/communicationVideo"><input id="c" class="a" type="text" value="Communication"></a>
		</div>
		
	</div>
	<div class="ser" id="ser1">
		 <h2>Select Course</h2>
        <form action="#" id="form">
            <label for="">
                <select name="subject" id="subject">
               
                <option value="1">Java</option>
                <option value="2">Python</option>
                <option value="3">Communication</option>
                <option value="4">C++</option>
                </select>
            </label>
        </form>
        </div>

</body>
</html>