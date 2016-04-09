package cn.chinasuv.file;

import java.io.IOException;
import java.io.InputStream;

public class ArticleImageOperator {
	private static final String relativePathDir = "article/image/";
	private FileOperatorInter fileWritor = new RemoteOperator();

	public void setFilWritorInter(FileOperatorInter fileWritor) {
		this.fileWritor = fileWritor;
	}

	public String write(String suffix, InputStream inputStream) throws IOException {
		return fileWritor.write(relativePathDir, suffix, inputStream);
	}

}
