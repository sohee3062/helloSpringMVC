<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post"
		action="${pageContext.request.contextPath}/docreate">
		<table>
			<tr>
				<td>교과코드:</td>
				<td><input type="text" name="code" /></td>
			</tr>
			<tr>
				<td>교과목명:</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>구분:</td>
				<td><input type="text" name="division" /></td>
			</tr>
			<tr>
				<td>학점:</td>
				<td><input type="text" name="credit" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="등록" /></td>
			</tr>
			<input name="${_csrf.parameterName }" type="hidden"
				value="${_csrf.token}" />
		</table>
	</form>
</body>
</html>