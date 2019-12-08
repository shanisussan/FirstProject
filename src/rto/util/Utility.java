package rto.util;
import java.util.*;
public class Utility
{
	
		public static String getCurrentdate(Calendar cal)
		{
        String Current_date=cal.get(Calendar.DATE)+"/" +(cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
        return Current_date;
		}
		public static String getExpiredate(Calendar cal)
		{	
		cal.add(Calendar.DATE, 30);
        String Expire_date=cal.get(Calendar.DATE)+"/" +(cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR);
        return Expire_date;
		}
		public static void main(String args[])
		{
			Calendar cal = Calendar.getInstance();
	        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
			getCurrentdate(cal);
	        getExpiredate(cal);
		}
}
