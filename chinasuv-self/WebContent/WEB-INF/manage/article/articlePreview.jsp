<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commonHead.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章编辑后预览</title>
<base href="${basePath }">
</head>
<body>
	<h1>文章预览：</h1>
	<h2>封面</h2>
	<img alt="封面" src="${article.picPath }">
	<h2>正文</h2>
	<c:import url="${article.content }"></c:import>
</html>