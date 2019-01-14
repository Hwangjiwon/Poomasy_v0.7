<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="ko">


<head>
<title>Google Login Success</title>
</head>
<body>
	<div class="container">
		<h1>Welcome! ${pageContext.request.userPrincipal.name}! This is
			Login Success Page :)</h1>
		<a href="j_spring_security_logout" style="color: red">
			${pageContext.request.userPrincipal.name} 로그아웃</a>
	</div>
</body>
</html>