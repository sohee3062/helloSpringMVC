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
	text-align: center
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
				<th>교과코드</th>
				<th>교과목명</th>
				<th>구분</th>
				<th>학점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="offer" items="${offers}">
				<tr>
					<td><c:out value="${offer.code}"></c:out></td>
					<td><c:out value="${offer.title}"></c:out></td>
					<td><c:out value="${offer.division}"></c:out></td>
					<td><c:out value="${offer.credit}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>

</html>