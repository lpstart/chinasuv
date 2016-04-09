/*弹出一个让用户描述这个图片的窗口
 * 并更改这个图片的额描述信息
 */
function descDialog() {
	var imgIdInDB = $(this).attr('id');
	var rowDesc = "";
	$.ajax({
		url : "manage/getImgDetail.jhtml?imgId=" + imgIdInDB,
		async : false,
		dataType : "JSON",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		success : function(data) {
			var d = eval(data);
			rowDesc = d.description;
		}
	});
	dialog(
			{
				title : '输入描述信息：',
				content : '<textarea autofocus id="description">' + rowDesc
						+ '</textarea>',
				cancel : function() {
					this.close();
				},
				ok : function() {
					$
							.ajax({
								type : "post",
								url : "manage/updateImgDetail.jdo",
								data : "flag=1&imgId=" + imgIdInDB + "&description="
										+ $('#description').val(),
								dataType : "JSON",
								contentType : "application/x-www-form-urlencoded; charset=utf-8",
								async : true,
								success : function(data) {
									alert(data);
								}
							});
				},
			}).showModal();
}

// 取消事件;
function removeLi($li) {
	if ($li.siblings('li').length <= 0) {
		$li.parents('.parentFileBox').children().not('ul').remove();
		$li.parents('.parentFileBox').children().find('li').remove();
	} else {
		$li.remove();
	}
}