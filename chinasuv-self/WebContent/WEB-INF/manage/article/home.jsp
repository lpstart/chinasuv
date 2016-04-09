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
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7"> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8"> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body>
	<h2 class="page-title">&nbsp; 文章列表</h2>
	<div class="btn-toolbar">
		<a href="manage/addArticle.jdo">
			<button class="btn btn-primary">
				<i class="icon-plus"></i> 添加新文章
			</button>
		</a>
	</div>
	<div class="well">
		<form method="post" action="manage/getArticle.jdo" class="form-inline">
			<label> 选择一级分类:</label> <select name="item" id="itemId" class="form-control input-sm">
				<c:forEach items="${items}" var="temp">
					<option value="${temp.id}">${temp.itemName}</option>
				</c:forEach>
			</select> <label class="form-label"> 选择二级分类:</label> <select name="subItem" id="subItemId"
				class="form-control input-sm">
				<c:forEach items="${subItems}" var="temp">
					<option value="${temp.id}">${temp.itemName}</option>
				</c:forEach>
			</select> <input type="submit" class="btn btn-primary" value="查询">
		</form>
		<table id="articleTable" class="table table-striped table-bordered"
			data-page-length='10'>
			<thead>
				<th><b>#</b></th>
				<th><b>题目</b></th>
				<th><b>摘要</b></th>
				<th><b>创建时间</b></th>
				<th><b>更新时间</b></th>
				<th><b>状态</b></th>
				<th style='width: 26px;'></th>
			</thead>
			<tbody>
				<c:forEach items="${articles}" var="temp">
					<tr>
						<td>${temp.id}</td>
						<td>${temp.title}</td>
						<td>${temp.summary }</td>
						<td>${temp.createTime}</td>
						<td>${temp.upTime}</td>
						<td><c:choose>
								<c:when test="${temp.status==0 }">正常</c:when>
								<c:when test="${temp.status==1 }">删除</c:when>
							</c:choose></td>
						<td><a href='manage/editArticle.jdo?id=${temp.id}'> <i class='icon-pencil'></i>
						</a> <a href='manage/deleteArticle_do.jdo?id=${temp.id}' role='button'
							data-toggle='modal'> <i class='icon-remove'></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#articleTable').DataTable();
		$("#itemId").change(function() {
			selectedItemId($(this).val());
		});

	})
	function selectedItemId(itemId) {
		$.ajax({
			type : "POST",
			url : "manage/getSubItems.jdo",
			data : "itemId=" + itemId,
			dataType : "JSON",
			timeout : 5000,
			beforeSend : function() {
			},
			async : true,
			success : function(responseJson) {
				if (responseJson.length == 0) {

				} else {
					var item = "";
					for (i = 0; i < responseJson.length; i++) {
						item = item + "<option value="+responseJson[i].id+">"
								+ responseJson[i].itemName + "</option>"
					}
					$("#subItemId").html(item);
				}
				;

			},
			error : function() {
			},
			complete : function() {
			}
		});
	}
</script>



</html>