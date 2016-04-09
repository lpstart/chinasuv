<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../commonHead.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<base href="${basePath }">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap Core CSS -->
<link href="resources/back/bower_components/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="resources/back/bower_components/metisMenu/dist/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/back/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="resources/back/bower_components/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
.form-control {
	width: 70%;
}

.panel-default {
	width: 70%;
}
</style>
</head>

<body>
	<div id="wrapper">
		<div id="page-wrapper" style="margin: 0px">
			<div class="row">
				<div class="col-lg-8">
					<h2 class="page-header" style="margin: 5px;">分配角色</h2>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<form role="form" action="manage/roleAllocate_do.jdo" method="post">
				<input type="hidden" value="${user_id }" name="user_id">
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>角色名</th>
								<th>角色描述</th>
								<th style="width: 50px;"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${roles }" var="temp">
								<tr>
									<td>${temp.id }</td>
									<td>${temp.roleremark }</td>
									<td>${temp.roledescription }</td>
									<td><input type="checkbox" name="role" value="${temp.id }" class="role"
										id="role${temp.id }"></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<button type="submit" class="btn btn-default">添加</button>
				<button type="reset" class="btn btn-default">重置</button>
			</form>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="resources/back/bower_components/jquery/dist/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/back/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="resources/back/bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="resources/back/dist/js/sb-admin-2.js"></script>
</body>
<script type="text/javascript">
	$(function() {
		var url = "manage/getselfrole.jdo";
		var args = {
			"id" : "${user_id }",
			"contentType" : "application/json; charset=utf-8",
			"dataType" : "json"
		}
		$.post(url, args, function(data) {
			for (var i = 0; i < data.length; i++) {
				$('#role' + data[i].id).attr('checked', 'checked');
			}
		});

	});
</script>


</html>
