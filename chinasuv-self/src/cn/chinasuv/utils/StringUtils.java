package cn.chinasuv.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtils {
	
	// 截取字符串的前bit位
	public static String cutString(String str,int bit){
		if(str==null) return "";
		if(str.trim().equals("")) return "";
		int len = str.trim().length();
		if(len>bit){
			return str.trim().substring(0, len-1);
		}else{
			return str.trim();
		}
	}
    
	/**
	 * <p>获得参数flag的值</p>
	 * @param 当前flag值
	 * @return 如果没有参数flag，返回0；反之，返回flag对应的值
	 */
	public static String filterFlag(String currFlag,String sourceFlag) {
		if(sourceFlag==null||"".equals(sourceFlag)) sourceFlag = "0";
		if(currFlag==null||"".equals(currFlag)) return sourceFlag;
		return currFlag;
	}
    
	
	public static Integer toInteger(String s){
		return toInteger(s , null);
	}
	
	public static Integer toInteger(String s,Integer defaultValue){
		if (s==null||"".equals(s.trim()))
			return defaultValue;
		try {
			return Integer.parseInt(s.trim()); 
		}catch(NumberFormatException nfe) {
			return defaultValue; 
		}
	}
	
	public static Long toLong(String s){
		return toLong(s , null);
	}
	
	public static Long toLong(String s,Long defaultValue){
		if (s==null||"".equals(s.trim()))
			return defaultValue;
		try {
			return Long.parseLong(s.trim()); 
		}catch(NumberFormatException nfe) {
			return defaultValue; 
		}
	}
	
	public static Float toFloat(String s){
		if (s==null||"".equals(s.trim()))
			return null;
		try {
			return Float.parseFloat(s.trim()); 
		}catch(NumberFormatException nfe) {
			return null; 
		}
	}
	
	public static Float toFloat(String s,Float defaultValue){
		if (s==null||"".equals(s.trim()))
			return defaultValue;
		try {
			return Float.parseFloat(s.trim()); 
		}catch(NumberFormatException nfe) {
			return defaultValue; 
		}
	}
	
	public static Double toDouble(String s){
		if (s==null||"".equals(s.trim()))
			return null;
		try {
			return Double.parseDouble(s.trim());
		}catch(NumberFormatException nfe) {
			return null; 
		}
	}
	
	public static Double toDouble(String s,Double defaultValue){
		if (s==null||"".equals(s.trim()))
			return defaultValue;
		try {
			return Double.parseDouble(s.trim());
		}catch(NumberFormatException nfe) {
			return defaultValue; 
		}
	}
	
	public static boolean isInt(String id) {
		if(id == null) 
			return false; 
		try {
			Integer.parseInt(id.trim()); 
		} catch(NumberFormatException nfe) {
			return false; 
		}
		return true; 
	}
	
	public static boolean isEmpty(String str) {
		if(str == null) 
			return true; 
		String tempStr = str.trim(); 
		if(tempStr.length() == 0)
			return true; 
		if(tempStr.equals("null"))
			return true;
		return false; 
	}

	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	/*分割字符串*/
    public static String[] splitStr(String str,char c)
    {
    	try {
    		str+=c;
    		int n=0;
    		for(int i=0;i<str.length();i++)
    		{
    			if(str.charAt(i)==c)n++;
    		}
    		
    		String out[] = new String[n];
    		
    		for(int i=0;i<n;i++)
    		{
    			int index = str.indexOf(c);
    			out[i] = str.substring(0,index);
    			str = str.substring(index+1,str.length());
    		}
    		return out;
			
		} catch (Exception e) {
		}
		return null;
    }
	
    // 替换
    public static String replace(String str, String pattern, String replace) {
	    int s = 0;
	    int e = 0;
	    StringBuffer result = new StringBuffer();
	
	    while ((e = str.indexOf(pattern, s)) >= 0) {
	        result.append(str.substring(s, e));
	        result.append(replace);
	        s = e+pattern.length();
	    }
	    result.append(str.substring(s));
	    return result.toString();
	}
    
    // 校验ip格式是否正确
    public static Boolean isIpAddress(String s){
         String regex = "(((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))";
         Pattern p = Pattern.compile(regex);
         Matcher m = p.matcher(s);
         return m.matches();
    }

    public static boolean isPatternInString(String targetString, String stringPattern) {
		if (targetString == null || stringPattern == null)
			return false;

		if (targetString.toLowerCase().indexOf(stringPattern.toLowerCase()) < 0)
			return false;

		return true;
	}
    
    public static String removeWhiteSpace(String str) {
		String res = null;
		
		if( str != null ) {
			char[] chars = str.toCharArray();
			res = "";
			
			for( int i = 0; i < chars.length; ++i ) {
				if( !Character.isWhitespace(chars[i]) ) {
					res += chars[i];
				}
			}
		}
		
		return res;
	}
    
    public static String getString(String s){
		if(isEmpty(s)){
			return "";
		}else{
			return s.trim();
		}
	}
    
    // 字符串替换，将 source 中的 oldString 全部换成 newString
    public static String replaceStr(String source, String oldString, String newString) {
        StringBuffer output = new StringBuffer();

        int lengthOfSource = source.length();   // 源字符串长度
        int lengthOfOld = oldString.length();   // 老字符串长度

        int posStart = 0;   // 开始搜索位置
        int pos;            // 搜索到老字符串的位置
        
        String lower_s=source.toLowerCase();		//不区分大小写
        String lower_o=oldString.toLowerCase();
        
        while ((pos = lower_s.indexOf(lower_o, posStart)) >= 0) {
            output.append(source.substring(posStart, pos));

            output.append(newString);
            posStart = pos + lengthOfOld;
        }

        if (posStart < lengthOfSource) {
            output.append(source.substring(posStart));
        }

        return output.toString();
    }
    
    public static String removeNull(String src) {
        if (src == null) {
            return "";
        }
        System.out.println(src);
        String res = src.replaceAll("null", "\"\"");
        System.out.println(res);
        return res;
    }
    
    public static void main(String[] args) throws Exception{
		String url1 = "http://122.11.42.243:8081/index.jhtml";
		System.out.println(filterFlag(url1,null));
		String url2 = "http://122.11.42.243:8081/index.jhtml?flag=1";
		System.out.println(filterFlag(url2,"0"));
		String url3 = "http://122.11.42.243:8081/index.jhtml?flag=2&kk=4";
		System.out.println(filterFlag(url3,null));
	}
}
