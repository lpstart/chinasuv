<%@ page language="java" pageEncoding="UTF-8"%>

<div id="footer">
	    <!--底部导航-->
		<div class="foot-nav f12 white">
		    <a href="${basePath }a/aboutus.html" title="关于我们" target="_blank">关于我们</a>
			<span class="foots">-</span>
			<a href="${basePath }a/links.html" title="合作伙伴" target="_blank">合作伙伴</a>
			<span class="foots">-</span>
			<a href="${basePath }a/adservice.html" title="广告服务" target="_blank">广告服务</a>
			<span class="foots">-</span>
			<a href="${basePath }a/job.html" title="招聘信息" target="_blank">招聘信息</a>
			<span class="foots">-</span>
			<a href="${basePath }a/copyright.html" title="版权申明" target="_blank">版权申明</a>
			<span class="foots">-</span>
			<a href="${basePath }a/sitemap.html" title="网站地图" target="_blank">网站地图</a>
			<span class="foots">-</span>
			<a href="${basePath }a/contact.html" title="联系我们" target="_blank">联系我们</a>
		</div>
		<!--底部导航:end-->

		<!--友情链接-->

		<div class="foot-link">
		    <div class="foot-links">
			    <h5 class="f14 white bold">友情链接</h5>
				<ul class="f12 foot-gray">
					<li><a href="http://www.khdeu.com" target="_blank">和盛娱乐</a> </li><li><a href="http://auto.sina.com.cn/" target="_blank">新浪汽车</a> </li><li><a href="http://www.cxygo.com" target="_blank">新峰娱乐</a> </li><li><a href="http://www.chdeu.com" target="_blank">吉祥彩平台</a> </li><li><a href="http://www.pcauto.com.cn/" target="_blank">太平洋汽车网</a> </li><li><a href="http://www.bitauto.com/" target="_blank">易车网</a> </li><li><a href="http://autos.cn.yahoo.com/" target="_blank">雅虎汽车</a> </li><li><a href="http://auto.msn.com.cn/" target="_blank">MSN汽车</a> </li><li><a href="http://www.autohome.com.cn/" target="_blank">汽车之家</a> </li><li><a href="http://www.xcar.com.cn/" target="_blank">爱卡汽车网</a> </li><li><a href="http://www.che168.com/" target="_blank">车168</a> </li><li><a href="http://auto.china.com/" target="_blank">中华网汽车</a> </li><li><a href="http://www.cheshi.com/" target="_blank">网上车市</a> </li><li><a href="http://auto.ifeng.com/" target="_blank">凤凰汽车</a> </li><li><a href="http://www.chexun.com/" target="_blank">车讯网</a> </li><li><a href="http://www.baidu60.com/" target="_blank">人民网汽车</a> </li><li><a href="http://www.chooseauto.com.cn/" target="_blank">选车网</a> </li><li><a href="http://www.autofan.com.cn/" target="_blank">汽车之友</a> </li><li><a href="http://www.chnsuv.com/" target="_blank">联合越野</a> </li><li><a href="http://www.xgo.com.cn/" target="_blank">汽车点评网</a> </li><li><a href="http://www.ppbaidu.com/" target="_blank">第一车网</a> </li><li><a href="http://xz.xpcpu.com/" target="_blank">新车评网</a> </li><li><a href="http://auto.mop.com/" target="_blank">猫扑汽车</a> </li><li><a href="http://kk5m.com/" target="_blank">汽车观察</a> </li><li><a href="http://auto.qianlong.com/" target="_blank">千龙汽车</a> </li><li><a href="http://www.autocarcn.com/" target="_blank">动感驾驭</a> </li><li><a href="http://www.youku.com/" target="_blank">优酷</a> </li><li><a href="http://www.che310.com/" target="_blank">车人网</a> </li><li><a href="http://www.kk5m.com/" target="_blank">汽车消费者网</a> </li><li><a href="http://auto.china.com.cn/" target="_blank">中国汽车</a> </li><li><a href="http://www.bstylchang.com/" target="_blank"></a> </li><li><a href="http://www.djylc666.com/" target="_blank"></a> </li><li><a href="http://www.linxiaawt.com/" target="_blank"></a> </li><li><a href="http://www.junboguoji888.com/" target="_blank"></a> </li>
				</ul>
				<div class="blank15"></div>
				<h5 class="f14 white bold">战略合作品牌</h5>
				<ul class="f12 foot-gray">
					<li><a href="http://www.landrover.com/" target="_blank">路虎中国</a> </li><li><a href="http://www.salomon.com" target="_blank">萨洛蒙</a> </li><li><a href="http://www.suunto.cn" target="_blank">颂拓</a> </li><li><a href="http://www.midimidi.cn/html/midimusic/" target="_blank">迷笛音乐节</a> </li><li><a href="http://www.wwfchina.org/" target="_blank">世界自然基金会</a> </li><li><a href="http://www.harley-davidson.cn/" target="_blank">哈雷戴维森</a> </li><li><a href="http://www.dunlop.com.cn/" target="_blank">邓禄普轮胎</a> </li>
				</ul>
			</div>
		</div>
		<!--友情链接:end-->

