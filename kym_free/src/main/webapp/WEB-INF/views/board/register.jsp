<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>board_register</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/common/board_header.jsp" flush="false"></jsp:include>
		<div>
			<h3>글쓰기</h3>
			<form name=form3 action="http://localhost:8080/free/board/register" method="post">
				<div class="form-floating">
				  <textarea class="form-control" placeholder="Leave a Title here" id="floatingTextarea2" name="title" style="height: 60px"></textarea>
				  <label for="floatingTextarea2">Title</label>
				</div>
				<div class="form-floating">
				  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" name="content" style="height: 300px"></textarea>
				  <label for="floatingTextarea2">Content</label>
				</div>
				<input type="submit" class="btn btn-primary" value="글 등록" style="float:right; margin:20px">
			</form>
		</div>
	</body>
</html>