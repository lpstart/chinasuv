package cn.chinasuv.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.chinasuv.base.database.BaseDao;
import cn.chinasuv.base.database.tools.Pagination;
import cn.chinasuv.entity.Article;

@Repository
public class ArticleDao {
	@Autowired
	BaseDao baseDao;

	/**
	 * 文章或图集-未删除
	 */
	public Article get(Long id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", id);
		parameters.put("status", 0);
		Article article = baseDao.get(Article.class, parameters);
		parameters.clear();
		parameters = null;
		return article;
	}

	/**
	 * last article
	 */
	public Article getLast(Long itemId, Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT a.*,p.picPath FROM( ");
		sql.append(
				" SELECT IFNULL((SELECT id FROM main_article WHERE `status`=0 and itemId =? AND id>? ORDER BY id limit 1),(SELECT min(id) FROM main_article WHERE `status`=0 and itemId =?)) nid");
		sql.append(") na JOIN main_article a ON na.nid = a.id ");
		sql.append(" JOIN main_pic p WHERE p.id = a.picId ");
		return baseDao.get(Article.class, sql.toString(), new Object[] { itemId, id, itemId });
	}

	/**
	 * next article
	 */
	public Article getNext(Long itemId, Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT a.*,p.picPath FROM( ");
		sql.append(
				" SELECT IFNULL((SELECT id FROM main_article WHERE `status`=0 and itemId =? AND id<? ORDER BY id DESC limit 1),(SELECT max(id) FROM main_article WHERE `status`=0 and itemId =?)) nid");
		sql.append(") na JOIN main_article a ON na.nid = a.id ");
		sql.append(" JOIN main_pic p WHERE p.id = a.picId ");
		return baseDao.get(Article.class, sql.toString(), new Object[] { itemId, id, itemId });
	}

	/**
	 * 取文章详情-无论是否删除
	 */
	public Article getIgnoreStatus(Long id) {
		return baseDao.get(Article.class, id);
	}

	/**
	 * 更新文章观看次数
	 */
	public int updateViewCount(Long id) {
		String sql = "update main_article set viewCount = viewCount + 1 where id =?";
		return baseDao.getJdbcTemplate().update(sql, new Object[] { id });
	}
	
	/**
	 * 更新文章观看次数
	 */
	public int goodCountInc(Long id) {
		String sql = "update main_article set goodCount = goodCount + 1 where id =?";
		return baseDao.getJdbcTemplate().update(sql, new Object[] { id });
	}
	
	/**
	 * 更新文章观看次数
	 */
	public int badCountInc(Long id) {
		String sql = "update main_article set badCount = badCount + 1 where id =?";
		return baseDao.getJdbcTemplate().update(sql, new Object[] { id });
	}

	/**
	 * 删除，置顶，恢复文章
	 * 0表示文章正常  1表示文章删除
	 * 删除，恢复文章
	 */
	public int updateStatus(Long id, int status) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", status);
		int result = baseDao.update(Article.class, id, map);
		map.clear();
		map = null;
		return result;
	}

	/**
	 * 文章列表+分页
	 */
	public void pagList(Pagination pation, Long itemId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT art.*,p.picPath FROM (");
		sql.append(" SELECT a.id,a.title,a.summary,a.picId,a.viewCount,a.goodCount FROM main_article a WHERE a.itemId=? AND a.`status`=0");
		sql.append(") art left JOIN main_pic p ON art.picId = p.id order by art.id desc");
		List<Article> list = baseDao.queryPage(Article.class, sql.toString(), new Object[] { itemId },
				pation.getPageSize(), pation.getPageNo());
		pation.setList(list);
	}

	public int articleCount(Long itemId) {
		String sql = "SELECT count(*) FROM main_article a WHERE a.itemId=? AND a.`status` =0";
		return baseDao.queryForObject(sql, new Object[] { itemId }, Integer.class);
	}

	/**
	 * 获得所有的文章，包括删除了的和未删除的。
	 * 
	 * @return
	 */
	public List<Article> getAllArticleByItemId(Long itemId) {
		String sql = "select article.* from main_article as article where itemId=? and contentType=0";
		return baseDao.getList(Article.class, sql, new Object[] { itemId });
	}

	/**
	 * 插入一个article
	 * 
	 * @param article
	 * @return
	 */
	public int insertArticle(Article article) {
		String sql = "insert into main_article(id,itemId,title,summary,picId,content,contentType,createTime,upTime,resource,author,editor) values(:id,:itemId,:title,:summary,:picId,:content,:contentType,:createTime,:upTime,:resource,:author,:editor)";
		return new NamedParameterJdbcTemplate(baseDao.getJdbcTemplate()).update(sql,
				new BeanPropertySqlParameterSource(article));
	}
	/**
	 * 插入一个article
	 * 
	 * @param article
	 * @return
	 */
	public int updateArticle(Article article) {
		String sql = "update main_article set itemId=:itemId,title=:title,summary=:summary,picId=:picId,content=:content,contentType=:contentType,createTime=:createTime,upTime=:upTime,resource=:resource,author=:author,editor=:editor,status=0 where id=:id";
		return new NamedParameterJdbcTemplate(baseDao.getJdbcTemplate()).update(sql,
				new BeanPropertySqlParameterSource(article));
	}

	/**
	 * 根据文章的id得到这个article的相关信息
	 * 
	 * @param articleId
	 * @return
	 */
	public Article getArticleById(Long articleId) {
		String sql = "select article.*,main_pic.picPath from main_article as article left join main_pic on article.picId=main_pic.id where article.id=?";
		return baseDao.get(Article.class, sql, new Object[]{articleId});
		
	}
	
	/**
	 * 得到所有的图集，无论删除与否
	 * @param itemId
	 * @return
	 */
	public List<Article> getAllPicByItemId(Long itemId) {
		String sql = "select article.* from main_article as article where itemId=? and contentType=1";
		return baseDao.getList(Article.class, sql, new Object[] { itemId });
	}
	
}
