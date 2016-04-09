function postDigg(type,articleId){
	$.ajax({
		url : '${basePath}'+"article/color.json",
		type : "POST",
		data : "id="+articleId+"&type="+type,
		dataType:'json',
		error:function(XMLHttpRequest, textStatus, errorThrown){},
		success : function(data){
			if(data.result == 0){
				document.getElementById('goodCount').innerHTML="("+data.goodCount+")";
				document.getElementById('badCount').innerHTML="("+data.badCount+")";
			} else {
	    		alert(data.info);
	    	}
		}
	});
}