package edu.iit.cs445.s2016.delectable;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class CommonTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testDateString() {
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 1);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		
		Date date = myCal.getTime();
					
		assertTrue(Common.DateString(date).equals("20160201"));
	}

	@Test
	public void testIsSameDay() {
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 1);
		myCal.set(Calendar.DAY_OF_MONTH, 1);
		
		Date date = myCal.getTime();
		Date date2 = myCal.getTime();
		
		assertTrue(Common.isSameDay(date, date2));
		
	}

	@Test
	public void testIsWeekend() {
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 4);
		myCal.set(Calendar.DAY_OF_MONTH, 24);
		
		Date date = myCal.getTime();
		assertTrue(Common.isWeekend(date));

	}

	@Test
	public void testTodayAsString() {
		String today = Common.todayAsString();
		
		System.out.println(today);
		
		assertTrue(Common.isSameDay(new Date(), Common.StringToData(today)));
	}

	@Test
	public void testTomorrowAsString() {
		String tomorrow = Common.tomorrowAsString();
		
		System.out.println(tomorrow);
		
		assertFalse(Common.isSameDay(new Date(), Common.StringToData(tomorrow)));	
		}

	@Test
	public void testStringToDate() {
		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, 2016);
		myCal.set(Calendar.MONTH, 3);
		myCal.set(Calendar.DAY_OF_MONTH, 24);
		
		Date date = myCal.getTime();
		
		Date date2 = Common.StringToData("20160424");
		
		assertTrue(Common.isSameDay(date, date2));
		
	}

}
