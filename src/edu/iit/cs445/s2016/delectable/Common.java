package edu.iit.cs445.s2016.delectable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common {
 public static Date StringToData(String date){
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {

			Date result = formatter.parse(date);
			return result;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
 }
 
 public static boolean isSameDay(Date date1, Date date2) {
	 
 	Calendar cal1 = Calendar.getInstance();
 	cal1.setTime(date1);
 	
 	Calendar cal2 = Calendar.getInstance();
 	cal2.setTime(date2);
 	
 	
     if (cal1 == null || cal2 == null) {
         throw new IllegalArgumentException("The dates must not be null");
     }
     return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
             cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
             cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
 }
 
 public static boolean isWeekend(Date date){
		Calendar cal1 = Calendar.getInstance();
	 	cal1.setTime(date);	 	
	 	
	 	return cal1.get(Calendar.DAY_OF_WEEK) == cal1.get(Calendar.SATURDAY) || (cal1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
 }
 
 public static String todayAsString() {
	 return DateString(new Date());
}
 
 public static String tomorrowAsString() {
		 Date date = new Date();
		 Calendar c = Calendar.getInstance(); 
		 c.setTime(date); 
		 c.add(Calendar.DATE, 1);
		 date = c.getTime();
		 
		 return DateString(date);
	 }
 
 public static String DateString(Date date) {
	 
	 DateFormat df = new SimpleDateFormat("yyyyMMdd");
	 
	 return  df.format(date);
	 }
}
