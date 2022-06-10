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
<title>削除</title>
</head>
<body>
	<form:form action="execute" modelAttribute="ranking" method="post">

    <fmt:message key="lbl.ranking.name" />
    <fmt:message key="lbl.separator" />
    <form:input path="name" />

    <br>
    <c:if test="${empty msg}">
      <form:errors path="name" cssStyle="color: red" />
    </c:if>
    
    <form:button name="deleteResult">
      <fmt:message key="btn.delete" />
    </form:button>
    
  </form:form>
</body>