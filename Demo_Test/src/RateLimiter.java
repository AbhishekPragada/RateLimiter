import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RateLimiter {
	
	static int req = 0;
	static String bef_req = "17-01-2022 14:15:00";
	static String aft_req = "17-01-2022 14:17:00";
	
	public static boolean checkRateLimiter(int requests) throws ParseException{
		Date beforeRequest = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(bef_req);
		long timebefreq = beforeRequest.getTime();
		
		Date afterRequest = new SimpleDateFormat("dd-MM-yyy HH:mm:ss").parse(aft_req);
		long timeaftreq = afterRequest.getTime();
		
		long time_diff = (timeaftreq - timebefreq) / 1000; // Time difference in seconds
		
		double requestsPerMinute = (double)(requests * 60) / (double)time_diff;
		requestsPerMinute = Math.round(requestsPerMinute*100.0)/100.0;
		
		if(requestsPerMinute <= 20) {
			System.out.println("Valid Request");
			return true;
		}
		else {
			System.out.println("Invalid Request");
			return false;
		}
	}
	
}
