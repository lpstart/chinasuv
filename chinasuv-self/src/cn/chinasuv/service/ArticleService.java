package cn.chinasuv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import cn.chinasuv.base.config.AppConfig;
import cn.chinasuv.dao.ArticleDao;
import cn.chinasuv.dao.ImageDao;
import cn.chinasuv.entity.Article;
import cn.chinasuv.entity.Picture;

@Repository
public class ArticleService {
	@Autowired
	ArticleDao articleDao;
	@Autowired
	ImageDao imageDao;

	/**
	 * 获取文章-图集详情
	 */
	@Transactional
	public String articleDetails(ModelMap model, Long itemId, Long id) {
		articleDao.updateViewCount(id);

		String returnPage;
		Article article = articleDao.get(id);
		if (article.getContentType() == Article.ATLAS) {
			returnPage = "atlas";
			// 图集
			List<Picture> list = imageDao.articlePics(article.getContent());
			article.setPicList(list);
		} else {
			returnPage = "article";
		}
		article.setLastArt(articleDao.getLast(itemId, id));
		article.setNextArt(articleDao.getNext(itemId, id));
		model.put("article", article);
		return AppConfig.WebViewPrefix + returnPage;
	}
	
	/**
	 * 顶贴或踩贴
	 * @param id
	 * @param type 1顶  2踩
	 * @return
	 */
	public int colorArticle(Long id,int type){
		if(type == 1){
			return articleDao.goodCountInc(id);
		} else {
			return articleDao.badCountInc(id);
		}
	}

	/**
	 * 
	 * @param itemId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Article> getAllArticleByItemId(Long itemId) {
		return articleDao.getAllArticleByItemId(itemId);
	}

	@Transactional
	public int insertArticle(Article article) {
		return articleDao.insertArticle(article);
	}

	@Transactional
	public int updateArticle(Article article) {
		return articleDao.updateArticle(article);
	}

	@Transactional
	public int deleteArticle(Long articleId) {
		return articleDao.updateStatus(articleId, 1);
	}

	/**
	 * 根据articleId获取article的相关信息
	 * 
	 * @param articleId
	 * @return
	 */
	@Transactional(readOnly = true)
	public Article getArticleById(Long articleId) {
		return articleDao.getArticleById(articleId);
	}
	
	
	/**
	 * dedao 所有的图集，无论删除与否
	 * @param itemId
	 * @return
	 */
	public List<Article> getAllPicByItemId(Long itemId){
		return articleDao.getAllPicByItemId(itemId);
	}
	
	

}
