<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>this is a cross file</h1>
<input type="button" id="send" value="send" onclick="send()"/>
</body>
<script src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
function send(){
	var settings = {
			  "async": true,
			  //"crossDomain": true,
			  "url": "http://localhost:8080/spring-context/rest/teacher/getTeahcer",
			  "method": "POST",
			  "headers": {
			    "Content-Type": "application/json",
			    "Cache-Control": "no-cache",
			    "Postman-Token": "d69323bc-b1f0-4d9e-ad7b-10fe9c5d4470"
			  },
			  "processData": false,
			  "data": "{\"id\":2}"
			};
	$.ajax(settings).done(function (response) {
		  console.log(response);
		});
}
$(function(){
	

	
})

</script>
</html>