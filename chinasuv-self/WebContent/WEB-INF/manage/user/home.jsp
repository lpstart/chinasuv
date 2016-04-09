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


<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7"> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8"> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->

<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7"> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8"> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span9">
				<h2 class="page-title">所有的用户</h2>
				<div class="btn-toolbar">
					<a href="manage/addUser.jdo">
						<button class="btn btn-primary">
							<i class="icon-plus"></i>
							新建用户
						</button>
					</a>
				</div>
				<div class="well">
					<table id="articleTable" class="table table-striped table-bordered"
						data-page-length='10' width="98%">
						<thead>
							<tr>
								<th>#</th>
								<th>用户名</th>
								<th>用户email</th>
								<th>用户性别</th>
								<th>用户联系方式</th>
								<th>用户描述</th>
								<th>分配角色</th>
								<th style="width: 15px;"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ allUser }" var="temp">
								<tr>
									<td>${temp.id }</td>
									<td>${temp.username}</td>
									<td>${temp.email }</td>
									<td>
										<c:if test="${temp.gender=='woman' }">女</c:if>
										<c:if test="${temp.gender=='man' }">男</c:if>
									</td>
									<td>${temp.phonenumber }</td>
									<td>${temp.description }</td>
									<td>
										<a href="manage/roleAllocate.jdo?id=${temp.id }">分配角色</a>
									</td>
									<td>
										<a class="editMenu" href="manage/editUser.jdo?id=${temp.id }">
											<i class="icon-pencil"></i>
										</a>
										<a href="manage/deleteUser_do.jdo?id=${temp.id }" role="button"
											data-toggle="modal">
											<i class="icon-remove"></i>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="myModalLabel">确认删除</h3>
					</div>
					<div class="modal-body">
						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>
							你真的要删除么？
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-danger" data-dismiss="modal">确认</button>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/datatables/bootstrap/jquery-1.11.3.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/datatables/bootstrap/js/bootstrap.min.js"></script>

<script src="resources/datatables/js/jquery.dataTables.min.js"></script>
<script src="resources/datatables/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#articleTable').DataTable();
	})
</script>



</html>