<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Đăng Nhập</h2>
				</div>
				<form action="${pageContext.request.contextPath}/dang-nhap" id="loginForm"
					method="post">
				<%-- <form action="<c:url value='/dang-nhap' />" id="loginForm"
					method="post"> --%>
					<div class="form-group">
						<input type="text" class="form-control" id="userName"
							name="userName" placeholder="Tên Đăng Nhập">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="passWord"
							name="passWord" placeholder="Mật khẩu">
					</div>
					<input type="hidden" value="login" name="action" />
					<button type="submit" class="btn btn-primary">Đăng Nhập</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>