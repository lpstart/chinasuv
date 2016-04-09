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
					<h2 class="page-header" style="margin: 5px;">分配菜单</h2>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<form role="form" action="manage/menuAllocate_do.jdo" method="post">
				<input type="hidden" value="${role_id }" name="role_id">
				<c:forEach items="${menus }" var="menu">
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<label class="checkbox-inline"> <input type="checkbox" name="menu"
										value="${menu.id }" class="parentMenu" id="menu_check${menu.id }">
										${menu.menuremark }
									</label>
								</div>
								<div class="panel-body">
									<div class="col-lg-6">
										<div class="form-group">
											<div class="form-group">
												<c:forEach items="${menu.childMenu }" var="submenu">
													<label class="checkbox-inline"> <input type="checkbox" name="menu"
														value="${submenu.id }" class="subMenu${menu.id }"
														id="menu_check${submenu.id }"> ${submenu.menuremark }
													</label>
												</c:forEach>
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
				</c:forEach>
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
		var url = "manage/getSelfMenuWithSubMenu.jdo";
		var args = {
			"id" : "${role_id }",
			"contentType" : "application/json; charset=utf-8",
			"dataType" : "json"
		}
		$.post(url, args, function(data) {
			for (var i = 0; i < data.length; i++) {
				$('#menu_check' + data[i].id).attr('checked', 'checked');
				for (var j = 0; j < data[i]['childMenu'].length; j++) {
					var tempId = data[i]['childMenu'][j].id;
					$('#menu_check' + tempId).attr('checked', 'checked');
				}
			}
			$.each($('.parentMenu'), function(n, value) {
				if (!value.checked) {
					$('.subMenu' + value.value).attr('disabled', true);
				}
				$(this).click(
						function() {
							$('.subMenu' + value.value).attr('checked', false);
							$('.subMenu' + value.value).attr(
									'disabled',
									!$('.subMenu' + value.value).attr(
											'disabled'));

						})
			});
		});

	});
</script>


</html>
