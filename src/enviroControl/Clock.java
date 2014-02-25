package enviroControl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Clock {
	/**
	 * Clock creates date, cal and creationDate
	 */
	private Date date;
	private Calendar cal;
	private Date creationDate;
	/**
	 * This is a constructor for clock that takes
	 * a string argument and creates a calendar date
	 * and formats it to correct format.
	 * @param timeDay
	 * @throws ParseException
	 */
	public Clock(String timeDay) throws ParseException	{
		SimpleDateFormat df = new SimpleDateFormat("EEE hh:mma");
		creationDate = df.parse(timeDay);
		date = df.parse(timeDay);
		cal = new GregorianCalendar();
		cal.setTime(date);
	}
	/**
	 * Null constructor for Clock class
	 * creates a new clock setting it equal to current system time
	 * and formats it in correct format
	 */
	public Clock()	{
		cal = new GregorianCalendar();
		creationDate = cal.getTime();
		SimpleDateFormat df = new SimpleDateFormat("EEE hh:mma");
		System.out.println(df.format(creationDate));		
	}
	/**
	 * method prints time to console
	 */
	public void displayTime(){
	SimpleDateFormat df = new SimpleDateFormat("EEE hh:mma");
	System.out.println(df.format(creationDate));
	}
	/**
	 * returns a boolean value based on input time and current time
	 * if the input time is less than or equal to the current time
	 * the method returns true (current time is equal or greater than timer)
	 * @param compDate
	 * @return
	 * @throws ParseException
	 */
	public boolean compTime(String compDate) throws ParseException {
		SimpleDateFormat tf = new SimpleDateFormat("hh:mma");
		SimpleDateFormat df = new SimpleDateFormat("EEE");
		//Date creationDate = new Date();
		boolean test = false;

		String day = compDate.substring(0, 3);
		String compTime = compDate.substring(4);
		
		String currTime = tf.format(creationDate);
		Date currentTime = tf.parse(currTime);
		
		Date myTime = tf.parse(compTime);
		Date myDay = df.parse(day);
		
		String currDay = df.format(creationDate);
		Date currentDay = df.parse(currDay);

				
		if((myTime.compareTo(currentTime) <= 0) && myDay.equals(currentDay))	{
			test = true;
		}
		return test;
	}
	/**
	 * Method returns a string value of the time
	 * @return Day and Time in correct format
	 */
	public String getCurrentTime()	{
		//cal = new GregorianCalendar();
		//creationDate = cal.getTime();
		SimpleDateFormat date_format = new SimpleDateFormat("EEE hh:mma");
		return date_format.format(creationDate);
	}
	/**
	 * Method sets the timer to input time.
	 * Accepts a string argument that it converts to a 
	 * Date object.
	 * @param timeDay
	 * @throws ParseException
	 */
	public void setPreset(String timeDay) throws ParseException	{
		SimpleDateFormat df = new SimpleDateFormat("EEE hh:mma");
		date = df.parse(timeDay);
		cal = new GregorianCalendar();
		cal.setTime(date);
		
	}
}
