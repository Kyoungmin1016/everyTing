<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Register</title>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/common/auth_header.jsp" flush="false"></jsp:include>
			<div style="padding-top: 20px; text-align: center;">
				<h3>JOIN US</h3>
				<form class="form-floating" action="http://localhost:8080/free/auth/register" method="post">
					<div class="form-floating">
					  <input type="text" class="form-control" name="id" id="floatingInputValue" placeholder="kakao ID" value="kakao ID@example.com">
					  <label for="floatingInputValue">Input kakao ID</label>
					</div>
					<div class="form-floating">
						<input type="password" class="form-control" id="floatingInputValue" placeholder="password" name="passwd">
						<label for="floatingInputValue">Input Password</label>
					</div>
					<div class="form-floating">
						<input type="text" class="form-control" id="floatingInputValue" placeholder="username" name="username" maxlength="20">
						<label for="floatingInputValue">Input Username</label>
					</div>
					<div class="form-floating">
					  <select name="major" class="form-select" id="floatingSelect" aria-label="Floating label select example">
					    <option selected>Open this select major</option>
					    <option value="컴퓨터공학과">컴퓨터공학과</option>
					    <option value="소프트웨어공학과">소프트웨어공학과</option>
					    <option value="IT경영">IT경영</option>
					    <option value="메카트로닉">메카트로닉</option>
					    <option value="산업경영">산업경영</option>
					    <option value="인공지능">인공지능</option>
					    <option value="게임공학과">게임공학과</option>
					    <option value="나노반도체">나노반도체</option>
					  </select>
					  <label for="floatingSelect">major</label>
					</div>
					<div class="form-floating">
						<input type="text" class="form-control" id="floatingInputValue" placeholder="age" name="age" maxlength="20">
						<label for="floatingInputValue">Input age</label>
					</div>
					<div class="form-floating">
					  <select name="sex" class="form-select" id="floatingSelect" aria-label="Floating label select example">
					    <option selected>Open this select sex</option>
					    <option value="man">man</option>
					    <option value="woman">woman</option>
					  </select>
					  <label for="floatingSelect">sex</label>
					</div>
					
					<input type="submit" class="btn btn-white" value="가입" style="margin-top : 30px;background-color:pink;color:white">
				</form>
			</div>	
	</body>
</html>