package cn.chinasuv.base.config;


public class AppConfig {

	/**
	 * 是否生成环境，正式、测试
	 */
	public static final boolean isProduct = false;

	/**
	 * 静态文件（图片）地址
	 */
	public static final String picHost = "http://localhost:8080/";
	/**
	 * 二级列表-文章默认图片
	 */
	public static final String plusDefPicPath = "upload/article-default-cover.jpg";
	/**
	 * 主题父ID定义
	 */
	public static final Long pid = 0l;

	public static final String AdminViewPrefix = "manage/";

	public static final String WebViewPrefix = "web/";

	public static final String articlePos = "/article/";

	public static final String articleRelative = "../../";

	/**
	 * 关于文章和图集中德图片的写路径，配置在了相关的类中
	 */

	public static final String staticFileServer = picHost;
	
	/**
	 * 上传图片存储的物理路径，也是nginx代理的路径
	 */
	public static final String PicPhysicalPath = "E:/ProgramData/nginx/";
	
	/**
	 * 文章jsp生成的物理路径
	 */
	public static final String ArticlePhysicalPath = "";
}