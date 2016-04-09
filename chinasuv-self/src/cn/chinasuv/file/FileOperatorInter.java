package cn.chinasuv.file;

import java.io.IOException;
import java.io.InputStream;

import com.baidu.ueditor.define.State;

public interface FileOperatorInter {
	String write(String relativeDir, String suffix, InputStream inputStream) throws IOException;

	State delete(String filePath);
}
