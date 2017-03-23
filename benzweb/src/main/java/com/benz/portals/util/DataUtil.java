package com.benz.portals.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
	/**
	 * ����yyyy-MM-dd HH:mm:ss�ĸ�ʽ������ת�ַ���
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String date2Str(Date date){
		return date2Str(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * ���ղ���format�ĸ�ʽ������ת�ַ���
	 * @param date
	 * @param format
	 * @return
	 */
	public static String date2Str(Date date,String format){
		if(date!=null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}else{
			return "";
		}
	}
}
