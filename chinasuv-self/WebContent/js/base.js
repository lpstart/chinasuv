function pageHtml(requestUrl,queryString,totalPage,pageNo,totalCount){
	var returnHtml = "";
	if(pageNo == 1){
		returnHtml = "<li><a>首页</a></li>";
	} else {
		returnHtml = "<li><a href='"+requestUrl+"?"+queryString+"'>首页</a></li>";
	}
	var showPages = 6;
	if(pageNo <= showPages ){
		var max = showPages;
		if(showPages > totalPage){
			max = totalPage;
		}
		for(var i = 1; i <= max; i++){
			returnHtml += indexPageHtml(i, pageNo, requestUrl, queryString);
		}
	} else {
		var max = showPages;
		var trueMax = totalPage - (pageNo - showPages/2);
		if(trueMax < showPages){
			max = showPages;
		}
		for(var j = pageNo - showPages/2; j < max; j++){
			returnHtml += indexPageHtml(i, pageNo, requestUrl, queryString);
		}
	}
	if(pageNo < totalPage){
		returnHtml += "<li><a href='"+requestUrl+"?"+queryString+"&pageNo="+(parseInt(pageNo)+1)+"'>下一页</a></li>";
	}
	if(pageNo >= totalPage){
		returnHtml += "<li><a>末页</a></li>";
	} else {
		returnHtml += "<li><a href='" + requestUrl + "?"+queryString+"&pageNo="+totalPage+"'>末页</a></li>";
	}
	returnHtml += "<li><span class=pageinfo>共 <strong>"+totalPage+"</strong>页<strong>" + totalCount + "</strong>条</span></li>";
	document.write(returnHtml);
}

function indexPageHtml(i,pageNo,requestUrl,queryString){
	if(pageNo == i){
		return "<li class='thisclass'><a>"+i+"</a></li>";
	} else {
		return "<li><a href='"+requestUrl+"?"+queryString+"&pageNo="+i+"'>"+i+"</a></li>";
	}
}