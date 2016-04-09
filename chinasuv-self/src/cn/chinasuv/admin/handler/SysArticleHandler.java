package cn.chinasuv.admin.handler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.chinasuv.base.config.AppConfig;
import cn.chinasuv.entity.Article;
import cn.chinasuv.entity.Item;
import cn.chinasuv.service.ArticleService;
import cn.chinasuv.service.ItemService;

@Controller
@RequestMapping("/manage")
public class SysArticleHandler {
	private static String pageAssert = "<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8'%>\n";
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "articleHome.jdo")
	public String toHome(Map<String, Object> map) {
		List<Item> topItems = itemService.getTopItems();
		List<Item> subItems = itemService.getSubItems(topItems.get(0).getId());
		// 得到所有的pid为0的Item分类。
		map.put("items", topItems);
		map.put("subItems", subItems);
		map.put("articles", articleService.getAllArticleByItemId(subItems.get(0).getId()));
		return AppConfig.AdminViewPrefix + "article/home";
	}

	@ResponseBody
	@RequestMapping(value = "getSubItems.jdo")
	public List<Item> getSubItem(@RequestParam(value = "itemId") Long itemId) {
		return itemService.getSubItems(itemId);
	}

	@RequestMapping(value = "getArticle.jdo")
	public String getArticle(@RequestParam(value = "subItem") Long itemId, Map<String, Object> map) {
		List<Item> topItems = itemService.getTopItems();
		map.put("items", topItems);
		map.put("subItems", itemService.getSubItems(topItems.get(0).getId()));
		map.put("articles", articleService.getAllArticleByItemId(itemId));
		return AppConfig.AdminViewPrefix + "article/home";
	}

	@RequestMapping(value = "addArticle.jdo")
	public String toAdd(Map<String, Object> map) {
		List<Item> topItems = itemService.getTopItems();
		map.put("items", topItems);
		map.put("subItems", itemService.getSubItems(topItems.get(0).getId()));
		return AppConfig.AdminViewPrefix + "article/add";
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

	@RequestMapping(value = "editArticle_do.jdo")
	public String doEdit(@ModelAttribute(value = "article") Article article, String new_content,
			HttpSession httpSession, Map<String, Object> map) {
		System.out.println(article);
		Date nowTime = new Date();
		article.setUpTime(nowTime);

		articleService.updateArticle(article);
		// 将新内容写入文件中
		writeArticleToFile(article.getContent(), new_content, httpSession);

		article.setPicPath(AppConfig.staticFileServer + article.getPicPath());
		map.put("article", article);
		
		return AppConfig.AdminViewPrefix + "article/articlePreview";
	}

	@RequestMapping(value = "editArticle.jdo")
	public String toEdit(@RequestParam(value = "id") Long articleId, Map<String, Object> map) {
		System.out.println("to edit:" + articleId);
		Article article = articleService.getArticleById(articleId);
		article.setPicPath(AppConfig.staticFileServer + article.getPicPath());
		Item topItem = itemService.getParentItem(article.getItemId());
		List<Item> topItems = itemService.getTopItems();
		System.out.println(article);
		map.put("article", article);
		map.put("items", topItems);
		map.put("topItem", topItem);
		map.put("subItems", itemService.getSubItems(topItem.getId()));
		return AppConfig.AdminViewPrefix + "article/edit";
	}

	@RequestMapping(value = "deleteArticle_do.jdo")
	public String delete(@RequestParam(value = "id") Long articleId) {
		System.out.println("delete" + articleId);
		articleService.deleteArticle(articleId);
		return "redirect:articleHome.jdo";
	}

	@RequestMapping(value = "addArticle_do.jdo")
	public String doAdd(@RequestParam(value = "title") String title, String resource, String author, String editor,
			Long picId, String picPath, String topItem, String subItem, String summary, String content,
			Map<String, Object> map, HttpServletRequest httpServletRequest, HttpSession httpSession) {
		Date createTime = new Date();
		String tempName = createTime.getTime() + ".jsp";
		String relativePathFile = AppConfig.articlePos + topItem + "/" + subItem + "/" + tempName;

		writeArticleToFile(relativePathFile, content, httpSession);
		System.out.println(picId + "  --->   " + picPath);

		// 获取系统相对应用文件的相对于web站点的目录
		System.out.println(relativePathFile);
		Article article = new Article(Long.parseLong(subItem), title, summary, picId, picPath, relativePathFile, 0,
				createTime, createTime, resource, author, editor);
		// 插入到数据库中
		articleService.insertArticle(article);
		article.setPicPath(AppConfig.staticFileServer + article.getPicPath());
		map.put("article", article);
		System.out.println(article);
		// return "redirect:articleHome.jdo";
		return AppConfig.AdminViewPrefix + "article/articlePreview";
	}

	private void writeArticleToFile(String relativePathFile, String content, HttpSession httpSession) {
		// 把文件写入到系统文件中
		File jspFiles = new File(httpSession.getServletContext().getRealPath("/") + relativePathFile);
		if (!jspFiles.getParentFile().exists()) {
			jspFiles.getParentFile().mkdirs();
		}
		try {
			// 按照utf-8的编码写入文件中
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(jspFiles, false), "utf-8"));
			writer.write(pageAssert);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
