<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${article.title }</title>
<link href="${basePath }css/album.css" rel="stylesheet" media="screen" type="text/css" />
<link href="${basePath }css/dedecms.css" rel="stylesheet" media="screen" type="text/css" />

<link href="${basePath }css/style.css" rel="stylesheet" type="text/css" />
<link href="${basePath }css/text.css" rel="stylesheet" type="text/css" />
<link href="${basePath }css/page.css" rel="stylesheet" type="text/css" />
<SCRIPT language="javascript" type="text/javascript" src="${basePath }js/sinaflash.js"></SCRIPT>
<SCRIPT language="javascript" type="text/javascript" src="${basePath }js/heiphoto.js"></SCRIPT>
<div id="containers">
<%@ include file="common/header.jsp"%>
<div class="w960 center clear mt1" style="margin:0px auto; width:1002px;background-color:#000000;">
	<!--导航条-->
	<div class="place" style="background-color:#000000; border:1px solid #000000;">
	 	<strong>当前位置:</strong> > <a href='${basePath }'>${ppItem.ppItemName }</a> > ${ppItem.pItemName } > <a href='${basePath }plus/list.php?tid=${ppItem.id }'>${ppItem.itemName }</a>
	</div>
	<!--导航条:end-->
	<div id="wrap">
		<div class="pic">
			<div class=eTitle>
				<H1><SPAN id=txtTitle>${article.title }</SPAN><SPAN id=total>(<SPAN class=cC00>0</SPAN>/0)</SPAN></H1>
			</div>
			<div class=eControl>
				<div class=ecCont>
					<div id=ecbSpeed>
						<div class=buttonCont id=ecbSpeedInfo>5秒</div>
					</div>
					<div id=ecbPre title=上一张>
						<div class=buttonCont></div>
					</div>
					<div id=ecbPlay>
						<div class=play id=ecpPlayStatus></div>
					</div>
					<div id=ecbNext title=下一张>
						<div class=buttonCont></div>
					</div>
					<div id=ecbLine>
						<div class=buttonCont></div>
					</div>
					<div id=ecbMode title=列表模式(tab)>
						<div class=buttonCont></div>
					</div>
					<div id=ecbModeReturn title=返回幻灯模式(tab)>
						<div class=buttonCont></div>
					</div>
					<div id=ecbFullScreen title=全屏浏览>
						<div class=buttonCont id=fullScreenFlash></div>
					</div>
				  	<!-- 速度条 begin -->
					<div id=SpeedBox>
						<div id=SpeedCont>
							<div id=SpeedSlide></div>
							<div id=SpeedNonius></div>
						</div>
					</div>
					<!-- 速度条 end -->
				</div>
			</div>
			<div id=eFramePic>
				<div id=efpBigPic>
				  <div id=efpClew></div>
				  <div id=d_BigPic></div>
				  <div class=arrLeft id=efpLeftArea title=上一张></div>
				  <div class=arrRight id=efpRightArea title=下一张></div>
				  <div id=endSelect>
				    <div id=endSelClose></div>
				    <div class=bg></div>
				    <div class=E_Cont>
				      <P>您已经浏览完所有图片</P>
				      <P><A id=rePlayBut href="javascript:void(0)"></A><A id=nextPicsBut href="javascript:void(0)"></A></P>
				    </div>
				  </div>
				  <!-- endSelect end -->
				</div>
				<div id=efpTxt>
					<div id=d_picTit></div>
					<div id=d_picTime></div>
					<div id=d_picIntro></div>
					<div class=others>
					时间:${article.createTime } | 浏览${article.viewCount }次</div> 
				</div>
				
				<div id=efpContent><div id="contentMidPicAD" style="float:right; clear:both; top:0; vertical-align:top; display:block"></div><div style="clear:both"></div></div>
				<div id=efpPicList>
				  <div id=efpPreGroup>
				    <div id=efpPrePic onmouseover="this.className='selected'" onmouseout="this.className=''">
				    <TABLE cellSpacing=0>
				      <TR>
				        <TD><a href='${basePath }article/${article.lastArt.itemId }/${article.lastArt.id }.html'><img width='100' height='85' src="${picHost }${article.lastArt.picPath}" alt="${article.lastArt.title }"/></a> </TD>
				      </TR>
				    </TABLE>
				  </div>
				  <div id=efpPreTxt><< 上一图集</div>
				</div>
				<div id=efpListLeftArr onMouseOver="this.className='selected'" onmouseout="this.className=''"></div>
				<div id=efpPicListCont></div>
				<div id=efpListRightArr onMouseOver="this.className='selected'" onmouseout="this.className=''"></div>
				<div id=efpNextGroup>
				  <div id=efpNextPic onmouseover="this.className='selected'" onmouseout="this.className=''">
				      <TABLE cellSpacing=0>
				        <TR>
				          <TD><a href='${basePath }article/${article.nextArt.itemId }/${article.nextArt.id }.html'><img width='100' height='85' src="${picHost }${article.nextArt.picPath}" alt="${article.nextArt.title }"/></a> </TD>
				        </TR>
				      </TABLE>
				    </div>
				    <div id=efpPreTxt>下一图集 >></div>
				  </div>
				</div>
			</div>
			<div id=ePicList></div>
      		<div id=eData style="DISPLAY: none">
      			<c:forEach var="pic" varStatus="status" items="${article.picList }">
      				<dl><dt><dd>${picHost}${pic.picPath }<dd>${picHost}${pic.picPath }<dd>${picHost}${pic.picPath }<dd><dd><div></div><div></div><dd><dd>${status.index + 1}</dd></dl>
      			</c:forEach>
 			</div>
