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
					<h2 class="page-header" style="margin: 5px;">添加菜单</h2>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-8">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-6">
									<form role="form" action="manage/addMenu_do.jdo" method="post">
										<div class="form-group">
											<label>菜单名：</label>
											<input class="form-control" placeholder="菜单名" name="menuremark">
											<p class="help-block">用于命名这个菜单。</p>
										</div>
										<div class="form-group">
											<label>管理页面地址：</label>
											<input class="form-control" placeholder="输入url" name="location">
											<p class="help-block">通过这个页面来实现这个菜单的功能。</p>
										</div>
										<div class="form-group">
											<label>选择父菜单</label>
											<select class="form-control" id="fatherMenuSelect" name="parent_id">
												<option value="0">0</option>
												<c:forEach items="${allTopMenu}" var="topMenuTemp">
													<option value="${topMenuTemp.id}">${topMenuTemp.menuremark}</option>
												</c:forEach>
											</select>
										</div>
										<br /> <br />
										<button type="submit" class="btn btn-default">添加</button>
										<button type="reset" class="btn btn-default">重置</button>
									</form>
								</div>
							</div>
							<!-- /.row (nested) -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
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
</html>
