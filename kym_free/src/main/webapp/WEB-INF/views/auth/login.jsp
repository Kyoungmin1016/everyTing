<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<script>
		var msg = '${msg}';
		if(msg != ''){
			alert(msg);
		}
	</script>
	<jsp:include page="/WEB-INF/views/common/auth_header.jsp" flush="false"></jsp:include>
	<div style="display:flex; justify-content:center; align-items: center;">
		<div class="col-lg-4">	
			<div style="padding-top: 20px; text-align: center;">
				<form name=form1 action="http://localhost:8080/free/auth/login" method="post">
					<div class="mb-3">
					  <label for="formGroupExampleInput" class="form-label">카카오톡 ID</label>
					  <input type="text" placeholder="id" class="form-control" id="formGroupExampleInput" name="id" maxlength="20" placeholder="Example input placeholder">
					</div>
					<div class="mb-3">
					  <label for="formGroupExampleInput2" class="form-label">PASSWORD</label>
					  <input type="password" placeholder="password" name="passwd" maxlength="20" class="form-control" id="formGroupExampleInput2" placeholder="Another input placeholder">
					</div>
					<input type="submit" class="btn btn-white" value="로그인" style="float:left; background-color:pink;color:white;">
				</form>
				<form name=form2 action="http://localhost:8080/free/auth/register">
					<input type="submit" class="btn btn-light" value="회원가입" style="float:right;">
				</form>
			</div>
		</div>
	</div>
</body>
</html>