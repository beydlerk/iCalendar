/**
 *The jUnit test class for the iCalendarDriver.java. 
 * 
 * @author Kevin Beydler, Chansen Hesia, Conner Higashino
 * @version ICS 314
 * @date 2/27/2016
 **/

//Import Preprocesser Directives
import java.util.*;
import java.io.*;
import java.text.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalendarTestCases 
{

	@Test //Standard test
	public void test() 
	{
		fail("Not yet implemented");
	}
	
	@Test 
	public final void testCalendar() 
	{
		Calendar calendarTest1 = new Calendar();
		assertNotNull(calendarTest1);
	}
	
	@Test
	public final void testGetVersion() 
	{
		Calendar calendarTest2 = new Calendar();
		assertEquals("2.0", calendarTest2.getVersion());
		assertNotEquals("1.0", calendarTest2.getVersion());
		assertNotEquals("3.0", calendarTest2.getVersion());
	}

	
}
