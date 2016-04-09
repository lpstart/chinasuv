package cn.chinasuv.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.chinasuv.base.database.BaseDao;
import cn.chinasuv.entity.Item;

@Repository
public class ItemDao {
	@Autowired
	BaseDao baseDao;

	/**
	 * 得到该父item的所有子item
	 * 
	 * @param pid
	 * @return
	 */
	public List<Item> items(Long pid) {
		String sql = "SELECT * FROM main_item WHERE pid = ?";
		List<Item> list = baseDao.getList(Item.class, sql, new Object[] { pid });
		return list;
	}
	
	public Item getParentItem(Long itemId){
		String sql = "select * from main_item where id=(select pid from main_item where id=?)";
		return baseDao.get(Item.class, sql, new Object[]{itemId});
	}

	public List<Item> topItems(Long pid) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM (");
		sql.append("SELECT * FROM main_item WHERE pid = ? and isHeader=1) a JOIN");
		sql.append("(SELECT COUNT(*) itemCount,pid FROM main_item WHERE isHeader=1 GROUP BY pid) b");
		sql.append(" ON a.id = b.pid");
		List<Item> list = baseDao.getList(Item.class, sql.toString(), new Object[] { pid });
		return list;
	}

	public List<Item> topSecondItems(Long pid) {
		String sql = "SELECT * FROM main_item WHERE isHeader=1 and pid in(SELECT id FROM main_item WHERE pid = ?)";
		List<Item> list = baseDao.getList(Item.class, sql, new Object[] { pid });
		return list;
	}

	/**
	 * 取一个item的所有父菜单
	 * id,itemName,goUrl,pid,pItemName,pGoUrl,ppid,ppItemName,ppGoUrl
	 */
	public Map<String, Object> ppItem(Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT mi2.*,m.itemName ppItemName,m.goUrl ppGoUrl FROM(");
		sql.append(
				" SELECT a.id,a.itemName,a.goUrl,a.pid,mi1.itemName pItemName,mi1.goUrl pGoUrl,mi1.pid ppid FROM (SELECT * FROM main_item WHERE id = ?) a JOIN main_item mi1 on mi1.id=a.pid");
		sql.append(") mi2 JOIN main_item m ON mi2.ppid = m.id");
		Map<String, Object> map = baseDao.getJdbcTemplate().queryForMap(sql.toString(), new Object[] { id });
		return map;
	}

}
