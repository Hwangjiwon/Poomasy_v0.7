<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<!--  
	<form action="signUp" method="get">

	id <input type="email" name="email">
	<br>
	password <input type="password" name="password">
	<br>
	<input type="submit">
	</form>
	-->

	<form role="form" method="get" action="j_spring_security_check">
		<div class="form-group">
			<label for="id"> Email :</label> <input type="email" class="form-control"
				id="id" name="j_username" placeholder="Enter email" required="required">
		</div>
		<div class="form-group">
			<label for="pw"> Password :</label> <input type="password"
				class="form-control" id="pw" name="j_password"
				placeholder="Enter Password" required="required">
		</div>

		<button type="submit" class="btn btn-default btn-block">
			Login</button>
	</form>
	
	<button type="submit" onclick="location='signUp.jsp'">
			Sign Up</button>
	<a href="n_login">Naver Login</a>
	<a href="xxx">Kakao Login</a>
	<a href="g_login">Google Login</a>
</body>
</html>


