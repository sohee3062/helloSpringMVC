<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
table {
	width: 50%;
	border: 1px solid #444444;
	border-collapse: collapse;
	text-align:center;
}

th, td {
	border: 1px solid #444444;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>년도</th>
				<th>학기</th>
				<th>이수 학점</th>
				<th>상세보기</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="offer" items="${offers}">
				<tr>
					<td><c:out value="${offer.year}"></c:out></td>
					<td><c:out value="${offer.semester}"></c:out></td>
					<td><c:out value="${offer.creditSum}"></c:out></td>
					<td><a
						href="<c:url value="searchSubject">
						<c:param name="year" value="${offer.year}"></c:param><c:param name="semester" value="${offer.semester}"></c:param>
					</c:url>
					">링크
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/menu"> 메뉴로 돌아가기</a>
</body>
</html>