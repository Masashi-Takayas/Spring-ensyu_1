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
<title>トップ</title>
</head>
<body>
	<h2>ランキングに名前を登録してください</h2>
  <c:if test="${not empty name}">
    <p>プレイヤー：${name}</p>
   </c:if>
  <form:form action="execute" modelAttribute="ranking" method="post">
    <fmt:message key="lbl.ranking.name" />
    <fmt:message key="lbl.separator" />
    <form:input path="name" />
    <c:if test="${empty msg}">
      <form:errors path="name" cssStyle="color: red" />
    </c:if>
    <br>
    <fmt:message key="lbl.score" />
    <fmt:message key="lbl.separator" />
    <form:input path="score" />
    <c:if test="${empty msg}">
      <form:errors path="score" cssStyle="color: red" />
    </c:if>
    <br>
    <form:button name="search">
      <fmt:message key="btn.search" />
    </form:button>
    
    <form:button name="insert">
      <fmt:message key="btn.insert" />
    </form:button>
    
    <form:button name="play">
      <fmt:message key="btn.play" />
    </form:button>
    
  </form:form>
</body>