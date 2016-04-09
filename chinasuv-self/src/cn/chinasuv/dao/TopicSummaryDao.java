package cn.chinasuv.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.chinasuv.base.database.BaseDao;
import cn.chinasuv.entity.TopicSummary;

@Repository
public class TopicSummaryDao {
	@Autowired BaseDao baseDao;
	public List<TopicSummary> getList(){
		String sql = "SELECT ts.*,p.picPath FROM( SELECT * FROM main_topic_summary WHERE `status`=? ) ts JOIN main_pic p ON ts.picId = p.id;";
		return baseDao.getList(TopicSummary.class, sql, new Object[]{0});
	}
}
