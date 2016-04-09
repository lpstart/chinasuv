package cn.chinasuv.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.chinasuv.base.database.BaseDao;
import cn.chinasuv.entity.Picture;

@Repository
public class ImageDao {
	@Autowired
	BaseDao baseDao;

	public Picture get(Long id) {
		return baseDao.get(Picture.class, id);
	}

	public int insert(Picture pic) {
		return baseDao.insert(pic);
	}

	public Boolean deletePicByPid(Long picId) {
		if (baseDao.delete(Picture.class, picId) > 0)
			return true;
		else
			return false;
	}

	public int insertPic(Picture pic) {
		String sql = "insert into main_pic(picPath,smallPicPath,createTime,remark) values(:picPath,:smallPicPath,:createTime,:remark)";
		return new NamedParameterJdbcTemplate(baseDao.getJdbcTemplate()).update(sql,
				new BeanPropertySqlParameterSource(pic));
	}

	public List<Picture> articlePics(String ids) {
		String sql = "select * from main_pic where id in(" + ids + ")";
		return baseDao.getList(Picture.class, sql, null);
	}

	public long insertPicWithPid(Picture picture) {
		return baseDao.insertWhitDesc(picture);

	}

	public int updatePic(Picture picture) {
		String sql = "update main_pic set picPath=:picPath,smallPicPath=:smallPicPath,createTime=:createTime,remark=:remark where id=:id";
		return new NamedParameterJdbcTemplate(baseDao.getJdbcTemplate()).update(sql,
				new BeanPropertySqlParameterSource(picture));
	}

}
