<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${article.title }</title>
<link href="${basePath }css/style.css" rel="stylesheet" type="text/css" />
<link href="${basePath }css/index.css" rel="stylesheet" type="text/css" />
<link href="${basePath }css/text.css" rel="stylesheet" type="text/css" />
<link href="${basePath }css/page.css" rel="stylesheet" type="text/css" />
<div id="containers">
<%@ include file="common/header.jsp"%>
<div id="text-wraps">
    <div class="text-wrap">
	    <!--左侧-->
		<div class="text-left">
		    <div class="text-bg">
			    <!--导航条-->
				<div class="list-left-top f12 black">
				    您现在的位置：> <a href='${basePath }'>${ppItem.ppItemName }</a> > ${ppItem.pItemName } > <a href='${basePath }plus/list.php?tid=${ppItem.id }'>${ppItem.itemName }</a>
				</div>
				<!--导航条:end-->
				<!-- 内容  -->
				<div class="text-left-line">
				    <h5 class="textcen bold black">${article.title }</h5>
					<div class="textcen f12">
					    ${article.createTime }
						<span class="mores"></span>来源:${article.resource }<span class="mores"></span>作者:${article.author }<span class="mores"></span>浏览${article.viewCount }次
					</div>
					
					<div class="gray f12 text-left-lead">
 							<div class="intro">${article.summary }......</div>
						
						<div class="f14 black text-size">
							<jsp:include page="${article.content }"/>
						</div>
						<div style="text-align:right; padding:10px 0px;">
							(责任编辑：${article.editor })
						</div>
						
						<div class="textcen f12 li_page" style="margin-bottom:5px;"></div>
						
						<div class="related">
						    <div class="f14 bold black">相关链接</div>
							<div class="relateds">
							    <ol class="f14 blue">
								    <li>
										<a href='${basePath }article/16/7.html' title="新增宝石红众泰将推新款T600" target="_blank">新增宝石红众泰将推新款T600</a>
									</li>
							    </ol>
							</div>
						</div>
							<div class="handle">
							    <div class="context">
								    <ul class="black">
									    <li>上一篇：<a href='${basePath }article/${article.lastArt.itemId }/${article.lastArt.id }.html'>${article.lastArt.title }</a> </li>
										<li>下一篇：<a href='${basePath }article/${article.nextArt.itemId }/${article.nextArt.id }.html'>${article.nextArt.title }</a> </li>
									</ul>
								</div>
							</div>
							
							<!-- //顶踩 -->
							<div class="newdigg" id="newdigg">
							    <div class="diggbox digg_good" onmousemove="this.style.backgroundPosition='left bottom';" onmouseout="this.style.backgroundPosition='left top';" onclick="javascript:postDigg(1,${article.id })">
								    <div class="digg_act">顶一下</div>
									<div class="digg_num" id="goodCount">(${article.goodCount })</div>
									<div class="digg_percent">
									    <div class="digg_percent_bar"><span id="digg_percent_good_bar" style="width:0%"></span></div>
										<div class="digg_percent_num" id="digg_percent_good">0%</div>
									</div>
								</div>
								<div class="diggbox digg_bad" onmousemove="this.style.backgroundPosition='right bottom';" onmouseout="this.style.backgroundPosition='right top';" onclick="javascript:postDigg(2,${article.id })">
								    <div class="digg_act">踩一下</div>
									<div class="digg_num" id="badCount">(${article.badCount })</div>
									<div class="digg_percent">
									    <div class="digg_percent_bar"><span id="digg_percent_bad_bar" style="width:0%"></span></div>
										<div class="digg_percent_num" id="digg_percent_bad">0%</div>
									</div>
								</div>
							</div>
					</div>
				</div>
				<!--广告-->
				<div class="m-top">
					<img src="${picHost }upload/test-left-banner.jpg" width="690" height="80" border="0" />
				</div>
				<!--广告:end-->
			</div>
		</div>
		<div class="text-right">
			<!--广告1-->
			<jsp:include page="common/right_ads.jsp"></jsp:include>
			<!--广告1:end-->
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	var goodCount = '${article.goodCount}';
	goodCount = parseInt(goodCount);
	var badCount = '${article.badCount}';
	badCount = parseInt(badCount);
	diggPercent(goodCount, badCount);
})
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
				diggPercent(data.goodCount,data.badCount);
			} else {
	    		alert(data.info);
	    	}
		}
	});
}
function diggPercent(goodCount, badCount){
	var totleCount = goodCount + badCount;
	var goodPerc = goodCount / totleCount;
	goodPerc = Math.round(goodPerc*100);
	var badPerc = badCount / totleCount;
	badPerc = Math.round(badPerc*100);
	$("#digg_percent_good").text(goodPerc+"%");
	$("#digg_percent_good_bar").css("width", goodPerc);
	$("#digg_percent_bad").text(badPerc+"%");
	$("#digg_percent_bad_bar").css("width", badPerc);
}
</script>
<%@ include file="common/footer.jsp"%>
</div>
