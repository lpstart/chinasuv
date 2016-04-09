package cn.chinasuv.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.chinasuv.base.database.BaseDao;
import cn.chinasuv.entity.Home;

@Repository
public class HomeDao {
	@Autowired BaseDao baseDao;
		
	public List<Home> list(){
		String sql = "SELECT mh.*,mp.picPath,mi.itemName FROM(SELECT * FROM main_home ORDER BY location,sort desc) mh left JOIN main_pic mp ON mp.id = mh.picId LEFT JOIN main_item mi on mi.id=mh.itemId";
		return baseDao.getList(Home.class, sql, null);
	}
	
	public List<Home> adminList(){
		String sql = "SELECT mh.*,mp.picPath,mi.itemName FROM(SELECT * FROM main_home WHERE `status`=0 ORDER BY location,sort desc) mh left JOIN main_pic mp ON mp.id = mh.picId LEFT JOIN main_item mi on mi.id=mh.itemId";
		return baseDao.getList(Home.class, sql, null);
	}
	
	public Home get(Long id){
		return baseDao.get(Home.class, id);
	}
	
	public int updateEntity(Home home){
		String sql = "UPDATE main_home SET title=?,sort=?,picId=?,goUrl=? WHERE id=?";
		return baseDao.getJdbcTemplate().update(sql, new Object[]{home.getTitle(),home.getSort(),home.getPicId(),home.getGoUrl(),home.getId()});
	}
}
