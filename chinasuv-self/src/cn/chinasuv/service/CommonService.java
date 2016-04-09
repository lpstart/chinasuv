package cn.chinasuv.service;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import cn.chinasuv.base.config.AppConfig;
import cn.chinasuv.dao.ItemDao;
import cn.chinasuv.dao.ImageDao;
import cn.chinasuv.entity.Item;
import cn.chinasuv.entity.Picture;

@Repository
public class CommonService {
	@Autowired ItemDao itemDao;
	@Autowired ImageDao picDao;
	/**
	 * 获取top数据
	 */
	public void headerDate(ModelMap model){
		List<Item> pItems = itemDao.topItems(AppConfig.pid);
		List<Item> cItems = itemDao.topSecondItems(AppConfig.pid);
		List<Item> rightItems = itemDao.items(-2l);
		model.put("pItems", pItems);
		model.put("cItems", cItems);
		model.put("rightItems", rightItems);
		model.put("picHost", AppConfig.picHost);
	}
	
	public String getPic(Long id){
		Picture pic = picDao.get(id);
		return JSONObject.fromObject(pic).toString();
	}
}
