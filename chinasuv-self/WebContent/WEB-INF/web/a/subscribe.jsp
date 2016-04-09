<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<title>用户新订阅杂志-中国第一家专业SUV车型平台</title>
<meta name="keywords" content="suv,豪华suv,舒适suv, suv活动, suv性能" />
<meta name="description" content="中国suv网是专门针对suv车型的平台，为suv爱好者提供" />

<link href="${basePath }css/style.css" rel="stylesheet" type="text/css" />
<link href="${basePath }css/subscribe.css" rel="stylesheet" type="text/css" />

<!-- 导航菜单 -->
<form action="http://www.chinasuv.cn//plus/__suv.php" method="post" onsubmit="return check_post();">
<div id="containers">
	<div class="blank10"></div>
	
	<div class="top-title">
	    <div class="right"><img src="${picHost }upload/chinasuv-2010-22.jpg" /></div>
		<h1 class="bold"><span class="red">《中国SUV周刊》</span>免费订阅申请表</h1>
		<p class="size-ga">欲成为<span class="red">《中国SUV周刊》</span>的订阅用户，请认真填写以下列表</p>
		<p class="size-ga">所有申请需经出版人审批方能订阅成功</p>
		<p class="size-ga">(申请者必须填写以下各项，请以中文填写)</p>
	</div>
	<p class="size-ga">
	    <input name="order_type" type="radio" value="本人希望免费收到一期《中国SUV周刊》" />
		本人希望免费收到一期<span class="red">《中国SUV周刊》</span>
	</p>
	<p class="size-ga">
	    <input name="order_type" type="radio" value="直接订阅" checked="checked" />
		直接订阅
	</p>
	<p class="size-ga">
	    <span class="bold">订阅年限：</span>
		<select name="order_long">
		  <option value="一年" selected="selected">一年</option>
		  <option value="两年">两年</option>
		  <option value="三年">三年</option>
		</select>
	</p>
	<div class="title-line bold f16 blue">基本资料</div>
	<p class="size-ga f12">
	    <span class="bold">您的姓名：</span>
		<input name="user_name" type="text" />
		<select name="sex">
		  <option value="先生" selected="selected">先生</option>
		  <option value="女士">女士</option>
		</select>
		<span id="name_sex_err" class="err"></span>
	</p>
	<p class="size-ga f12">
	    <span class="bold title-left">年龄：</span>
		<input name="age" type="text" size="10" />
		<span id="age_err" class="err"></span>
	</p>
	<p class="size-ga f12">
	    <span class="bold">所在城市：</span>
		<select name="city">
		  <option value="0" selected="selected">--请选择--</option>
		  <option value="北京">北京</option>
		  <option value="上海">上海</option>
		  <option value="天津">天津</option>
		  <option value="重庆">重庆</option>
		  <option value="福建">福建</option>
		  <option value="安徽">安徽</option>
		  <option value="甘肃">甘肃</option>
		  <option value="广东">广东</option>
		  <option value="广西">广西</option>
		  <option value="贵州">贵州</option>
		  <option value="海南">海南</option>
		  <option value="河北">河北</option>
		  <option value="黑龙江">黑龙江</option>
		  <option value="河南">河南</option>
		  <option value="湖北">湖北</option>
		  <option value="湖南">湖南</option>
		  <option value="内蒙古">内蒙古</option>
		  <option value="江苏">江苏</option>
		  <option value="江西">江西</option>
		  <option value="吉林">吉林</option>
		  <option value="辽宁">辽宁</option>
		  <option value="宁夏">宁夏</option>
		  <option value="青海">青海</option>
		  <option value="山西">山西</option>
		  <option value="山东">山东</option>
		  <option value="四川">四川</option>
		  <option value="西藏">西藏</option>
		  <option value="新疆">新疆</option>
		  <option value="云南">云南</option>
		  <option value="浙江">浙江</option>
		  <option value="陕西">陕西</option>
		  <option value="台湾">台湾</option>
		  <option value="香港">香港</option>
		  <option value="澳门">澳门</option>
		</select>
		<span id="city_err" class="err"></span>
	</p>
	<p class="size-ga f12">
	    <span class="bold">联系电话：</span>
		<input name="tel" type="text" size="40" />
		<span id="tel_err" class="err"></span>
	</p>
	<p class="size-ga f12">
	    <span class="bold title-left">传真：</span>
		<input name="fax" type="text" size="40" />
		<span id="tex_err" class="err"></span>
	</p>
	<p class="size-ga f12">
	    <span class="bold"> E-mail：</span>
		<input name="email" type="text" size="45" />
		<span id="email_err" class="err"></span>
	</p>
	<p class="size-ga f12">
	    <span class="bold">联系地址：</span>
		<input name="adds" type="text" size="60" />
		<span id="adds_err" class="err"></span>
	</p>
	<p class="size-ga f12">
		<span class="bold title-left">邮编：</span>
		<input name="post_no" type="text" />
		<span id="post_no_err" class="err"></span>
	</p>
	<div class="blank15"></div>
	<div class="title-line bold f16 blue">公司情况</div>
	<p class="size-ga f12">
	    <span class="bold">公司名称：</span>
		<input name="comp_name" type="text" size="60" />
		<span id="comp_name_err" class="err"></span>
	</p>
	<p class="size-ga f12">
		<span class="bold">行业类型：</span>
		<select name="job_type">
		  <option value="0" selected="selected">--请选择--</option>
		  <option value="制造">制造</option>
		  <option value="银行/金融/投资">银行/金融/投资</option>
		  <option value="保险">保险</option>
		  <option value="电信服务">电信服务</option>
		  <option value="信息系统/互联网服务/电子商贸">信息系统/互联网服务/电子商贸</option>
		  <option value="政府机构">政府机构</option>
		  <option value="交通运输/物流">交通运输/物流</option>
		  <option value="进出口贸易">进出口贸易</option>
		  <option value="批发/零售/分销/产品代理">批发/零售/分销/产品代理</option>
		  <option value="公用事业(水、电、煤气等)">公用事业(水、电、煤气等)</option>
		  <option value="饭店/旅游">饭店/旅游</option>
		  <option value="建筑">建筑</option>
		  <option value="房地产开发">房地产开发</option>
		  <option value="专业服务(法律、会计、认证管理等)">专业服务(法律、会计、认证管理等)</option>
		  <option value="商业咨询">商业咨询</option>
		  <option value="多元化企业">多元化企业</option>
		  <option value="学术及研发机构">学术及研发机构</option>
		  <option value="药物/医疗保健">药物/医疗保健</option>
		  <option value="其他">其他</option>
		</select>
		<span id="job_type_err" class="err"></span>
	</p>
	<p class="size-ga f12">
		<span class="bold">单位类型：</span>
		<select name="comp_type">
			<option value="0" selected="selected">--请选择--</option>
			<option value="国有企业">国有企业</option>
			<option value="外资企业 (含合资)">外资企业 (含合资)</option>
			<option value="民营或集体所有制企业">民营或集体所有制企业</option>
			<option value="中央、省、市政府机构">中央、省、市政府机构</option>
			<option value="上市股份制企业">上市股份制企业</option>
			<option value="其他">其他</option>
		</select>
		<span id="comp_type_err" class="err"></span>
	</p>
	
	<p class="size-ga f12">
	    <span class="bold">您的职位：</span>
		<select name="job">
			<option value="0" selected="selected">--请选择--</option>
			<option value="董事长、总裁、首席执行官、董事、企业所有人/合伙人">董事长、总裁、首席执行官、董事、企业所有人/合伙人</option>
			<option value="执行董事">执行董事</option>
			<option value="副总裁">副总裁</option>
			<option value="总经理、副总经理、部门主管/经理">总经理、副总经理、部门主管/经理</option>
			<option value="首席财务官、司库、财务总监、总会计师">首席财务官、司库、财务总监、总会计师</option>
			<option value="首席信息官、信息管理系统总监">首席信息官、信息管理系统总监</option>
			<option value="总工程师/高级工程师">总工程师/高级工程师</option>
			<option value="专业人员(律师、经济师、测量师、建筑师、教授等)">专业人员(律师、经济师、测量师、建筑师、教授等)</option>
			<option value="秘书长、副秘书长">秘书长、副秘书长</option>
			<option value="局长、副局长、司长、副司长">局长、副局长、司长、副司长</option>
			<option value="部长、副部长、部长助理">部长、副部长、部长助理</option>
			<option value="省长、副省长、市长、副市长">省长、副省长、市长、副市长</option>
			<option value="外长、副外长、研究所所长、副所长">外长、副外长、研究所所长、副所长</option>
			<option value="其他">其他</option>
		</select>
		<span id="job_err" class="err"></span>
	</p>
	<p class="size-ga f12">
		<span class="bold">您在公司负责：</span>
		<select name="job_pos">
			<option value="0" selected="selected">--请选择--</option>
			<option value="总公司管理">总公司管理</option>
			<option value="财务/会计/法律">财务/会计/法律</option>
			<option value="销售/市场/品牌">销售/市场/品牌</option>
			<option value="业务运作/生产/分销">业务运作/生产/分销</option>
			<option value="信息系统/技术管理">信息系统/技术管理</option>
			<option value="研究及开发">研究及开发</option>
			<option value="业务发展">业务发展</option>
			<option value="人事/人力资源/培训管理">人事/人力资源/培训管理</option>
			<option value="行政管理">行政管理</option>
			<option value="其他">其他</option>
		</select>
		<span id="job_pos_err" class="err"></span>
	</p>
	<p class="size-ga f12">
		<span class="bold f12">公司所制造的产品或提供的服务：</span>
		<select name="comp_server">
		  <option value="0" selected="selected">--请选择--</option>
		  <option value="电信/互联网系统及设备">电信/互联网系统及设备</option>
		  <option value="电信/互联网服务">电信/互联网服务</option>
		  <option value="消费类电子">消费类电子</option>
		  <option value="电脑/电脑系统/电子组件">电脑/电脑系统/电子组件</option>
		  <option value="交通设备/物流">交通设备/物流</option>
		  <option value="其他工商用机器设备">其他工商用机器设备</option>
		  <option value="企业/专业服务">企业/专业服务</option>
		  <option value="个人/消费者服务">个人/消费者服务</option>
		  <option value="食品及饮料">食品及饮料</option>
		  <option value="纺织/服饰/皮革/个人用品">纺织/服饰/皮革/个人用品</option>
		  <option value="石油/化工/药品">石油/化工/药品</option>
		  <option value="建筑材料/供应">建筑材料/供应</option>
		  <option value="礼品/家居用品">礼品/家居用品</option>
		  <option value="其他">其他</option>
		</select>
		<span id="comp_server_err" class="err"></span>
	</p>
	<p class="size-ga f12">
		<span class="bold f12">公司员工总数：</span>
		<select name="comp_num">
		  <option value="0" selected="selected">--请选择--</option>
		  <option value="1-99人">1-99人</option>
		  <option value="100-499人">100-499人</option>
		  <option value="500-999人">500-999人</option>
		  <option value="1,000-4,999人">1,000-4,999人</option>
		  <option value="5,000-9,999人">5,000-9,999人</option>
		  <option value="10,000-49,999人">10,000-49,999人</option>
		  <option value="50,000-99,999人">50,000-99,999人</option>
		  <option value="100,000人或以上">100,000人或以上</option>
		</select>
		<span id="comp_num_err" class="err"></span>
	</p>
	<p class="size-ga f12">
	    <span class="bold">公司地址：</span>
		<input name="comp_adds" type="text" size="60" />
		<span id="comp_adds_err" class="err"></span>
	</p>
	<p class="size-ga f12">
		<span class="bold title-left">邮编：</span>
		<input name="post_no2" type="text" />
		<span id="post_no2_err" class="err"></span>
	</p>
	<p class="size-ga f12">
		<span class="bold title-left">备注：</span>
  <p class="title-left">
    <textarea name="note" cols="60" rows="5"></textarea>
	<span id="note_err" class="err"></span>
  </p>
	</p>
	<!--  
	<p class="size-ga f12">
		<span class="red bold">验证码：</span>
		<input name="checkcode" type="text" />
		<img alt="点击我更换图片" title="点击我更换图片" onclick="this.src=this.src+'?'" id="validateimg" style="cursor: pointer;" src="/include/vdimgck.php">
		<span id="checkcode_err" class="err"></span>
	</p>-->
	<p class="center size-ga">
	    <input type="submit" name="Submit" value="提交资料" />
		<input class="botton-left" type="reset" name="Submit2" value="重置资料" />
	</p>
	<div class="blank15"></div>
</div>
</form>

<%@ include file="../common/footer.jsp"%>
