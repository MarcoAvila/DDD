package org.marcoavila.ddd.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 
 * @author Marco Avila
 */

public class DatesUtil {

    private static final long HOUR_DURATION = 1000 * 60 * 60;
    
    private static final long DAY_DURATION = HOUR_DURATION * 24;
   
   
   
   
   
   
   
   
   
   
   
   
    public static String format(Calendar calendar) {
           
        return calendar != null ?
               new SimpleDateFormat("dd/MM/yyyy").format( calendar.getTime() ) : "";
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

   
    public static Calendar now() {
        return Calendar.getInstance();
    }
   
   
    public static Calendar today() {
        return Calendar.getInstance();
    }
   
   
   
   
   

   
   
   
   
   
   
   
   
   
    public static Calendar daysAgo(int days) {
       
        Calendar day = Calendar.getInstance();
       
        day.add(Calendar.DATE, -days);
       
        return day;
    }
   
   
   
   
   
   
   
   
    public static Calendar daysAgo(Calendar date, int days) {
               
        Calendar day = (Calendar)date.clone();
       
        day.add(Calendar.DATE, -days);
       
        return day;
    }
   
   
   
   
   
   
   
   
   

   
   
    public static Calendar daysAhead(Calendar date, int days) {
               
        Calendar day = (Calendar)date.clone();
       
        day.add(Calendar.DATE, days);
       
        return day;
    }
   
   
   
   
   
   
   
   
   
   
   

   
   
    public static Calendar monthFirst() {
        Calendar day = today();
        day.set(Calendar.DATE, 1);
        return day;
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    public static Calendar todayDate() {
       
        Calendar today = Calendar.getInstance();
               
        today.setTimeInMillis( today.getTimeInMillis() - today.getTimeInMillis() % DAY_DURATION  );
       
        return today;
    }
   
   
   
   
   
   
   
   
   
   
   
   
   

   
   
    public static Boolean sameMonth(Calendar date1, Calendar date2) {       
        return date1.get(Calendar.YEAR)  == date2.get(Calendar.YEAR) &&
               date1.get(Calendar.MONTH) == date2.get(Calendar.MONTH);
    }
   
   

   
   
   
    
    
    
   
   
   
   
   
   
    public static Boolean onMonth(Calendar date) {           
        Calendar today = Calendar.getInstance();
        return date.get(Calendar.YEAR)  == today.get(Calendar.YEAR) &&
               date.get(Calendar.MONTH) == today.get(Calendar.MONTH);
    }
   
   
   
   

   
    
    

    
    public static Boolean sameDay(Calendar date1, Calendar date2) {       
        return date1.get(Calendar.DAY_OF_MONTH) == date2.get(Calendar.DAY_OF_MONTH) &&
               date1.get(Calendar.MONTH)        == date2.get(Calendar.MONTH) &&
               date1.get(Calendar.YEAR)         == date2.get(Calendar.YEAR);
    }
   
   

   
    
    
   
   
   
   
   
   
   
   
   
   
    public static Boolean past(Calendar date) {
        return date.before( today() );
    }
   
   
   
   
   
   
   

    public static Boolean pastDate(Calendar date) {
       
        Calendar c = (Calendar)date.clone();
       
        c.setTimeInMillis( c.getTimeInMillis() - c.getTimeInMillis() % DAY_DURATION  );
       
        return c.before( todayDate() );
    }
   
   
   
   
   
   
   
   
   
   

   
   
   
   
    public static Boolean future(Calendar date) {
        return date.after( today() );
    }
   
   

   
   
   
   
   
   
    public static Boolean futureDate(Calendar date) {

        Calendar c = (Calendar)date.clone();
       
        c.setTimeInMillis( c.getTimeInMillis() - c.getTimeInMillis() % DAY_DURATION  );
       
        return c.after( todayDate() );
    }
   
   
   
   
   
   

   
   
   
    public static Boolean notFuture(Calendar date) {
        return !future(date);
    }
   
   

   
   
   
   
   
   
    public static Boolean notFutureDate(Calendar date) {
        return !futureDate(date);
    }
   
   
   
   
   
   
   
   

   
   
   
   
    public static Boolean chronological(Calendar firstDate, Calendar secondDate) {
        return firstDate.before(secondDate);
    }
   
   
   
   

   
   
   
   
   
   
    public static Boolean notChronological(Calendar firstDate, Calendar secondDate) {
        return !firstDate.before(secondDate);
    }
   
   
   
   
   
   
   
   
   
   

    public static int daysCountSince(Calendar date) {
      
        long dateTime = date.getTimeInMillis();
      
        long todayTime = now().getTimeInMillis();
      
        long count = (todayTime - dateTime) / DAY_DURATION;
      
        return Long.valueOf(count).intValue();
    }
   
   
   
   

    
    
    
    
    
    
    
    

    public static int daysCountBetween(Calendar date1, Calendar date2) {
      
        long time1 = date1.getTimeInMillis();
      
        long time2 = date2.getTimeInMillis();
      
        long count = (time2 - time1) / DAY_DURATION;
      
        return Long.valueOf(count).intValue();
    }
   
   
   
   
    
    
    
    
    
    
    
   


    public static int truncatedDaysCountSince(Calendar date) {

        int timeZoneOffSet = TimeZone.getDefault().getRawOffset();
        
        long dateTime = (date.getTimeInMillis() + timeZoneOffSet) / 
        		DAY_DURATION;
      
        long todayTime = (now().getTimeInMillis() + timeZoneOffSet) / 
        		DAY_DURATION;
              
        return (int)(todayTime - dateTime);
    }
   
   
    
    
    



    public static int truncatedDaysBetween(Calendar date1, Calendar date2) {

        int timeZoneOffSet = TimeZone.getDefault().getRawOffset();
        
        long date1Time = (date1.getTimeInMillis() + timeZoneOffSet) /
        		DAY_DURATION;
      
        long date2Time = (date2.getTimeInMillis() + timeZoneOffSet) / 
        		DAY_DURATION;
      
        return (int)(date2Time - date1Time);
    }
   
   
   

   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   

   
   
   
    public static Boolean weekend(Calendar day) {

        int dayOfTheWeek = day.get(Calendar.DAY_OF_WEEK);
           
        return (dayOfTheWeek == Calendar.SATURDAY ||
                dayOfTheWeek == Calendar.SUNDAY);   
    }
   
   
   
   
   
   
   
   

    


    public static int hoursSince(Calendar date) {
      
        long dateTime = date.getTimeInMillis() / HOUR_DURATION;
      
        long todayTime = now().getTimeInMillis() / HOUR_DURATION;
      
        return (int)(todayTime - dateTime);
    }
   
   
   
   
   
   
   

   
   
    public static int age(Calendar birth) {
       
        int currentYear = today().get(Calendar.YEAR);
       
        int age = currentYear - birth.get(Calendar.YEAR);
       
        Calendar aniversary = (Calendar)birth.clone();
        aniversary.set(Calendar.YEAR, currentYear);
       
        if (today().before(aniversary))
            age--;
       
        return age;
    }
   
   
   
   
   
   
   
   

   
   
    public static int daysCount(int month, int year) {
       
        return calendarFor(1, month, year).getActualMaximum( Calendar.DAY_OF_MONTH );
    }
   
   
   
   
   

   
   
    public static Calendar calendarFor(int day, int month, int year) {
       
        return new GregorianCalendar(year, month, day);
    }
   
   
   
   


    
    
    public static Calendar calendarFor(Long time) {

    	if (time == null)
    		return null;
    	
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		
        return calendar;
    }
   
   
   
   
   
   
   
   
   
   
   
/*   
    //Teste
    public static void main(String[] a) throws InterruptedException {       
       
        Calendar c = Calendar.getInstance();
       
        Thread.sleep(1000);
       
        System.out.println( pastDate(c) );
    }
*/
   
   
   
   
   
   
   
   
   
   
}
