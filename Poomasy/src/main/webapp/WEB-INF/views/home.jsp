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
	<input type="submit">
	</form>
	
	<a href="login">Naver Login</a>
	<a href="xxx">Kakao Login</a>
	<a href="xxx">Google Login</a>
</body>
</html>


