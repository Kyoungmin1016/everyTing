<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>board_read</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/common/board_header.jsp" flush="false"></jsp:include>
		<div>
			<div>
				<table class="table table-hover">
					<thead>
						<tr><th colspan="2" style="background-color: #eeeeee; text-align: center;">게시글</th></tr>
					</thead>
					<tbody>
						<tr><td><c:out value="${board.title}"/></td></tr>
					    <tr><td><c:out value="${board.content}"/></td></tr>
					</tbody>
				</table>
				<form name=form4 action="http://localhost:8080/free/board/apply/${board.num }" method="post">
					<input class="btn btn-white" type="submit" value="신청" style="background-color:pink;color:white;margin-left:10px">
				</form>
			</div>
		</div>
	</body>
</html>