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

<!-- 搞定封面上传的引入 -->
<link rel="stylesheet" type="text/css"
	href="resources/ueditor/js/third-party/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css" href="resources/diyUpload/css/diyUpload.css">

<style type="text/css">
* {
	padding: 0;
}

.webuploader-pick {
	width: 50%;
}

.parentFileBox {
	margin-left: 22%;
}
</style>
<body>
	<div id="wrapper">
		<div id="page-wrapper" style="margin: 0px">
			<div class="row">
				<div class="col-lg-8">
					<h2 class="page-header" style="margin: 5px;">编辑菜单</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-7">
					<div class="panel panel-default">
						<form role="form" action="manage/home/edit.jdo" method="post"
							class="form-horizontal" style="margin: 10px">
							<input type="hidden" value="${home.id }" name="id"> <input type="hidden"
								value="${home.itemId }" name="itemId">
							<table style="width: 100%">
								<tr>
									<td style="width: 50%">
										<div class="control-group">
											<label>位置：</label> <input class="form-control" id="disabledInput" type="text"
												readonly="readonly" name="location" value="${home.location }">
										</div>

										<div class="control-group">
											<label for="disabledSelect">首页标题</label> <input class="form-control"
												value="${home.title }" name="title">
										</div>

										<div class="control-group">
											<label for="disabledSelect">调转地址</label> <input class="form-control"
												value="${home.goUrl }" name="goUrl">
										</div>

										<div class="control-group">
											<label>排序：</label> <input class="form-control" value="${home.sort }"
												name="sort"> <span style="color: red">数字越大位置越靠前</span>
										</div>
									</td>
									<td>
										<div id="box" style="height: 100%; width: 100%; text-align: center;">
											<c:if test="${not empty home.picPath }">
												<div style="width: 180px;" class="parentFileBox">
													<ul class="fileBoxUl">
														<li id="fileBox_WU_FILE_0" class="">
															<div class="viewThumb">
																<img src="${home.picPath }">
															</div>
															<div style="display: block;" class="diySuccess"></div>
														</li>
													</ul>
												</div>
												<div id="imgUpload"></div>
												<div class="webuploader-container" id="reselectCoverPic"
													style="display: inline; width: 50%" onclick="clearImage()">
													<div class="webuploader-pick" style="margin-left: 10%;">重新选择封面</div>
												</div>
											</c:if>

											<c:if test="${ empty home.picPath }">
												<div id="imgUpload"></div>
												<div class="webuploader-container" id="reselectCoverPic"
													style="display: none; width: 50%" onclick="clearImage()">
													<div class="webuploader-pick" style="margin-left: 10%;">重新选择封面</div>
												</div>
											</c:if>
										</div> <input type="hidden" name="picId" id="coverPicId" value="${home.picId }" /> <input
										type="hidden" name="picPath" id="coverPicPath" value="${home.picPath }" />
									</td>

								</tr>
								<tr>
									<td>
										<button type="reset" class="btn btn-default">重置</button>
										<button type="submit" class="btn btn-primary">修改</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="resources/back/bower_components/jquery/dist/jquery.min.js"></script>

	<script src="resources/back/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

	<script src="resources/back/bower_components/metisMenu/dist/metisMenu.min.js"></script>

	<script src="resources/back/dist/js/sb-admin-2.js"></script>

	<script type="text/javascript"
		src="resources/ueditor/js/third-party/webuploader/webuploader.html5only.js"></script>
	<script type="text/javascript"
		src="resources/ueditor/js/third-party/webuploader/diyUploadCustom.js"></script>

	<script type="text/javascript">
		function clearImage() {
			$('#box')
					.html(
							'<div id="imgUpload"></div><div class="webuploader-container" id="reselectCoverPic" style="display: none;width:50%" onclick="clearImage()"><div class="webuploader-pick"  style="margin-left: 10%;">重新选择封面</div></div>');
			/*
			 * 服务器地址,成功返回,失败返回参数格式依照jquery.ajax习惯;
			 * 其他参数同WebUploader
			 */
			$('#imgUpload').diyUpload({
				url : 'manage/uploadImg.jdo',
				success : function(data) {
					console.info(data);
					var d = eval(data);
					$("#reselectCoverPic").css("display", "inline");
					$("#imgUpload").css("display", "none");
					if ("success" == d.success) {//上传成功,更新content value
						$("#coverPicPath").val(d.picPath);
						$("#coverPicId").val(d.id);
					}
				},
				error : function(err) {
					console.info(err);
				}
			});
			deleteUploadImg();

		}
		function deleteUploadImg() {
			var coverPicPath = $("#coverPicPath").val();
			var coverPicId = $("#coverPicId").val();
			$.ajax({
				type : "POST",
				url : "manage/deleteImg.jdo",
				data : "picId=" + coverPicId + "&picPath=" + coverPicPath,
				dataType : "JSON",
				timeout : 5000,
				beforeSend : function() {
				},
				async : true,
				success : function(responseJson) {
				},
				error : function() {
				},
				complete : function() {
				}
			});
		}
		$(document).ready(function() {
			var temp = "${home.picPath}";
			if (temp.length<=0) {
				/*
				 * 服务器地址,成功返回,失败返回参数格式依照jquery.ajax习惯;
				 * 其他参数同WebUploader
				 */
				$('#imgUpload').diyUpload({
					url : 'manage/uploadImg.jdo',
					success : function(data) {
						console.info(data);
						var d = eval(data);
						$("#reselectCoverPic").css("display", "inline");
						$("#imgUpload").css("display", "none");
						if ("success" == d.success) {//上传成功,更新content value
							$("#coverPicPath").val(d.picPath);
							$("#coverPicId").val(d.id);
						}
					},
					error : function(err) {
						console.info(err);
					}
				});
			}
		})
	</script>

</body>
</html>
