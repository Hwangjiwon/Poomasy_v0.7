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
				<label>로그인에 실패했습니다.</label>
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