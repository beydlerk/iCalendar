/**
 *The jUnit test class for the iCalendarDriver.java. 
 * 
 * @author Kevin Beydler, Chansen Hesia, Conner Higashino
 * @version ICS 314
 * @date 4/4/2016
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

	@Test
	public final void testGetLocation() 
	{
		Calendar calendarTest3 = new Calendar();
		assertEquals(null,calendarTest3.getLocation());
	
		assertNotEquals("Kuykendall",calendarTest3.getLocation());
	}
	
	@Test
	public final void testGetGEO() 
	{
		Calendar calendarTest8 = new Calendar();
		assertEquals(null,calendarTest8.getGEO());
	
		assertNotEquals("177.110101;-12.221553",calendarTest8.getGEO());
	}
	
	@Test
	public final void testGetCommentary() 
	{
		Calendar calendarTest4 = new Calendar();

		assertEquals(null, calendarTest4.getComment());
	}
	
	@Test
	public final void testGetDTSTART() 
	{
		Calendar calendarTest5 = new Calendar();
		
		assertEquals(null,calendarTest5.getDSTART());
	}
	
	@Test
	public final void testGetDTEND() 
	{
		Calendar calendarTest6 = new Calendar();
		
		assertEquals(null,calendarTest6.getDEND());
	}
	
	@Test
	public final void testGetTimeZone() 
	{
		Calendar calendarTest8 = new Calendar();
		
		assertNull(calendarTest8.getTimeZone());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public final void testInvalidExtension() 
	{
		Calendar calendarTest7 = new Calendar();
		
		calendarTest7.createICS("test.txt"); //if it tries to be .txt, test = FAIL
		
	}

}
