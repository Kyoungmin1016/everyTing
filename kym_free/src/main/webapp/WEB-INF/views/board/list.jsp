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
		<script>
		var msg = '${msg}';
		if(msg != ''){
			alert(msg);
		}
		</script>
		
		<table class="table table-hover">
		  <tr>
		    <th>Title</th><th>USERNAME</th><th>MAJOR</th><th>SEX</th><th>DATE</th><th></th>
		  </tr>
		  <c:forEach var="notice_board" items="${notice_boards}" >
			  <tr>
			    <td  style="cursor: pointer;" onClick = "location.href='/free/board/content?num=${notice_board.num}'"><c:out value="${notice_board.title}"/></td>
			    <td><c:out value="${notice_board.username}"/></td>
			    <td><c:out value="${notice_board.major}"/></td>
			    <td><c:out value="${notice_board.sex}"/></td>
			    <td><c:out value="${notice_board.date}"/></td>
				    <td>
				    <c:if test="${notice_board.id eq id}">
				      <c:url value="/board/delete?num=${notice_board.num}" var="url"/><a href="${url}" class="btn btn-danger">글 삭제</a>
				      <c:url value="/board/modify?num=${notice_board.num}" var="url"/><a href="${url}" class="btn btn-light">글 수정</a>   
				      </c:if>  
				    </td>
			  </tr>
		  </c:forEach>
		</table>
		<c:url value="/board/register" var="url"/><a class="btn btn-primary" href="${url}" style="margin-right : 20px; float:right;">글 생성</a>
	</body>
</html>