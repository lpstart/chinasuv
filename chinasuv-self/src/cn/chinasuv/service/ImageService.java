package cn.chinasuv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.chinasuv.dao.ImageDao;
import cn.chinasuv.entity.Picture;

@Service
public class ImageService {
	@Autowired
	private ImageDao imageDao;

	@Transactional
	public long insertPicWithPid(Picture picture) {
		return imageDao.insertPicWithPid(picture);

	}

	@Transactional
	public Boolean delePicByPid(Long imgId) {
		return imageDao.deletePicByPid(imgId);
	}

	@Transactional(readOnly = true)
	public Picture getImageById(Long imgId) {
		return imageDao.get(imgId);
	}

	@Transactional(readOnly = true)
	public List<Picture> articlePics(String imgIds) {
		return imageDao.articlePics(imgIds);
	}

	@Transactional
	public void updatePic(Picture picture) {
		imageDao.updatePic(picture);
	}

}
