package edu.iit.cs445.s2016.delectable;

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
	 	
	 	return cal1.DAY_OF_WEEK == Calendar.SATURDAY || cal1.DAY_OF_WEEK == Calendar.SUNDAY;
 }
 
 public static String todayAsString() {
	 
	 	Calendar cal1 = Calendar.getInstance();

	     return	"" +cal1.get(Calendar.YEAR) +cal1.get(Calendar.MONTH)+cal1.get(Calendar.DAY_OF_MONTH);
	 }
 
 public static String tomorrowAsString() {
	 
	 	Calendar cal1 = Calendar.getInstance();
	 	cal1.add(Calendar.DAY_OF_MONTH, 1);

	     return	"" +cal1.get(Calendar.YEAR) +cal1.get(Calendar.MONTH)+cal1.get(Calendar.DAY_OF_MONTH);
	 }
 
 public static String DateString(Date date) {
	 
	 	Calendar cal1 = Calendar.getInstance();
	 	cal1.setTime(date);
	 	
	     return	"" +cal1.get(Calendar.YEAR) +cal1.get(Calendar.MONTH)+cal1.get(Calendar.DAY_OF_MONTH);
	 }
}
