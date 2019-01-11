<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<form action="signUp" method="get">

	id <input type="email" name="userid">
	<br>
	password <input type="password" name="userpw">
	<br>
	<input value="Login" type="submit">
	</form>
</body>
</html>


