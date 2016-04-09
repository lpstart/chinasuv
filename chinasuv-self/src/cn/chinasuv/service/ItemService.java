package cn.chinasuv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import cn.chinasuv.base.database.tools.Pagination;
import cn.chinasuv.dao.ArticleDao;
import cn.chinasuv.dao.ItemDao;
import cn.chinasuv.entity.Item;

@Service
public class ItemService {
	@Autowired
	ItemDao itemDao;
	@Autowired
	ArticleDao articleDao;

	/**
	 * 二级页面-您的位置
	 */
	// @Transactional
	public void local(ModelMap model, Long itemId) {
		model.put("ppItem", itemDao.ppItem(itemId));
	}

	/**
	 * 二级页面-文章列表
	 */
	public void articleList(Pagination pation, Long itemId) {
		pation.setTotalCount(articleDao.articleCount(itemId));
		articleDao.pagList(pation, itemId);
	}

	/**
	 * 得到所有0级的item
	 * 
	 * @param pid
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Item> getTopItems() {
		return itemDao.items(0L);
	}

	/**
	 * 根据一个itemId找到他的父Item
	 * 
	 * @param subItemId
	 * @return
	 */
	@Transactional(readOnly = true)
	public Item getParentItem(Long subItemId) {
		return itemDao.getParentItem(subItemId);
	}

	/**
	 * 得到pid item的所有子item。
	 * 
	 * @param pid
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Item> getSubItems(Long pid) {
		return itemDao.items(pid);
	}

}
