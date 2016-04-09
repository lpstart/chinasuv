<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../commonHead.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${basePath }">
<title>添加文章</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<script type="text/javascript" charset="utf-8"
	src="resources/ueditor/js/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="resources/ueditor/js/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8"
	src="resources/ueditor/js/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="resources/datatables/bootstrap/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/datatables/bootstrap/js/bootstrap.min.js"></script>


<!-- 搞定封面上传的引入 -->
<link rel="stylesheet" type="text/css"
	href="resources/ueditor/js/third-party/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css" href="resources/diyUpload/css/diyUpload.css">
<link href="resources/datatables/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"
	src="resources/ueditor/js/third-party/webuploader/webuploader.html5only.js"></script>
<script type="text/javascript"
	src="resources/ueditor/js/third-party/webuploader/diyUploadCustom.js"></script>

<style type="text/css">
div {
	width: 90%;
}

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
</head>
<body>
	<div style="margin: 0 0 0 30px;">
		<h3>添加文章</h3>
		<form action="manage/addArticle_do.jdo" method="post" class="form-horizontal">
			<table>
				<tr>
					<td style="border: 0; width: 400px; height: 250px;">
						<div id="box" style="height: 100%; width: 100%; text-align: center;">
							<div id="imgUpload"></div>
							<div class="webuploader-container" id="reselectCoverPic"
								style="display: none; width: 50%" onclick="clearImage()">
								<div class="webuploader-pick" style="margin-right: 10%;">重新选择封面</div>
							</div>
						</div>
						<input type="hidden" name="picId" id="coverPicId" />
						<input type="hidden" name="picPath" id="coverPicPath" />
					</td>
					<td>
						<div style="height: 100%; width: 100%;" class="control-group ">
							标题：
							<input class="span2" id="prependedInput" type="text" name="title"
								style="margin-bottom: 5px">
							&nbsp; &nbsp;来&nbsp; &nbsp;源：
							<input class="span2" id="prependedInput" type="text" name="resource"
								style="margin-bottom: 5px">
							<br />作者：
							<input type="text" name="author" class="span2" style="margin-bottom: 5px" />
							责任编辑：
							<input type="text" name="editor" class="span2" style="margin-bottom: 5px" />
							<br /> 所属一级板块：
							<select name="topItem" id="itemId" class="form-control input-sm" style="width: 47%"
								style="margin:0 0 5px 0">
								<c:forEach items="${items}" var="temp">
									<option value="${temp.id}">${temp.itemName}</option>
								</c:forEach>
							</select>
							所属二级板块：
							<select name="subItem" id="subItemId" style="width: 47%"
								class="form-control input-sm" style="margin:0 0 5px 0">
								<c:forEach items="${subItems}" var="temp">
									<option value="${temp.id}">${temp.itemName}</option>
								</c:forEach>
							</select>
							摘要：<br />
							<textarea rows="2" cols="40" name="summary"></textarea>
						</div>
					</td>
				</tr>
			</table>
			<br />
			<textarea name="content" id="editor" style="width: 90%">输入文章</textarea>
			<script type="text/javascript">
				var editor = new UE.ui.Editor();
				editor.render("editor");
			</script>
			<input type="submit" value="提交" class="btn btn-primary" />
		</form>
	</div>
	<script type="text/javascript">
		function clearImage() {
			$('#box')
					.html(
							'<div id="imgUpload"></div><div class="webuploader-container" id="reselectCoverPic" style="display: none;width:50%" onclick="clearImage()"><div class="webuploader-pick"  style="margin-right: 10%;">重新选择封面</div></div>');
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

		$(document).ready(function() {
			$("#itemId").change(function() {
				selectedItemId($(this).val());
			});

		});
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
							item = item
									+ "<option value="+responseJson[i].id+">"
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
</body>
</html>