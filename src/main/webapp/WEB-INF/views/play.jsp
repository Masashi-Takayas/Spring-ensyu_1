<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/commons.css">
<title>プレイ</title>
<link href="css/commons.css" rel="stylesheet">
</head>

<style>
canvas {
	border: 5px solid gray;
}
</style>
<body>

	<h2>シューティング</h2>
	<canvas id="screen"></canvas>

	<script src="js/commons.js"></script>
	<script src="js/character.js"></script>
	<script src="js/main.js"></script>
	
</body>