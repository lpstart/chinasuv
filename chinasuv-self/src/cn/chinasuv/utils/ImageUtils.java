package cn.chinasuv.utils;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.baidu.ueditor.define.State;

import cn.chinasuv.admin.entity.ImageResp;
import cn.chinasuv.file.ImageImageOperator;

public class ImageUtils {
	private static String error = "error";
	private static ImageImageOperator imageImageOperator = new ImageImageOperator();

	public static ImageResp uploadImage(HttpServletRequest request) {
		ImageResp resp = new ImageResp();
		boolean isAjaxUpload = request.getHeader("X_Requested_With") != null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			resp.setSuccess(error);
			return resp;
		}
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			if (isAjaxUpload) {
				upload.setHeaderEncoding("UTF-8");
			}
			upload.setSizeMax(1000 * 1024 * 1024); // 设置允许用户上传文件大小,单位:字节
			// 开始读取上传信息
			List<FileItem> fileItems = upload.parseRequest(request);
			Iterator<FileItem> iter = fileItems.iterator(); // 依次处理每个上传的文件
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();// 忽略其他不是文件域的所有表单信息
				if (!item.isFormField()) {
					try {
						String filename = item.getName();
						String suffix = filename.substring(filename.lastIndexOf("."));
						String relativeFilePath = imageImageOperator.write(suffix, item.getInputStream());
						// 设置文件名
						resp.setName(relativeFilePath.substring(relativeFilePath.lastIndexOf("/") + 1));
						// 设置上传路径
						resp.setPicPath(relativeFilePath);
					} catch (Exception e) {
						resp.setSuccess(error);
					}
				} else {
					// 取出不是文件域的所有表单信息

					//System.out.println(item.getFieldName() + "  :  " + item.getString());
				}
			}
		} catch (Exception e) {
			resp.setSuccess(error);
		}
		return resp;
	}

	public static State deleteImage(String filePath) {
		return imageImageOperator.delete(filePath);
	}

}
