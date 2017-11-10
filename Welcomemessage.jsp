<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<script type="text/javascript">
function myFunction() {
	alert('hi');
var name=<%session.getAttribute("uname1"); %>;
alert(name);
}

</script>

</head>


<body onload="myFunction()">

Welcome To LTI 
Have a nice day....
How may I help you?

</body>
</html>