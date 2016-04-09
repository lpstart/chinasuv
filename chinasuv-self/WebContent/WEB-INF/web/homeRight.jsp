<%@ page language="java" pageEncoding="UTF-8"%>
<div class="newssright">
							<!--广告1-->
<div class="rightbg">
	<div class="right-ban1">
		<a href="${data.RT[0].goUrl }" target="_blank"><img src="${picHost }${data.RT[0].picPath }" width="260" height="250" border="0"></a>
	</div>
	<div class="right-ban2t">
		<ul class="f12 black">
			<c:forEach items="${data.RT }" var="hdata" begin="1" end="6" varStatus="status">
				<li><span class="miceli1"></span><a href="${hdata.goUrl }" title="${hdata.title }" target="_blank">${hdata.title }</a></li>
			</c:forEach>
		</ul>
		<div class="clear"></div>
	</div>
</div>

							<!--广告1:end-->
							<!--评测及购车-->
							<div class="rightbg right-ban1">
							    <div class="lines pad10">
									<!--评测中心-->
<div class="bbs-center">
	<div class="right f12 blue">
		<a href="${basePath }plus/list.php?tid=${data.PC[0].itemId }" target="_blank">&gt;&gt;更多</a>
	</div>
	<h5 class="f14 blue bold">评测中心</h5>
</div>
<div class="blank5"></div>
<div class="bbs-center">
	<div class="left">

		<div class="photoline">
 			<a href="${data.PC[1].goUrl }" target="_blank"><img src="${picHost }${data.PC[1].picPath }" alt="${data.PC[1].title }" width="122" height="85" border="0"></a>
		</div>	
		<div class="joinus-size1 f12 black">
			<a href="${data.PC[1].goUrl }" title="${data.PC[1].title }" target="_blank">${data.PC[1].title }</a>
		</div>	
	</div>
	<div class="right">
		<div class="photoline">
 			<a href="${data.PC[2].goUrl }" target="_blank"><img src="${picHost }${data.PC[2].picPath }" alt="${data.PC[2].title }" width="122" height="85" border="0"></a>
		</div>	
		<div class="joinus-size1 f12 black">
			<a href="${data.PC[2].goUrl }" title="${data.PC[2].title }" target="_blank">${data.PC[2].title }</a>
		</div>	
	</div>
	<div class="clear"></div>
</div>
<div class="blank5"></div>
<div class="right-ban3t">
	<ul class="f12 black">
		<c:forEach items="${data.PC }" var="hdata" begin="2" end="5" varStatus="status">
			<li><span class="miceli1"></span><a href="${hdata.goUrl }" title="${hdata.title }" target="_blank">${hdata.title }</a></li>
		</c:forEach>
	</ul>
	<div class="clear"></div>
</div>

<!--评测中心:end-->
<div class="grayline"></div>

<!--购车-->
<div class="bbs-center">
	<div class="right f12 blue">
		<a href="${basePath }plus/list.php?tid=${data.GC[0].itemId}" target="_blank">&gt;&gt;更多</a>
	</div>
	<h5 class="f14 blue bold">购车</h5>
	<div class="sjtab">
		<div class="sjtabphoto">
			<ul id="myTab2">
				<c:forEach items="${data.GC }" var="hdata" begin="1" end="4" varStatus="status">
					<li class="normal" onmouseover="nTabs(this,'${status.index-1}');">
						<a href="${hdata.goUrl }" title="${hdata.title }" target="_blank"><img src="${picHost }${hdata.picPath }" border="0" width="52" height="42" alt="${hdata.title }"></a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="sjtabcontent">
		
			<div id="myTab2_Content0">
				<ul class="li1">
					<li class="f12">
						<p class="blue">
							<a href="${data.GC[1].goUrl }" title="${data.GC[1].title }" target="_blank">${data.GC[1].title }</a>
						</p>
						<p class="gray">时间：2014年04月22日</p>
					</li>
				</ul>
			</div>
			<div id="myTab2_Content1" class="none">
							<ul class="li2">
								<li class="f12">
									<p class="blue">
										<a href="${data.GC[2].goUrl }" title="${data.GC[2].title }" target="_blank">${data.GC[2].title }</a>
									</p>
									<p class="gray">时间：2014年04月17日</p>
								</li>
							</ul>
			</div>
			<div id="myTab2_Content2" class="none">
				<ul class="li3">
					<li class="f12">
						<p class="blue">
							<a href="${data.GC[3].goUrl }" title="${data.GC[3].title }" target="_blank">${data.GC[3].title }</a>
						</p>
						<p class="gray">时间：2014年04月11日</p>
					</li>
				</ul>
			</div>
			<div id="myTab2_Content3" class="none">
				<ul class="li4">
					<li class="f12">
						<p class="blue">
							<a href="${data.GC[4].goUrl }" title="${data.GC[4].title }" target="_blank">${data.GC[4].title }</a>
						</p>
						<p class="gray">时间：2014年04月02日</p>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!--购车:end-->
</div>
</div>
<!--评测及购车:end-->
							
	<!--精彩图库-->
	<div class="rightbg lines">
	    <div class="pad10">
		    <div class="right f12 blue">
				<a href="plus/list.php?tid=${data.TK[0].itemId }" target="_blank">&gt;&gt;更多</a>
			</div>
			<h5 class="f14 blue bold">${data.TK[0].title }</h5>
		</div>
		<div class="bbs-center lines">
		    <div class="weeksntab">
				<div class="weekstabtitle">
					<ul id="myTab3">
						<li class="active" onmouseover="nTabs(this,0);">${data.TK[1].title }</li>
						<c:forEach items="${data.TK }" var="hdata" begin="2" end="7" varStatus="status">
							<li class="normal" onmouseover="nTabs(this,'${status.index-1}');">${hdata.title }</li>
						</c:forEach>
					</ul>
				</div>
				<div class="weekstabcontent">
					<div id="myTab3_Content0">
						<div class="photoline">
							<a href="${data.TK[1].goUrl }" target="_blank"><img src="${picHost }${data.TK[1].picPath }" alt="${data.TK[1].title }" width="267" height="101" border="0"></a>
						</div>
					</div>
				
					<c:forEach items="${data.TK }" var="hdata" begin="2" end="7" varStatus="status">
						<div id="myTab3_Content${status.index-1 }" class="none">
							<div class="photoline">
								<a href="${hdata.goUrl }" target="_blank"><img src="${picHost }${hdata.picPath }" alt="${hdata.title }" width="267" height="101" border="0"></a>
							</div>
						</div>
					</c:forEach>
										</div>
									</div>
								</div>
							</div>
							<!--精彩图库:end-->
							<!--广告2-->
<div class="bannebg pad10">
	<div class="photoline">
		<a href="${data.ZT[0].goUrl }" target="_blank"><img src="${picHost }${data.ZT[0].picPath }" width="264" height="167" border="0"></a>
	</div>
</div>
							<!--广告2:end-->
						</div>