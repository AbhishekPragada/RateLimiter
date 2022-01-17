import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import org.junit.jupiter.api.Test;

class RLtest {

	@Test
	void test() {
		RateLimiter.req = 0;
		RateLimiter.bef_req = "17-01-2022 14:15:00";
		RateLimiter.aft_req= "17-01-2022 14:16:00";
		
		try {
			assertEquals(true , RateLimiter.checkRateLimiter(RateLimiter.req));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testPass() {
		RateLimiter.req = 7;
		RateLimiter.bef_req = "17-01-2022 14:15:00";
		RateLimiter.aft_req= "17-01-2022 14:16:00";
		
		try {
			assertEquals(true , RateLimiter.checkRateLimiter(RateLimiter.req));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testFail() {
		RateLimiter.req = 100;
		RateLimiter.bef_req = "17-01-2022 14:15:00";
		RateLimiter.aft_req= "17-01-2022 14:16:00";
		
		try {
			assertEquals(true , RateLimiter.checkRateLimiter(RateLimiter.req));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testPassMultiple() {
		RateLimiter.req = 70;
		RateLimiter.bef_req = "17-01-2022 14:15:00";
		RateLimiter.aft_req= "17-01-2022 14:20:00";
		
		try {
			assertEquals(true , RateLimiter.checkRateLimiter(RateLimiter.req));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testFailMultiple() {
		RateLimiter.req = 7777;
		RateLimiter.bef_req = "17-01-2022 14:15:00";
		RateLimiter.aft_req= "17-01-2022 14:20:00";
		
		try {
			assertEquals(true , RateLimiter.checkRateLimiter(RateLimiter.req));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