<script>
$(document).ready(function(){
	$("#suv_email").focusin(function(){
		if($(this).val() == "请输入您的E-mail地址"){
			$(this).val('');
			$(this).css("color", "#000");
		}
	});

	$("#suv_email").focusout(function(){
		if($(this).val() == ""){
			$(this).val('请输入您的E-mail地址');
			$(this).css("color", "#CECECE");
		}
	});	
});

function check_email(order_link){
	var email = $(order_link).parent().prev().children("input").val();
	if(email == "请输入您的E-mail地址"){
		alert("请填写邮箱地址！");
		return;
	}
	var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;  
	flag = pattern.test(email);  
	if(flag) {  
		location.href = "subscribe.php?email=" + email;
		return true;  
	} else {  
		alert("邮箱格式不正确！");
		return false;  
	}
}
</script>
		<!--订阅-->
		<div class="foot-dy textcen">
		    <div class="foot-dys f12 black">
				<span class="left"><input id="suv_email" type="text" value="请输入您的E-mail地址"></span>
				<span class="foot-subscribe1">
					<a href="javascript:void(0);" onclick="check_email(this)">订阅</a>
				</span>　
				<!--<span class="foot-subscribe2"></span>-->
				<script src="http://v7.cnzz.com/stat.php?id=4822074&amp;web_id=4822074" language="JavaScript"></script><script src="http://c.cnzz.com/core.php?web_id=4822074&amp;t=z" charset="utf-8" type="text/javascript"></script><a href="http://www.cnzz.com/stat/website.php?web_id=4822074" target="_blank" title="站长统计">站长统计</a>
				<div class="clear"></div>
			</div>
		</div>
		<!--订阅:end-->

		<!--版权所有-->

		<div id="urlss" style="display: none;">
       上海冠赢租车专业提供汽车租赁(www.5lcar.com)服务 以 “优质服务、顾客至上”的宗旨热忱为广大新老客户服务,付最少的费用,
享最好的服务!您的租车(www.9yzs.com)带来无穷的便利。本公司技术力量雄厚，经营租赁车辆种类齐全，具有奥迪A6、帕萨特、瑞风、捷达、别克、得利卡、金龙大巴等等一系列豪华车辆，
根据客户不同需求提供各种优质车辆，也为各大企业单位、机关部门及社会团体提供机场接送、商务用车、礼车及旅游包车长期或短期的汽车租赁业务(http://diaocha0451.com)</div>
<script>document.getElementById("urlss").style.display="none"</script>
<div class="foot-copyright f12 white">
		    <div class="blank15"></div>
			<p>中国SUV网互动传媒 &nbsp;&nbsp;&nbsp;&nbsp; 京ICP备05015059号</p>
			<p>Copyright© 2005-2014 <a href="http://www.chinasuv.cn" target="_blank">chinasuv.cn</a> Inc. All rights reserved</p>
			<p>北京市海淀区苏州街12号中湾国际G座911室</p>
			<p>邮编:100080 &nbsp;&nbsp;&nbsp;&nbsp; 总机:010-82113041</p>
			<p>传真:010-82113041转114 &nbsp;&nbsp;&nbsp;&nbsp; E-mail:chinasuv4x4@126.com</p>
			<div class="blank15"></div>
		</div>
		<!--版权所有:end-->

	</div>