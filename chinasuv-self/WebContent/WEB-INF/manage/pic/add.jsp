<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../commonHead.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="times" value="<%=new Date().getTime()%>"></c:set>
<base href="${basePath }">
<title>添加图集</title>

<link href="resources/datatables/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/diyUpload/css/webuploader.css">
<link rel="stylesheet" type="text/css" href="resources/diyUpload/css/diyUpload.css">
<script src="resources/lib/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/diyUpload/js/webuploader.html5only.min.js"></script>
<script type="text/javascript" src="resources/diyUpload/js/diyUpload.js"></script>

<link href="resources/artdialog/css/ui-dialog.css" rel="stylesheet">
<script type="text/javascript" src="resources/artdialog/js/dialog-min.js"></script>

</head>
<style>
* {
	padding: 0;
}

div {
	width: 90%;
}

.webuploader-pick {
	width: 120px;
}

#coverBox .parentFileBox {
	margin-left: 22%;
}

.descDiv {
	display: block;
	position: absolute;
	top: 53px;
	left: 49px;
	background: #00b7ff;
	border-radius: 3px;
	overflow: hidden;
	color: #fff;
	width: -moz-fit-content;
	cursor: pointer;
}

.ui-dialog, .ui-popup {
	width: -moz-fit-content;
}
</style>
<script type="text/javascript">
	var contents = [];//图片id集合
	function check() {
		$.each($("#imgUpload").next('.parentFileBox').find('li'),
				function(i, n) {
					if ($(n).attr('imgId')) {
						contents.push($(n).attr('imgId'));
					}
				})
		var flag = false;
		if (contents.length == 0) {
			alert("请上传图片！");
			flag = false;
		} else {
			$("#content").val(contents);
			if ($("#coverPicId").val().length <= 0) {
				$("#coverPicId").val(contents[0]);
			}
			flag = true;
		}
		return flag;
	}
</script>
<body>
	<div style="margin: 0 0 0 30px;">
		<h3>添加图集</h3>
		<form action="manage/addPic_do.jdo" method="post" class="form-horizontal"
			onsubmit="return check()">
			<table>
				<tr>
					<td style="border: 0; width: 400px; height: 250px;">
						<div id="coverBox" style="height: 100%; width: 100%; text-align: center;">
							<div id="coverImg">选择封面</div>
							<div class="webuploader-container" id="reselectCoverPic"
								style="display: none; width: 50%" onclick="clearImage()">
								<div class="webuploader-pick" style="margin-right: 10%;">重新选择封面</div>
							</div>
						</div>
						<input type="hidden" name="picId" id="coverPicId" />
					</td>
					<td>
						<div style="height: 100%; width: 100%;" class="control-group ">
							<span>
								标题：
								<input type="text" name="title" class="span2" style="margin-bottom: 5px" />
							</span>
							<span>
								&emsp;来源&emsp;：
								<input type="text" name="resource" class="span2" style="margin-bottom: 5px" />
							</span>
							<br /> 作者：
							<input type="text" name="author" class="span2" style="margin-bottom: 5px" />
							责任编辑：
							<input type="text" name="editor" class="span2" style="margin-bottom: 5px" />
							<br /> 所属一级板块：
							<select name="topItem" id="itemId" class="form-control input-sm" style="width: 47%">
								<c:forEach items="${items}" var="temp">
									<option <c:if test="${temp.id == 2 }">selected="selected"</c:if> value="${temp.id}">${temp.itemName}</option>
								</c:forEach>
							</select>
							所属二级板块：
							<select name="subItem" id="subItemId" style="width: 47%"
								class="form-control input-sm">
								<c:forEach items="${subItems}" var="temp">
									<option <c:if test="${temp.id == 16 }">selected="selected"</c:if> value="${temp.id}">${temp.itemName}</option>
								</c:forEach>
							</select>
							摘要：<br />
							<textarea rows="2" cols="40" name="summary"></textarea>
							<input name="content" id="content" type="hidden">
						</div>
					</td>
				</tr>
			</table>
			<div class="container-fluid" style="margin-left: 0px;">
				<div id="box">
					<div id="imgUpload" style="width: 50px"></div>
					<div class="parentFileBox panel panel-default"
						style="OVERFLOW: auto; height: 300px; width: 100%;">
						<ul class="fileBoxUl"></ul>
					</div>
				</div>
			</div>
			<input type="submit" value="提交" class="btn btn-primary" />
		</form>
	</div>
</body>
<script type="text/javascript">
	function clearImage() {
		$('#coverBox')
				.html(
						'<div id="coverImg"></div><div class="webuploader-container" id="reselectCoverPic" style="display: none;width:50%" onclick="clearImage()"><div class="webuploader-pick"  style="margin-right: 10%;">重新选择封面</div></div>');
		/*
		 * 服务器地址,成功返回,失败返回参数格式依照jquery.ajax习惯;
		 * 其他参数同WebUploader
		 */
		$('#coverImg').diyUpload({
			url : 'manage/uploadImg.jdo',
			success : function(data) {
				console.info(data);
				var d = eval(data);
				$("#reselectCoverPic").css("display", "inline");
				$("#coverImg").css("display", "none");
				if ("success" == d.success) {//上传成功,更新content value
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
		/*
		 *初始化封面图片的效果
		 */
		$('#coverImg').diyUpload({
			url : 'manage/uploadImg.jdo',
			success : function(data) {
				console.info(data);
				var d = eval(data);
				$("#reselectCoverPic").css("display", "inline");
				$("#coverImg").css("display", "none");
				if ("success" == d.success) {//上传成功,更新content value
					$("#coverPicPath").val(d.picPath);
					$("#coverPicId").val(d.id);
				}
			},
			error : function(err) {
				console.info(err);
			}
		});
		/*
		 * 服务器地址,成功返回,失败返回参数格式依照jquery.ajax习惯;
		 * 其他参数同WebUploader
		 */
		$('#imgUpload').diyUpload({
			url : 'manage/uploadImg.jdo',
			success : function(data) {
				console.info(data);
				var d = eval(data);
				if ("success" == d.success) {//上传成功,更新content value
				}
			},
			error : function(err) {
				console.info(err);
			}
		});
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
						item = item + "<option value="+responseJson[i].id+">"
								+ responseJson[i].itemName + "</option>"
					}
					$("#subItemId").html(item);
				}
			},
			error : function() {
			},
			complete : function() {
			}
		});
	}
</script>
</html>
