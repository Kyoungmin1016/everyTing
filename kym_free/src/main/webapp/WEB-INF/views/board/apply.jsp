<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>board</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
	<jsp:include page="/WEB-INF/views/common/board_header.jsp" flush="false"></jsp:include>
		<div>
			<table class="table table-hover">
			  <tr>
			    <th>제목</th><th>신청자</th>
			  </tr>
			  <c:forEach var="apply" items="${applys}" >
				  <tr>
				    <td><c:out value="${apply.title}"/></td>
				    <td><c:out value="${apply.other}"/></td>
				  </tr>
			  </c:forEach>
			</table>
		</div>
	</body>
</html>