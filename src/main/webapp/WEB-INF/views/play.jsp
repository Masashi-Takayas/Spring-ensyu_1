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
        <script src="common.js"></script>
        <script src="main.js"></script>
        <style>canvas {border: 1px solid gray;}</style>
<title>プレイ</title>
</head>
<body>
	<h2>シューティング</h2>
	        <canvas id="screen"></canvas>
        <p id="info"></p>
</body>