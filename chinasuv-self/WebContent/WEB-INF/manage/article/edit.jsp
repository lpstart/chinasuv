<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../commonHead.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${basePath }">
<title>编辑文章</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" charset="utf-8"
	src="resources/ueditor/js/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="resources/ueditor/js/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="resources/ueditor/js/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="resources/datatables/bootstrap/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/datatables/bootstrap/js/bootstrap.min.js"></script>
<link href="resources/datatables/bootstrap/css/bootstrap.min.css" rel="stylesheet">



<!-- 搞定封面上传的引入 -->
<link rel="stylesheet" type="text/css"
	href="resources/ueditor/js/third-party/webuploader/webuploader.css">
<link rel="stylesheet" type="text/css"
	href="${basePath}/resources/diyUpload/css/diyUpload.css">
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
		<h3>编辑文章</h3>
		<form action="manage/editArticle_do.jdo" method="post" class="form-horizontal">
			<table>
				<tr>
					<td style="border: 0; width: 400px; height: 250px;">
						<div id="coverBox" style="height: 100%; width: 100%; text-align: center;">
							<div style="width: 180px;" class="parentFileBox">
								<ul class="fileBoxUl">
									<li id="fileBox_WU_FILE_0" class="">
										<div class="viewThumb">
											<img src="${article.picPath }">
										</div>
										<div class="diyCancel"></div>
										<div style="display: block;" class="diySuccess"></div>
										<div style="display: none;" class="diyBar">
											<div style="width: 100%;" class="diyProgress"></div>
											<div class="diyProgressText">上传完成</div>
										</div>
									</li>
								</ul>
							</div>
							<div id="imgUpload"></div>
							<div class="webuploader-container" id="reselectCoverPic"
								style="display: inline; width: 50%" onclick="clearImage()">
								<div class="webuploader-pick" style="margin-right: 10%;">重新选择封面</div>
							</div>
						</div>
						<input type="hidden" name="picId" id="coverPicId" value="${article.picId }" />
						<input type="hidden" name="picPath" id="coverPicPath" value="${article.picPath }" />
					</td>
					<td>
						<div style="height: 100%; width: 100%;" class="control-group ">
							<input type="hidden" name="id" value="${article.id }" />
							<input type="hidden" name="method" value="edit_do" />
							标题：
							<input type="text" name="title" class="span2" value="${article.title }"
								style="margin-bottom: 5px" />
							&emsp;来源&emsp;：
							<input type="text" name="resource" class="span2" value="${article.resource }"
								style="margin-bottom: 5px" />
							<br /> 作者：
							<input type="text" name="author" class="span2" value="${article.author }"
								style="margin-bottom: 5px" />
							责任编辑：
							<input type="text" name="editor" class="span2" value="${article.editor }"
								style="margin-bottom: 5px" />
							<br /> 所属一级板块：
							<select name="topItem" id="itemId" class="form-control input-sm" style="width: 47%">
								<c:forEach items="${items}" var="temp">
									<c:choose>
										<c:when test="${temp.id==topItem.id}">
											<option value="${temp.id}" selected="selected">${temp.itemName}</option>
										</c:when>
										<c:otherwise>
											<option value="${temp.id}">${temp.itemName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							 所属二级板块：
							<select name="itemId" id="subItemId" class="form-control input-sm"
								style="width: 47%">
								<c:forEach items="${subItems}" var="temp">
									<c:choose>
										<c:when test="${temp.id==article.itemId}">
											<option value="${temp.id}" selected="selected">${temp.itemName}</option>
										</c:when>
										<c:otherwise>
											<option value="${temp.id}">${temp.itemName}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
							摘要：<br />
							<textarea rows="2" cols="40" name="summary">${article.summary }</textarea>
						</div>
					</td>
				</tr>
			</table>
			<input type="hidden" value="${article.content }" name="content" />
			<br />
			<textarea name="new_content" id="editor" style="width: 90%"><c:import
					url="${article.content }"></c:import></textarea>
			<script type="text/javascript">
				var editor = new UE.ui.Editor();
				editor.render("editor");
			</script>
			<input type="submit" value="提交" class="btn btn-primary" />
		</form>
	</div>
	<script type="text/javascript">
		function clearImage() {
			$('#coverBox')
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
		$(document).ready(function() {
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