package cn.chinasuv.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import cn.chinasuv.base.config.AppConfig;
import cn.chinasuv.dao.HomeDao;
import cn.chinasuv.dao.ImageDao;
import cn.chinasuv.dao.ItemDao;
import cn.chinasuv.entity.Home;
import cn.chinasuv.entity.Picture;

@Service
public class HomeService {
	@Autowired
	HomeDao homeDao;
	@Autowired
	ItemDao itemDao;
	@Autowired
	ImageDao imageDao;

	/**
	 * 获取首页数据
	 */
	public void indexDate(ModelMap model) {
		List<Home> list = homeDao.list();
		Map<String, List<Home>> data = new HashMap<String, List<Home>>();
		for (Home h : list) {
			for (String local : Home.LOCATIONS) {
				if (local.equalsIgnoreCase(h.getLocation())) {
					if (data.get(local) == null) {
						List<Home> lclList = new ArrayList<Home>();
						lclList.add(h);
						data.put(local, lclList);
					} else {
						data.get(local).add(h);
					}
					continue;
				}
			}
		}
		model.put("data", data);
	}

	/**
	 * 
	 */
	public Home getHome(Long id) {
		return homeDao.get(id);
	}

	/**
	* 
	*/
	public Home getHomeWithPicPath(Long id) {
		Home home = homeDao.get(id);
		Long picId = home.getPicId();
		if (picId != null) {
			Picture image = imageDao.get(picId);
			home.setPicPath(AppConfig.staticFileServer + image.getPicPath());
		}
		return home;
	}

	/**
	 * 管理平台获取主页数据
	 */
	public void manageIndexDate(ModelMap model, String location) {
		List<Home> list = homeDao.adminList();
		if (StringUtils.isNotEmpty(location)) {
			for (int j = list.size() - 1; j >= 0; j--) {
				Home h = list.get(j);
				String subLocal = subLocation(h.getLocation());
				if (location.equalsIgnoreCase(subLocal)) {

				} else {
					list.remove(h);
				}
			}
		}
		model.put("homeData", list);
	}

	public String subLocation(String local) {
		if (local.length() <= 3) {
			return local;
		} else if (local.length() == 4) {
			return local.substring(0, 3);
		} else {
			return local.substring(0, 4);
		}

	}

	public int editHome(Home home) {
		return homeDao.updateEntity(home);
	}
}
