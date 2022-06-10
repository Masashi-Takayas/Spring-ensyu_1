<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/commons.css">
<meta charset="UTF-8">
<link href="css/commons.css" rel="stylesheet">
<title>登録完了</title>
</head>
<body>
  <h2>登録が完了しました</h2>
  <br>
  <a href="top"><fmt:message key="btn.back" /></a>
</body>
