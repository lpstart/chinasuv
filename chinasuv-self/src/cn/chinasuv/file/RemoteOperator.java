package cn.chinasuv.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import cn.chinasuv.base.config.AppConfig;

import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.State;

public class RemoteOperator implements FileOperatorInter {

	private static final String FILEROOTDIR = AppConfig.PicPhysicalPath;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM/dd");

	public State delete(String filePath) {
		BaseState state = new BaseState();
		File deleteFile = new File(FILEROOTDIR + "/" + filePath);
		if (deleteFile.exists()) {
			boolean flag = deleteFile.delete();
			if (flag) {
				state.setState(true);
			} else {
				state.setState(false);
				state.setInfo("删除失败。");
			}
		} else {
			state.setState(false);
			state.setInfo("指定文件不存在。");
		}
		return state;
	}

	/**
	 * 将一个InputStream写入到指定文件夹下的根据时间得到的子目录中，并返回文件的路径
	 * 
	 * @param relativeDir
	 *            指定文件夹
	 * @param suffix
	 *            文件后缀
	 * @param inputStream
	 *            文件流
	 * 
	 * @return
	 * @throws IOException
	 */
	public String write(String relativeDir, String suffix, InputStream inputStream) throws IOException {
		Calendar nowTime = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"), Locale.SIMPLIFIED_CHINESE);
		String midPath = relativeDir + getMidPath2(nowTime);
		String relativePath = midPath + "/" + nowTime.getTime().getTime() + suffix;
		File dir = new File(FILEROOTDIR + "/" + midPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(new File(FILEROOTDIR, relativePath));
		byte[] byteBuffer = new byte[1024];
		int hasRead = -1;
		while ((hasRead = inputStream.read(byteBuffer)) > 0) {
			fos.write(byteBuffer, 0, hasRead);
		}
		fos.close();
		inputStream.close();
		return relativePath;
	}

	private String getMidPath2(Calendar nowTime) {
		return dateFormat.format(nowTime.getTime());
	}

	public static void main(String args[]) {

	}

}
