<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<h1>Log in</h1>
	<form action="/user/register" method="post">
		email<input type="email" name="email"><br> 
		password<input type="password" name="password"><br>
		<input type="submit" value="Log in">
	</form>
</body>
</html>
