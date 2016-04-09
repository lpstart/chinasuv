package cn.chinasuv.web;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinasuv.entity.Article;
import cn.chinasuv.service.ArticleService;
import cn.chinasuv.service.CommonService;
import cn.chinasuv.service.ItemService;

@Controller
public class ArticleController extends BaseController {
	Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	CommonService commonService;
	@Autowired
	ItemService itemService;
	@Autowired
	ArticleService articleService;

	/**
	 * 文章-图集详情
	 */
	@RequestMapping(value = "/article/{tid}/{id}.html")
	public String articleDetails(@PathVariable Long tid, @PathVariable Long id, ModelMap model) {
		commonService.headerDate(model);
		itemService.local(model, tid);
		return articleService.articleDetails(model, tid, id);
	}
	
	/**
	 *顶一下，踩一下 
	 */
	@RequestMapping(value = "/article/color.json")
	@ResponseBody
	public String colorArticle(HttpServletRequest request, Long id, int type){
		JSONObject json = new JSONObject();
		String ip = (String) request.getSession().getAttribute("IP");
		json.put("result", 1);
		json.put("IP", ip);
		if(StringUtils.isEmpty(ip)){
			ip = getCurrUserIP(request);
			request.getSession().setAttribute("IP", ip);
			json.put("IP", ip);
			int result = articleService.colorArticle(id, type);
			if(result > 0){
				json.put("result", 0);
				json.put("info", "操作成功");
				Article art = articleService.getArticleById(id);
				json.put("goodCount", art.getGoodCount());
				json.put("badCount", art.getBadCount());
			} else {
				json.put("info", "操作失败");
			}
		} else {
			json.put("info", "请不要重复提交");
		}
		logger.info(json.toString());
		return json.toString();
	}
}
