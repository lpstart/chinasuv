<%@ page language="java" pageEncoding="UTF-8"%>
<script type="text/javascript" src="http://v3.jiathis.com/code/jiathis_r.js?move=0&btn=r8.gif" charset="utf-8"></script>

<div id="header">
		<div class="logo-flash1">
		    <div class="left logo" style="cursor: pointer;">
				<a href="home/index.php" title="中国suv网"><img src="img/logo.png"></a>
			</div>
			<div class="right" style="margin-top:10px; padding-right:10px;">
			    <a href="home/index.php" target="_blank"><img src="${picHost }upload/7129_1854305761.jpg" width="700" height="100" border="0"></a>
			</div>
		</div>
		<div class="navwap1">
		    <div class="nav">
		    	<c:forEach var="pi" varStatus="status" items="${pItems }">
		    		<c:if test="${status.index != 0 }">
		    			<div class="navline1"></div>
		    		</c:if>
			    	<c:if test="${ pi.itemCount <= 6}">
			    	<dl class="onedl">
			    	</c:if>
			    	<c:if test="${ pi.itemCount > 6}">
			    	<dl class="twodl">
			    	</c:if>
			    		<dt>${pi.itemName }</dt>
						<c:forEach var="item" varStatus="status" items="${cItems }">
							<c:if test="${ pi.id == item.pid}">
								<dd class="white"><a href="plus/list.php?tid=${item.id }" title="${item.itemName }" target="_blank">${item.itemName }</a></dd>
							</c:if>
						</c:forEach>
					</dl>
				</c:forEach>
			    
				<dl class="threedl f14 orange">
					<c:forEach var="ri" varStatus="status" items="${rightItems }">
						<p><a href="${ri.goUrl }" title="${ri.itemName }" target="_blank">${ri.itemName }</a></p>
					</c:forEach>
				</dl>
			</div>
		</div>
	</div>