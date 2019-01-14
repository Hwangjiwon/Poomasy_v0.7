<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Logout!</h1>

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

	<div class="modal-dialog">

			<div>
				<h1 style="font-size: x-large;">
					Spring Security<small>v.인메모리</small>
				</h1>
			</div>
		<!-- Modal content-->
		<div class="modal-content">

			<div class="modal-header" style="padding: 35px 50px;">
				<h4>
					<span class="glyphicon glyphicon-lock"></span> 로그인
				</h4>
				<label>로그아웃 되었습니다.</label>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
					<div class="form-group">
						
					</div>
					<a href="home.it" class="btn btn-default btn-block">Re Login</a>
			</div>
			<div class="modal-footer"></div>
		</div>

	</div>

</body>
</html>


