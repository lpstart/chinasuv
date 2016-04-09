<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../commonHead.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="${basePath }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/datatables/bootstrap/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="resources/datatables/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/datatables/css/dataTables.bootstrap.min.css">


<link rel="stylesheet" type="text/css" href="resources/stylesheets/theme.css">
<link rel="stylesheet" href="resources/lib/font-awesome/css/font-awesome.css">



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/datatables/bootstrap/jquery-1.11.3.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/datatables/bootstrap/js/bootstrap.min.js"></script>

<script src="resources/datatables/js/jquery.dataTables.min.js"></script>
<script src="resources/datatables/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
	function locationText(thisObj, localCode) {
		var text = getLocalText(localCode);
		document.write(text);
	}

	function getLocalText(code) {
		if (code.length <= 2) {
			if (code == 'SL') {
				return "头部滚动文章";
			} else if (code == 'LB') {
				return "轮播";
			} else if (code == 'TF') {
				return "今日焦点";
			} else if (code == 'RT') {
				return "视频推荐";
			} else if (code == 'PC') {
				return "评测中心";
			} else if (code == 'GC') {
				return "购车";
			} else if (code == 'TK') {
				return "精彩图库";
			} else if (code == 'YG') {
				return "预告";
			} else if (code == 'ZT') {
				return "专题推荐";
			}
		} else {
			if (code.substr(0, 4) == 'RD24') {
				return "24小时阅读";
			} else if (code.substr(0, 3) == 'RRD') {
				return "推荐阅读";
			}
		}
	}
</script>
<body>
	<h2 class="page-title">&nbsp; 文章列表</h2>
	<div class="well">
		<form method="post" action="manage/home/list.jhtml" class="form-inline">
			<span>选择位置：</span> <select class="form-control input-sm" name="location"
				id="location">
				<option <c:if test="${param.location == '' }">selected="selected"</c:if> value="">全部</option>
				<option <c:if test="${param.location == 'SL' }">selected="selected"</c:if> value="SL">滚动文章</option>
				<option <c:if test="${param.location == 'LB' }">selected="selected"</c:if> value="LB">轮播</option>
				<option <c:if test="${param.location == 'RD24' }">selected="selected"</c:if>
					value="RD24">24小时阅读</option>
				<option <c:if test="${param.location == 'TF' }">selected="selected"</c:if> value="TF">今日焦点</option>
				<option <c:if test="${param.location == 'RRD' }">selected="selected"</c:if>
					value="RRD">推荐阅读</option>

				<option <c:if test="${param.location == 'RT' }">selected="selected"</c:if> value="RT">视频推荐</option>

				<option <c:if test="${param.location == 'PC' }">selected="selected"</c:if> value="PC">评测中心</option>
				<option <c:if test="${param.location == 'GC' }">selected="selected"</c:if> value="GC">购车</option>
				<option <c:if test="${param.location == 'TK' }">selected="selected"</c:if> value="TK">精彩图库</option>
				<option <c:if test="${param.location == 'ZT' }">selected="selected"</c:if> value="ZT">专题推荐</option>

				<option <c:if test="${param.location == 'YG' }">selected="selected"</c:if> value="YG">预告</option>
			</select> <input class="btn btn-primary" type="submit" value="查询">
		</form>
		<table id="homeTable" class="table table-striped table-bordered" data-page-length='10'>
			<thead>
				<th><b>#</b></th>
				<th><b>位置</b></th>
				<th><b>显示标题</b></th>
				<th><b>图片</b></th>
				<th><b>调转地址</b></th>
				<th><b>栏目名称</b></th>
				<th style='width: 26px;'></th>
			</thead>
			<tbody>
				<c:forEach items="${homeData}" var="hdata">
					<tr>
						<td>${hdata.id}</td>
						<td><script type="text/javascript">
							locationText(this, '${hdata.location }')
						</script></td>
						<td>${hdata.title }</td>
						<td><c:if test="${hdata.picPath != null }">${picHost}${hdata.picPath}</c:if></td>
						<td>${hdata.goUrl}</td>
						<td>${hdata.itemName}</td>
						<td><a href='manage/home/edit.jhtml?id=${hdata.id}'> <i class='icon-pencil'></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#homeTable').DataTable();
	})
</script>



</html>