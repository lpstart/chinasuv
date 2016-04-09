<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${ppItem.pItemName } / ${ppItem.itemName }_${ppItem.ppItemName }</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<link href="css/text.css" rel="stylesheet" type="text/css" />

<div id="containers">
<%@ include file="common/header.jsp"%>
<div id="text-wraps">
	    <div class="text-wrap">
		    <!--左侧-->
			<div class="text-left">
			    <div class="text-bg">
				    <!--导航条-->
					<div class="list-left-top f12 black">
					    您现在的位置：
						 > <a href='${basePath }'>${ppItem.ppItemName }</a> > ${ppItem.pItemName } > <a href='${basePath }plus/list.php?tid=${ppItem.id }'>${ppItem.itemName }</a>
					</div>
					<!--导航条:end-->
					<!--列表-->
					<div class="list-bgs">
						<dl>
							<c:forEach var="a" varStatus="status" items="${pation.list }">
							    <dt class="left photoline">
								    <a href='article/${ppItem.id }/${a.id }.html' class='preview'><img src='${picHost }${a.picPath }'/></a>
								</dt>
								<dd class="right">
								    <h4 class="f16 bold black">
									    [<b><a href='plus/list.php?tid=${ppItem.id}'>${ppItem.itemName }</a></b>] <a href='article/${ppItem.id }/${a.id }.html'>${a.title }</a>
									</h4>
									<span class="f12"><!-- 日期：2016-03-19 08:46:00--> 浏览：${a.viewCount }次    好评：${a.goodCount }</span>
									<p class="f14 gray">
									    ${a.summary }...
										<span class="blue f12"><a href="article/${ppItem.id }/${a.id }.html" target="_blank">[查看详情]</a></span>
									</p>
								</dd>
								<div class="clear"></div>
							</c:forEach>
						</dl>
						<!-- 分页 start -->
						<dl class="f12 li_page">
					   		<ul>
								<SCRIPT LANGUAGE="JavaScript">
									pageHtml("${pation.requestUrl }","tid=${ppItem.id }","${pation.totalPage}","${pation.pageNo}","${pation.totalCount }");
								</SCRIPT>
					   		</ul>
					  	</dl>
					  	<!-- 分页 end -->
					</div>
				</div>
				<div style="padding-top:8px; "></div>
				<!--精彩推荐-->
				<div class="list-wonderful">
				    <div class="list-wonderful-top f14 white">
					    精彩推荐
					</div>
					<div class="blank15"></div>
					<div class="list-wonderfuls">
						<dl>
							<dt class="photoline">
								<a href='http://www.chinasuv.cn/a/xinwen/diebao/2015/0124/5357.html'><img src='http://www.chinasuv.cn/uploads/allimg/150124/17-1501240204344H-lp.jpg' border='0' width='150' height='90' alt='众泰Z700测试车实拍 局部细节首曝光'></a>
							</dt>
							<dd class="f12 black">
								<a href='http://www.chinasuv.cn/a/xinwen/diebao/2015/0124/5357.html' title="众泰Z700测试实拍局部细节首曝" target="_blank">众泰Z700测试实拍局部细节首曝</a>
							</dd>
						</dl>
					</div>
				</div>
			</div>
			<div class="text-right">
				<!--广告-->
				<jsp:include page="common/right_ads.jsp"></jsp:include>
				
				<!--点击排行榜-->
				<div class="m-top">
					<div class="text-tab2">
					
					</div>
				</div>
				
				<!--酷图-->
				<div class="m-top">
					<div class="text-tab3">
						
					</div>
				</div>
				
				<!--精彩推荐-->
				<div class="m-top">
			    	<div class="text-tab3">
			    	
			    	</div>
		    	</div>
			</div>
		</div>
</div>
<%@ include file="common/footer.jsp"%>
</div>
