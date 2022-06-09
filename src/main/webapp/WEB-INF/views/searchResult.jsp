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
<title>検索結果</title>
</head>
<body>
	<h2>検索結果</h2>

	<table border="1">

		<tr>
			<th width="160"><fmt:message key="lbl.ranking.name" /></th>
			<th width="80"><fmt:message key="lbl.score" /></th>
		</tr>

		<c:forEach var="ranking" items="${rankingList}">
			<tr>
				<td>${fn:escapeXml(ranking.name)}</td>
				<td>${fn:escapeXml(ranking.score)}</td>
			</tr>
		</c:forEach>
	</table>

	<a href="delete"><fmt:message key="btn.delete" /></a>
	<br>
	<a href="top"><fmt:message key="btn.back" /></a>

</body>