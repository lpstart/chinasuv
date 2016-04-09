<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专题 /专题汇总_中国SUV网</title>
<link href="${basePath }css/style.css" rel="stylesheet" type="text/css" />
<link href="${basePath }css/text.css" rel="stylesheet" type="text/css" />
<link href="${basePath }css/qcss.css" rel="stylesheet" type="text/css" />

<div id="containers">

<%@ include file="common/header.jsp"%>
<div id="text-wraps">
	<!--专题汇总开始-->
	<div id="qzthz">
		<img id="qzthztu" src="${basePath }img/zthz.jpg" border="0px">
	  	<div id="qxian"></div>
		<!--内容开始-->
	  	<div id="qzthznr">
		  	<ul>
		  		<c:forEach var="ts" varStatus="status" items="${topics }">
					<li>
						<a href="${basePath }topic/details/${ts.id}.html" class="preview">
							<img src="${picHost }${ts.picPath }">
						</a>
						<p id="qzthzzi"><a href="${basePath }topic/details/${ts.id}.html">${ts.title }</a></p>
					</li>
				</c:forEach>
		  	</ul>
			<div class="chkart" style="clear:both"></div>  
		</div>
	<!--内容结束-->
	
	</div>
	<!--专题汇总结束-->
	<div class="chkart" style="clear:both"></div>			
</div>

<%@ include file="common/footer.jsp"%>
</div>