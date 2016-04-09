package cn.chinasuv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import cn.chinasuv.dao.TopicSummaryDao;

@Repository
public class TopicService {
	@Autowired TopicSummaryDao topicSummaryDao;
	
	public void getTopicSummary(ModelMap model){
		model.put("topics", topicSummaryDao.getList());
	}
}