<SCRIPT language=javascript type="text/javascript">
	var dataInfo = {
	    title : '${article.title}'
	};
	function echoFocus(){
	    var flashPic = "",flashTxt = "";
	    var newHref;
	    var datas = sina.$('eData').getElementsByTagName('dl');
	    for(var i=0;i<datas.length;i++){
	        try{
	            var title,pic,middlePic,smallPic,datetime,intro,commUrl;
	            title = datas[i].getElementsByTagName('dt');
	            if(title){
	                title = title[0].innerHTML;
	            }else{
	                title = 'null';
	            };
	            var info = datas[i].getElementsByTagName('dd');
	            if(info){
	                pic = info[0].innerHTML;
	                middlePic = info[1].innerHTML;
	                smallPic = info[2].innerHTML;
	                datetime = info[3].innerHTML;
	                intro = info[4].innerHTML;
	                commUrl = info[5].getElementsByTagName('a');
	                imageId = info[6].innerHTML;
	                commUrl = '';
	
	            };
	            epidiascope.add({
	                            src : pic,
	                            lowsrc_b : middlePic,
	                            lowsrc_s : smallPic,
	                            date : datetime,
	                            title : title,
	                            text : intro,
	                            comment : commUrl,
	                            id : imageId
	                        });
	            if(flashPic != ""){flashPic += "|"};
	            flashPic += encodeURIComponent(pic);
	            
	            if(flashTxt != ""){flashTxt += "|"};
	            flashTxt += encodeURIComponent(title) + "#" + encodeURIComponent(intro.replace(/<.*?>/g,'')); 
	        }catch(e){}
	    };
	    epidiascope.autoPlay = false;
	    epidiascope.init();
	    fullFlash(flashTxt,flashPic);
	    
	    if(Math.random()<=0.01){
	        epidiascope.stop();
	    };
	};
	function fullFlash(txt,pic){	
	    var flashurl = "${basePath}img/photo.swf";
	    var fullScreen = new sinaFlash(flashurl, "fullScreenObj", "100%", "100%", "8", "#000000");
	    fullScreen.addParam("quality", "best");
	    fullScreen.addParam("wmode", "transparent");
	    fullScreen.addParam("allowFullScreen", "true");
	    fullScreen.addParam("allowScriptAccess","always");
	    fullScreen.addVariable("mylinkpic", pic);		
	    fullScreen.addVariable("infotxt",dataInfo.title);
	    fullScreen.addVariable("mytxt",txt);
	    fullScreen.addVariable("fulls_btnx","0");
	    fullScreen.addVariable("fulls_btny","0");
	    fullScreen.addVariable("fulls_btnalpha","0")
	    fullScreen.write("fullScreenFlash");
	};
	function flash_to_js(name){
	    name = new String(name);
	    var status = name.split("|");
	    epidiascope.speedBar.setGrade(status[1]);
	    epidiascope.select(parseInt(status[0]));
	};
	function js_to_flash(){
	    epidiascope.stop();
	    return epidiascope.selectedIndex + "|" + epidiascope.speedBar.grade;
	};
	var sendT = {
	    getHeader : function(){
	        return document.getElementById("txtTitle").innerHTML + '-' + document.getElementById("d_picTit").innerHTML;
	    },
	    getFirstImgSrc : function(){
	        if (document.getElementById("d_BigPic").getElementsByTagName("img")[0]){
	            return document.getElementById("d_BigPic").getElementsByTagName("img")[0].src;
	        }else{
	            return null;
	        }
	    }
	}
	echoFocus();
</SCRIPT>
 			<div style="clear:both "></div>
		</div>
    </div>
</div>
<%@ include file="common/footer.jsp"%>
</div>