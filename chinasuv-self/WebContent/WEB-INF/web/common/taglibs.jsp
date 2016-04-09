<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="basePath" value="<%=basePath %>"></c:set>
<base href="${basePath }">
<script src="${basePath }js/jquery-1.12.2.min.js"></script> 
<script src="${basePath }js/base.js"></script>
