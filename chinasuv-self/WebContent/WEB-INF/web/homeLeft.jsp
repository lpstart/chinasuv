<%@ page language="java" pageEncoding="UTF-8"%>
<div class="left todayleft">
	<!--新闻动画-->
	<div class="newsphoto marbot10">
		<div id="foc">
			<c:forEach items="${data.LB }" var="hdata" varStatus="status">
				<a href="${hdata.goUrl }" target="_blank"><img
					src="${picHost }${hdata.picPath }" alt="${hdata.title }"
					width="318" height="410" border="0"></a>
			</c:forEach>
		</div>
		<dl class="avs" id="focimg">
			<dt>
				<a target="_blank" href="${data.LB[0].goUrl }"><img
					src="${basePath }img/a14.gif"></a><img
					src="${picHost }${data.LB[0].picPath }" alt="${data.LB[0].title }">
			</dt>
			<dd>
				<div>STOP</div>
				<ul></ul>
			</dd>
		</dl>
		<script>
			FocusImg(5000, "foc", "focimg");
		</script>
	</div>
	<!--新闻动画:end-->
	<div class="centent">
		<!--24小时阅读-->
		<div class="marbot10 lines">
			<div class="time-top">
				<div class="right more f12 blue">
					<a href="${basePath }plus/list.php?tid=${data.RD24[0].itemId}"
						target="_blank">&gt;&gt; 查看更多精彩文章 </a>
				</div>
				<h5 class="f16 bold">
					<span class="orange">24小时</span><span class="blue">阅读</span>
				</h5>
			</div>
			<div class="bbs-center">
				<div class="timentab">
					<div class="timetabtitle">
						<ul id="myTab4">
							<li class="normal" onmouseover="nTabs(this,0);" title="${data.RD24_1[0].itemName }">${data.RD24_1[0].itemName }</li>
							<li class="active" onmouseover="nTabs(this,1);" title="${data.RD24_2[0].itemName }">${data.RD24_2[0].itemName }</li>
							<li class="normal" onmouseover="nTabs(this,2);" title="${data.RD24_3[0].itemName }">${data.RD24_3[0].itemName }</li>
							<li class="normal" onmouseover="nTabs(this,3);" title="${data.RD24_4[0].itemName }">${data.RD24_4[0].itemName }</li>
							<li class="normal" onmouseover="nTabs(this,4);" title="${data.RD24_5[0].itemName }">${data.RD24_5[0].itemName }</li>
							<li class="normal" onmouseover="nTabs(this,5);" title="${data.RD24_6[0].itemName }">${data.RD24_6[0].itemName }</li>
						</ul>
					</div>
					<div class="timetabcontent">
						<div id="myTab4_Content0" style="display: none;">
							<ul class="f12 black">
								<c:forEach items="${data.RD24_1 }" var="hdata" varStatus="status">
									<li>
									<c:if test="${status.index+1 <= 3 }">
										<span class="time-icon1">${status.index+1 }</span>
									</c:if>
									<c:if test="${status.index+1 > 3 }">
										<span class="time-icon2">${status.index+1 }</span>
									</c:if>
									 <a href="${hdata.goUrl }" title="${hdata.title }" target="_blank">${hdata.title }</a></li>
								</c:forEach>
							</ul>
						</div>
						
						<div id="myTab4_Content0" style="display: none;">
							<ul class="f12 black">
								<c:forEach items="${data.RD24_1 }" var="hdata" varStatus="status">
									<li>
									<c:if test="${status.index+1 <= 3 }">
										<span class="time-icon1">${status.index+1 }</span>
									</c:if>
									<c:if test="${status.index+1 > 3 }">
										<span class="time-icon2">${status.index+1 }</span>
									</c:if>
									 <a href="${hdata.goUrl }" title="${hdata.title }" target="_blank">${hdata.title }</a></li>
								</c:forEach>
							</ul>
						</div>
						
						<div id="myTab4_Content1" style="display: block;">
							<ul class="f12 black">
								<c:forEach items="${data.RD24_2 }" var="hdata" varStatus="status">
									<li>
									<c:if test="${status.index+1 <= 3 }">
										<span class="time-icon1">${status.index+1 }</span>
									</c:if>
									<c:if test="${status.index+1 > 3 }">
										<span class="time-icon2">${status.index+1 }</span>
									</c:if>
									 <a href="${hdata.goUrl }" title="${hdata.title }" target="_blank">${hdata.title }</a></li>
								</c:forEach>
							</ul>
						</div>
						
						<div id="myTab4_Content2" style="display: none;">
							<ul class="f12 black">
								<c:forEach items="${data.RD24_3 }" var="hdata" varStatus="status">
									<li>
									<c:if test="${status.index+1 <= 3 }">
										<span class="time-icon1">${status.index+1 }</span>
									</c:if>
									<c:if test="${status.index+1 > 3 }">
										<span class="time-icon2">${status.index+1 }</span>
									</c:if>
									 <a href="${hdata.goUrl }" title="${hdata.title }" target="_blank">${hdata.title }</a></li>
								</c:forEach>
							</ul>
						</div>
						
						<div id="myTab4_Content3" style="display: none;">
							<ul class="f12 black">
								<c:forEach items="${data.RD24_4 }" var="hdata" varStatus="status">
									<li>
									<c:if test="${status.index+1 <= 3 }">
										<span class="time-icon1">${status.index+1 }</span>
									</c:if>
									<c:if test="${status.index+1 > 3 }">
										<span class="time-icon2">${status.index+1 }</span>
									</c:if>
									 <a href="${hdata.goUrl }" title="${hdata.title }" target="_blank">${hdata.title }</a></li>
								</c:forEach>
							</ul>
						</div>
						
						<div id="myTab4_Content4" style="display: none;">
							<ul class="f12 black">
								<c:forEach items="${data.RD24_5 }" var="hdata" varStatus="status">
									<li>
									<c:if test="${status.index+1 <= 3 }">
										<span class="time-icon1">${status.index+1 }</span>
									</c:if>
									<c:if test="${status.index+1 > 3 }">
										<span class="time-icon2">${status.index+1 }</span>
									</c:if>
									 <a href="${hdata.goUrl }" title="${hdata.title }" target="_blank">${hdata.title }</a></li>
								</c:forEach>
							</ul>
						</div>
						
						<div id="myTab4_Content5" style="display: none;">
							<ul class="f12 black">
								<c:forEach items="${data.RD24_6 }" var="hdata" varStatus="status">
									<li>
									<c:if test="${status.index+1 <= 3 }">
										<span class="time-icon1">${status.index+1 }</span>
									</c:if>
									<c:if test="${status.index+1 > 3 }">
										<span class="time-icon2">${status.index+1 }</span>
									</c:if>
									 <a href="${hdata.goUrl }" title="${hdata.title }" target="_blank">${hdata.title }</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--24小时阅读:end-->
		<!--广告-->
		<div class="marbot10 lines">
			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
				codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
				width="310" height="130">
				<param name="movie"
					value="${picHost }upload/1212.swf">
				<param name="quality" value="high">
				<embed
					src="${picHost }upload/1212.swf"
					quality="high"
					pluginspage="http://www.macromedia.com/go/getflashplayer"
					type="application/x-shockwave-flash" width="310" height="130">
			</object>
		</div>
		<!--广告:end-->
		
		<!--预告-->
		<div class="bbs-center">
			<div class="notice-top">
				<div class="right notice-icon3 f12 white">
					<span class="f12 bold notice-icon1">03</span> <span
						class="left notice-toptext">预告03月最新车型抢先了解</span> <span class="notice-icon2"></span>
				</div>
			</div>
			<div class="notice" style="padding: 7px 10px;">

				<div class="bbs-center" style="padding: 5px 0px;">
					<div class="left">
						<div class="notice-photo">
							<a  href="${data.YG[0].goUrl }"
								target="_blank"><img
								src="${picHost }${data.YG[0].picPath }"
								alt="${data.YG[0].title }" width="95" height="88" border="0"></a>
						</div>
					</div>

					<div class="right notice-text">
						<p class="f14 todayt black bold">
							<a  href="${data.YG[1].goUrl }"
								title="${data.YG[1].title }" target="_blank">${data.YG[1].title }</a>
						</p>
						<p class="f12 gray">中国SUV网（4月20日上海车展报道）……&gt;</p>
						<p class="f12 red">上市时间：2014年4月1日</p>
						<p class="f12 red">销售价格：未公布</p>
					</div>
					<div class="clear"></div>
				</div>

				<div class="bbs-center" style="padding: 5px 0px;">
					<div class="left">
						<div class="notice-photo">
							<a  href="${data.YG[2].goUrl }"
								target="_blank"><img
								src="${picHost }${data.YG[2].picPath }"
								alt="${data.YG[2].title }" width="95" height="88" border="0"></a>
						</div>
					</div>
					<div class="right notice-text">
						<p class="f14 todayt black bold">
							<a  href="${data.YG[3].goUrl }"
								title="${data.YG[3].title }" target="_blank">${data.YG[3].title }</a>
						</p>
						<p class="f12 gray">不可否认的是，直到今天，大多数……&gt;</p>
						<p class="f12 red">上市时间：2014年4月17号</p>
						<p class="f12 red">销售价格：未公布</p>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>

		<!--预告:end-->
	</div>
</div>