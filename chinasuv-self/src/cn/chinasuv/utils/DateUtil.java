package cn.chinasuv.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author Administrator
 *
 */
public class DateUtil {
	
	/**
	 * 获取指定日期的指定的格式的字符串格式
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getDateTime(Date date , String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
	
	public static Date parseDateToDate(Date date , String pattern) throws ParseException {
		return paraseDate(getDateTime(date, pattern) , pattern);
		
	}
	
	public static Date paraseDate(String str , String pattern) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(str);
	}
	
	/**
	 * 获取与当前日期相差指定月份的月份
	 * @return
	 */
	public static Calendar getSpecMonth(Integer diffMonth){
		
		Calendar nowCal = Calendar.getInstance();
		nowCal.add(Calendar.MONTH, diffMonth);
		
		return nowCal;
	}
	
	/**
	 * 获取当前时间的日
	 * @return
	 */
	public static Integer getNowDate(){
		
		Calendar nowCal = Calendar.getInstance();
		nowCal.setTime(new Date());
		int dayOfMonth = nowCal.get(Calendar.DAY_OF_MONTH);
		
		return dayOfMonth;
		
	}
	
	/**
	 * 获取指定日期的月份
	 * @param date
	 * @return
	 */
	public static Integer getMonth(Date date){
		
		Calendar nowCal = Calendar.getInstance();
		nowCal.setTime(date);
		int month = nowCal.get(Calendar.MONTH);
		
		return month + 1;
		
	}
	
	/**
	 * 计算两个日期相差多少个月
	 * @return
	 */
	public static int diffMonth(Date startDate , Date endDate){
		
		Long startTime = startDate.getTime();
		Long endTime = endDate.getTime();
		Long diffTime = endTime - startTime ;
		
		if(diffTime < 0){
			return -1 ;
		}
		
		return Integer.parseInt(String.valueOf(diffTime / (60 * 60 * 24 * 30)));
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Calendar calendar = getSpecMonth(0);
		
		System.out.println(paraseDate("2014-1-28" , "yyyy-MM-dd"));
	}
	/** 
     * 计算两个日期之间相差的天数 
     * @param date1 小
     * @param date2 大
     * @return 
	 * @throws ParseException
     */  
    public static int daysBetween (Date smdate,Date bdate) throws ParseException
    {  
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));   
        bdate=sdf.parse(sdf.format(bdate));   
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);     
        long time1 = cal.getTimeInMillis();                  
        cal.setTime(bdate);     
        long time2 = cal.getTimeInMillis();          
        long between_days=(time2-time1)/(1000*3600*24);     
        return Integer.parseInt(String.valueOf(between_days));
    }  
    /**
     * 得到几天后的时间
     */
    public static Date getDateAfter(Date d, int day) {
	  Calendar now = Calendar.getInstance();
	  now.setTime(d);
	  now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
	  return now.getTime();
	 }
    
    /**
     * 获取当天凌晨时间
     * @author wuqiang   
     */
    public static Date getMorningDate(Date d){
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	String str = df.format(d);
    	Date m = null;
    	try {
			 m = df.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return m;
    }
}





















