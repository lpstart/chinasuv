<%@ page language="java" pageEncoding="UTF-8"%>
<div class="left today">
	<div class="matop">
		<div class="today-focus">
			<div class="today-title"></div>

			<h5 class="f16 textcen orange bold">
				<a href="${data.TF[0].goUrl }" title="${data.TF[0].title }" target="_blank">${data.TF[0].title }</a>
			</h5>

			<div class="right-ban1t">
				<ul class="f12 black">
					<c:forEach items="${data.TF }" var="hdata" begin="1" end="6" varStatus="status">
						<li><span class="miceli1"></span><a href="${hdata.goUrl }"
							title="${hdata.title }" target="_blank">${hdata.title }</a></li>
					</c:forEach>
				</ul>
				<div class="clear"></div>
			</div>
			<h5 class="f16 textcen orange bold">
				<a href="${data.TF[7].goUrl }" title="${data.TF[7].title }"
					target="_blank">${data.TF[7].title }</a>
			</h5>
			<div class="right-ban1t">
				<ul class="f12 black">
					<c:forEach items="${data.TF }" var="hdata" begin="8" end="11" varStatus="status">
						<li><span class="miceli1"></span><a href="${hdata.goUrl }"
							title="${hdata.title }" target="_blank">${hdata.title }</a></li>
					</c:forEach>
				</ul>
				<div class="clear"></div>
			</div>
		</div>
	</div>

	<div class="newtoday">
		<h5>
			<div class="right f12 blue">
				<a href="${basePath }plus/list.php?tid=${data.RRD1[0].itemId }"
					target="_blank">&gt;&gt;更多</a>
			</div>
			<span class="today-icon"></span><span class="f14 blue bold">${data.RRD1[0].itemName }</span>
		</h5>
		<div class="bbs-center">
			<div class="left">
				<div class="photoline">
					<a href="${data.RRD1[0].goUrl }" target="_blank"><img
						src="${picHost }${data.RRD1[0].picPath }"
						alt="${data.RRD1[0].title }" width="102" height="102" border="0"></a>
				</div>
			</div>
			<div class="left padleft10">
				<h5 class="todayt blue bold">
					<a href="${data.RRD1[1].goUrl }" title="${data.RRD1[1].title }"
						target="_blank">${data.RRD1[1].title }</a>
				</h5>
				<ul class="f14 black">
					<c:forEach items="${data.RRD1 }" var="hdata" begin="2" end="5" varStatus="status">
						<li><span class="miceli1"></span><a href="${hdata.goUrl }"
							title="${hdata.title }" target="_blank">${hdata.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div class="newtoday">
		<h5>
			<div class="right f12 blue">
				<a href="${basePath }plus/list.php?tid=${data.RRD2[0].itemId }"
					target="_blank">&gt;&gt;更多</a>
			</div>
			<span class="today-icon"></span><span class="f14 blue bold">${data.RRD2[0].itemName }</span>
		</h5>
		<div class="bbs-center">
			<div class="left">
				<div class="photoline">
					<a href="${data.RRD2[0].goUrl }" target="_blank"><img
						src="${picHost}${data.RRD2[0].picPath }"
						alt="${data.RRD2[0].title }" width="102" height="102" border="0"></a>
				</div>
			</div>
			<div class="left padleft10">
				<h5 class="todayt blue bold">
					<a href="${data.RRD2[1].goUrl }" title="${data.RRD2[1].title }"
						target="_blank">${data.RRD2[1].title }</a>
				</h5>
				<ul class="f14 black">
					<c:forEach items="${data.RRD2 }" var="hdata" begin="2" end="5" varStatus="status">
						<li><span class="miceli1"></span><a href="${hdata.goUrl }"
							title="${hdata.title }" target="_blank">${hdata.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div class="newtoday">
		<h5>
			<div class="right f12 blue">
				<a href="${basePath }plus/list.php?tid=${data.RRD3[0].itemId }"
					target="_blank">&gt;&gt;更多</a>
			</div>
			<span class="today-icon"></span><span class="f14 blue bold">${data.RRD3[0].itemName }</span>
		</h5>
		<div class="bbs-center">
			<div class="left">
				<div class="photoline">
					<a href="${data.RRD3[0].goUrl }" target="_blank"><img
						src="${picHost}${data.RRD3[0].picPath }"
						alt="${data.RRD3[0].title }" width="102" height="102" border="0"></a>
				</div>
			</div>
			<div class="left padleft10">
				<h5 class="todayt blue bold">
					<a href="${data.RRD3[1].goUrl }" title="${data.RRD3[1].title }"
						target="_blank">${data.RRD3[1].title }</a>
				</h5>
				<ul class="f14 black">
					<c:forEach items="${data.RRD3 }" var="hdata" begin="2" end="5" varStatus="status">
						<li><span class="miceli1"></span><a href="${hdata.goUrl }"
							title="${hdata.title }" target="_blank">${hdata.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div class="newtoday">
		<h5>
			<div class="right f12 blue">
				<a href="${basePath }plus/list.php?tid=${data.RRD4[0].itemId }"
					target="_blank">&gt;&gt;更多</a>
			</div>
			<span class="today-icon"></span><span class="f14 blue bold">${data.RRD4[0].itemName }</span>
		</h5>
		<div class="bbs-center">
			<div class="left">
				<div class="photoline">
					<a href="${data.RRD4[0].goUrl }" target="_blank"><img
						src="${picHost}${data.RRD4[0].picPath }"
						alt="${data.RRD4[0].title }" width="102" height="102" border="0"></a>
				</div>
			</div>
			<div class="left padleft10">
				<h5 class="todayt blue bold">
					<a
						href="${data.RRD4[1].goUrl }"
						title="${data.RRD4[1].title }" target="_blank">${data.RRD4[1].title }</a>
				</h5>
				<ul class="f14 black">
					<c:forEach items="${data.RRD4 }" var="hdata" begin="2" end="5" varStatus="status">
						<li><span class="miceli1"></span><a href="${hdata.goUrl }"
							title="${hdata.title }" target="_blank">${hdata.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div class="newtoday">
		<h5>
			<div class="right f12 blue">
				<a href="${basePath }plus/list.php?tid=${data.RRD5[0].itemId }"
					target="_blank">&gt;&gt;更多</a>
			</div>
			<span class="today-icon"></span><span class="f14 blue bold">${data.RRD5[0].itemName }</span>
		</h5>
		<div class="bbs-center">
			<div class="left">
				<div class="photoline">
					<a href="${data.RRD5[0].goUrl }" target="_blank"><img
						src="${picHost}${data.RRD5[0].picPath }"
						alt="${data.RRD5[0].title }" width="102" height="102" border="0"></a>
				</div>
			</div>
			<div class="left padleft10">
				<h5 class="todayt blue bold">
					<a href="${data.RRD5[1].goUrl }"
						title="${data.RRD5[1].title }" target="_blank">${data.RRD5[1].title }</a>
				</h5>
				<ul class="f14 black">
					<c:forEach items="${data.RRD5 }" var="hdata" begin="2" end="5" varStatus="status">
						<li><span class="miceli1"></span><a href="${hdata.goUrl }"
							title="${hdata.title }" target="_blank">${hdata.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div class="newtoday">
		<h5>
			<div class="right f12 blue">
				<a href="${basePath }plus/list.php?tid=${data.RRD6[0].itemId }"
					target="_blank">&gt;&gt;更多</a>
			</div>
			<span class="today-icon"></span><span class="f14 blue bold">${data.RRD6[0].itemName }</span>
		</h5>
		<div class="bbs-center">
			<div class="left">
				<div class="photoline">
					<a href="${data.RRD6[0].goUrl }" target="_blank"><img
						src="${picHost}${data.RRD6[0].picPath }"
						alt="${data.RRD6[0].title }" width="102" height="102" border="0"></a>
				</div>
			</div>
			<div class="left padleft10">
				<h5 class="todayt blue bold">
					<a
						href="${data.RRD6[1].goUrl }"
						title="${data.RRD6[1].title }" target="_blank">${data.RRD6[1].title }</a>
				</h5>
				<ul class="f14 black">
					<c:forEach items="${data.RRD6 }" var="hdata" begin="2" end="5" varStatus="status">
						<li><span class="miceli1"></span><a href="${hdata.goUrl }"
							title="${hdata.title }" target="_blank">${hdata.title }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>