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
					<h2 class="page-header" style="margin: 5px;">编辑用户</h2>
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
									<form role="form" action="manage/editUser_do.jdo" method="post">
										<input type="hidden" value="${user.id }" name="id">
										<label>用户名：</label>
										<div class="input-group">
											<span class="input-group-addon" id="basic-addon1" style="color: red">*</span>
											<input class="form-control" placeholder="用户名" name="username" type="text"
												style="width: 70%" aria-describedby="basic-addon1" value="${user.username }">
										</div>
										<label>邮箱：</label>
										<div class="input-group">
											<span class="input-group-addon" id="basic-addon1" style="color: red">*</span>
											<input class="form-control" placeholder="E-mail" name="email"
												style="width: 70%" aria-describedby="basic-addon1" value="${user.email }"
												type="email" readonly="readonly">
										</div>
										<label>密码：</label>
										<div class="input-group">
											<span class="input-group-addon" id="basic-addon1" style="color: red">*</span>
											<input class="form-control" placeholder="Password" name="password"
												type="password" value="${user.password}" style="width: 70%"
												aria-describedby="basic-addon1">
										</div>
										<div class="form-group">
											<label>性别：</label>
											<div class="radio-inline">
												<label>
													<input type="radio" name="gender" id="optionsRadios1" value="woman">
													女
												</label>
											</div>
											<div class="radio-inline">
												<label>
													<input type="radio" name="gender" id="optionsRadios2" value="man" checked>
													男
												</label>
											</div>
										</div>
										<div class="form-group">
											<label>联系方式：</label>
											<input class="form-control" placeholder="电话号码.." name="phonenumber"
												value="${user.phonenumber }">
										</div>
										<div class="form-group">
											<label>用户描述：</label>
											<input class="form-control" placeholder="描述.." name="description"
												value="${user.description }">
											<p class="help-block">描述这个用户。</p>
										</div>
										<br /> <br />
										<button type="submit" class="btn btn-default">修改</button>
										<button type="reset" class="btn btn-default">重置</button>
									</form>
								</div>
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
	<script type="text/javascript">
		if ("${user.gender}" == 'woman') {
			$("#optionsRadios1").attr("checked", "checked");
		} else {
			$("#optionsRadios2").attr("checked", "checked");
		}
	</script>
</body>
</html>
