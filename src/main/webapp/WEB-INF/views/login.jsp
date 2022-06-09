<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<h2>ログインしてください</h2>

	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>

	<form:form action="execute" modelAttribute="login" method="post">

		<fmt:message key="lbl.login_id" />
		<fmt:message key="lbl.separator" />
		<form:input path="login_id" />

		<c:if test="${empty msg}">
			<form:errors path="login_id" cssStyle="color: red" />
		</c:if>

		<br>
		<fmt:message key="lbl.password" />
		<fmt:message key="lbl.separator" />
		<form:input path="password" />

		<c:if test="${empty msg}">
			<form:errors path="password" cssStyle="color: red" />
		</c:if>

		<br>

		<form:button name="login">
			<fmt:message key="btn.play" />
		</form:button>

	</form:form>
</body>