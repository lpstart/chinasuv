package cn.chinasuv.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.chinasuv.base.config.AppConfig;
import cn.chinasuv.base.database.tools.Pagination;
import cn.chinasuv.service.CommonService;
import cn.chinasuv.service.ItemService;

@Controller
public class ItemController extends BaseController{
	@Autowired CommonService commonService;
	@Autowired ItemService itemService;
	/**
	 * 二级列表显示
	 * @param model
	 * @param tid
	 * @return
	 */
	@RequestMapping(value="plus/list.php")
	public String list(ModelMap model, HttpServletRequest request, Long tid){
		commonService.headerDate(model);
		itemService.local(model, tid);
		Pagination pation = getPagination(request);
		itemService.articleList(pation, tid);
		model.put("pation", pation);
		return AppConfig.WebViewPrefix + "item";
	}
}
