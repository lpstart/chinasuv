<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<title>中国SUV网-中国最大的SUV爱好者社区</title>
<meta name="keywords" content="SUV,豪华SUV,舒适SUV, SUV活动, SUV性能">
<meta name="description" content="中国SUV网是专门针对SUV车型的平台，为SUV爱好者提供">

<link href="${basePath }css/style.css" rel="stylesheet" type="text/css" />
<link href="${basePath }css/index.css" rel="stylesheet" type="text/css" />
<script src="${basePath }js/index.js"></script>

<script src="${basePath }js/tab.js"></script>

<div id="containers">
<%@ include file="common/header.jsp"%>
	<!--内容-->
	<div id="content-wraps">
	    <div id="content-wrap">
		    <!--内容顶端搜索-->
			<div class="content-top">
				<form name="formsearch" action="http://www.chinasuv.cn/plus/search.php">
			    <ol class="loginbar right">
					<li class="red f12"><span class="topinco3"></span><a href="${basePath }topic/summary.php" target="_blank">专题汇总</a></li>
					<li class="black bold f12"><span class="topinco3"></span>
						<a href="${basePath }topic/details/1.html" title="吉利GX7海岸之旅【专题】" target="_blank">吉利GX7海岸之旅</a>
					</li>
					<li class="leftscroll"></li>
					<li class="scroll f12">
					    <div id="div">
						    <c:forEach items="${data.SL }" var="hdata" varStatus="status">
					    		<a href="${hdata.goUrl }" title="${hdata.title }" target="_blank">${hdata.title }</a><br>
						    </c:forEach>
						</div>
					</li>
<script>
var c,_=Function;
with(o=document.getElementById("div")){ innerHTML+=innerHTML; onmouseover=_("c=1"); onmouseout=_("c=0");}
(F=_("if(#%26||!c)#++,#%=o.scrollHeight>>1;setTimeout(F,#%26?10:1500);".replace(/#/g,"o.scrollTop")))();
</script>
					<li class="rightscroll"></li>
					<li>
					  <select name="searchtype" class="search-option" id="search-option">
					   <option value="title" selected="1">检索标题</option>
					   <option value="titlekeyword">智能模糊</option>
					  </select>
					  <input type="hidden" name="kwtype" value="0">
					</li>
					<li>
      					<input name="q" type="text" class="search-keyword" id="search-keyword" value="在这里搜索..." onfocus="if(this.value=='在这里搜索...'){this.value='';}" onblur="if(this.value==''){this.value='在这里搜索...';}">					
					</li>
					<li><button type="submit" class="search1 f12 bold">搜索</button></li>
				</ol>
				</form>
			</div>
			<!--内容顶端搜索:end-->
			
			<!--首页内容-->
			<div class="centents">
				<div class="blank5"></div>
				<!--第一通栏-->
				<div class="centent">
				    <div class="lines focuss">
					    <!--左-->
						<%@ include file="homeLeft.jsp"%>
						<!--左:end-->
						
						<!--中-->
						<%@ include file="homeMiddle.jsp"%>
						<!--中:end-->
						
						<!--右-->
						<%@ include file="homeRight.jsp"%>
						<!--右:end-->
						<div class="clear"></div>
					</div>
				</div>
				<!--第一通栏:end-->
			<!--首页内容:end-->
		</div>
	</div>
	<!--内容:end-->
</div>
<%@ include file="common/homeFooter.jsp"%>
</div>
