package cn.chinasuv.file;

import java.io.IOException;
import java.io.InputStream;

import com.baidu.ueditor.define.State;

public class ImageImageOperator {
	private FileOperatorInter fileOperator = new RemoteOperator();
	private static final String relativePathDir = "image/";
	private FileOperatorInter fileWritor = new RemoteOperator();

	public void setFilWritorInter(FileOperatorInter fileWritor) {
		this.fileWritor = fileWritor;
	}

	public String write(String suffix, InputStream inputStream) throws IOException {
		return fileWritor.write(relativePathDir, suffix, inputStream);
	}

	public State delete(String filePath) {
		return fileOperator.delete(filePath);
	}

}
