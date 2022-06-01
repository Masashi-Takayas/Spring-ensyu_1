<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ</title>
</head>
<body>
  <h2>検索条件を入力してください</h2>
  <c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
  <form:form action="search" modelAttribute="product" method="post">
    product_id: <form:input path="productId" />
    <br>
    <form:button name="search">検索</form:button>
  </form:form>
</body>
