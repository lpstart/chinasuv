package cn.chinasuv.admin.handler;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.ueditor.define.State;

import cn.chinasuv.admin.entity.ImageResp;
import cn.chinasuv.base.config.AppConfig;
import cn.chinasuv.base.database.BaseDao;
import cn.chinasuv.entity.Article;
import cn.chinasuv.entity.Item;
import cn.chinasuv.entity.Picture;
import cn.chinasuv.service.ArticleService;
import cn.chinasuv.service.ItemService;
import cn.chinasuv.service.ImageService;
import cn.chinasuv.utils.ImageUtils;
import cn.chinasuv.utils.JsonUtil;

@Controller
@RequestMapping(value = "/manage")
public class SysPicController {
	private String success = "success";
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ImageService imageService;

	@RequestMapping({ "/picHome.jhtml" })
	public String index(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		List<Item> topItems = itemService.getTopItems();
		List<Item> subItems = itemService.getSubItems(topItems.get(0).getId());
		// 得到所有的pid为0的Item分类。
		map.put("items", topItems);
		map.put("subItems", subItems);
		map.put("pics", articleService.getAllPicByItemId(subItems.get(0).getId()));
		return AppConfig.AdminViewPrefix + "pic/home";
	}

	@RequestMapping(value = "getPic.jhtml")
	public String getPic(@RequestParam(value = "item") Long topItem, @RequestParam(value = "subItem") Long itemId,
			Map<String, Object> map) {
		List<Item> topItems = itemService.getTopItems();
		map.put("topItem", topItem);
		map.put("subItem", itemId);
		map.put("items", topItems);
		map.put("subItems", itemService.getSubItems(topItems.get(0).getId()));
		map.put("pics", articleService.getAllPicByItemId(itemId));
		return AppConfig.AdminViewPrefix + "pic/home";
	}

	@RequestMapping(value = "editPic.jdo")
	public String toEdit(@RequestParam(value = "id") Long picId, Map<String, Object> map) {
		Article article = articleService.getArticleById(picId);
		Item topItem = itemService.getParentItem(article.getItemId());
		List<Picture> images = imageService.articlePics(article.getContent());
		for (Picture image : images) {
			image.setPicPath(AppConfig.staticFileServer + image.getPicPath());
		}
		if (article.getPicPath() != null) {
			article.setPicPath(AppConfig.staticFileServer + article.getPicPath());
		}
		article.setPicList(images);
		List<Item> topItems = itemService.getTopItems();
		List<Item> subItems = itemService.getSubItems(topItems.get(0).getId());
		// 得到所有的pid为0的Item分类。
		map.put("items", topItems);
		map.put("subItems", subItems);
		map.put("topItem", topItem);
		map.put("pic", article);
		return AppConfig.AdminViewPrefix + "pic/edit";

	}

	@ModelAttribute(value = "article")
	public Article preArticle(@RequestParam(value = "id", required = false) Long articleId,
			@RequestParam(value = "method", required = false) String method) {
		Article article = null;
		if (articleId != null && method != null && method.equalsIgnoreCase("edit_do")) {
			article = articleService.getArticleById(articleId);
		} else if (method != null && method.equalsIgnoreCase("edit_do")) {
			article = new Article();
		}
		return article;
	}

	@RequestMapping(value = "editPic_do.jdo")
	public String doEdit(@ModelAttribute(value = "article") Article article, Map<String, Object> map,
			HttpServletRequest httpServletRequest, HttpSession httpSession) {
		Date nowTime = new Date();
		article.setUpTime(nowTime);
		System.out.println(article);
		// 插入到数据库中
		articleService.updateArticle(article);
		return "redirect:/manage/picHome.jhtml";

	}

	@RequestMapping({ "/addPic.jhtml" })
	public String toAdd(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
		List<Item> topItems = itemService.getTopItems();
		List<Item> subItems = itemService.getSubItems(topItems.get(1).getId());
		// 得到所有的pid为0的Item分类。
		map.put("items", topItems);
		map.put("subItems", subItems);
		return AppConfig.AdminViewPrefix + "pic/add";
	}

	/**
	 * 图集上传
	 * 
	 * @param request
	 * @param response
	 * @param out
	 */
	@RequestMapping(value = "/uploadImg.jdo")
	public void imageUpload(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
		ImageResp resp = ImageUtils.uploadImage(request);
		if (success.equals(resp.getSuccess())) {// 图片上传成功
			Picture pic = new Picture();
			pic.setCreateTime(new Date());
			pic.setPicPath(resp.getPicPath());
			Long id = imageService.insertPicWithPid(pic);
			resp.setId(id + "");
		}
		out.print(JsonUtil.obj2Str(resp));
	}

	@RequestMapping(value = "getImgDetail.jhtml")
	@ResponseBody
	public String getImageDetail(Long imgId) {

		Picture picture = imageService.getImageById(imgId);
		System.out.println(picture.getRemark());
		String imgDescription = "{\"description\":\"" + picture.getRemark() + "\"}";
		return imgDescription;
	}

	@RequestMapping(value = "updateImgDetail.jdo")
	@ResponseBody
	public String updateImageDetail(Long imgId, String description) {
		System.out.println(imgId + " new 描述：" + description);
		Picture picture = imageService.getImageById(imgId);
		System.out.println(picture.getRemark());
		picture.setRemark(description);
		imageService.updatePic(picture);
		return "success";
	}

	@RequestMapping(value = "/deleteImg.jdo")
	public void imageDelete(String picPath, Long picId, PrintWriter out) {
		if (picPath != null && picId != null) {
			State state = ImageUtils.deleteImage(picPath);
			if (state.isSuccess()) {
				imageService.delePicByPid(picId);
			}
			out.print("success");
		}
	}

	@RequestMapping(value = "/deletePic.jdo")
	public String delete(@RequestParam(value = "id") Long picId) {
		articleService.deleteArticle(picId);
		return "redirect:/manage/picHome.jhtml";
	}

	@RequestMapping(value = "addPic_do.jdo")
	public String doAdd(@RequestParam(value = "title") String title, String resource, String author, String editor,
			Long picId, String topItem, String subItem, String summary, String content, Map<String, Object> map,
			HttpServletRequest httpServletRequest, HttpSession httpSession) {
		Date createTime = new Date();
		Article article = new Article(Long.parseLong(subItem), title, summary, picId, null, content.trim(), 1,
				createTime, createTime, resource, author, editor);
		// 插入到数据库中
		articleService.insertArticle(article);
		return "redirect:/manage/picHome.jhtml";
	}
}
