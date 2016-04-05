/**
 *The jUnit test class for the iCalendarDriver.java. 
 * 
 * @author Kevin Beydler, Chansen Hesia, Conner Higashino
 * @version ICS 314
 * @date 3/9/2016
 **/

//Import Preprocesser Directives
import java.util.*;
import java.io.*;
import java.text.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class iCalendarDriverTestCases 
{

	@Test //Standard test
	public void test() 
	{
		fail("Not yet implemented");
	}

	@Test
	public final void testMain() 
	{
	iCalendarDriver.main(null);//see if the main() works
	}
	
	@Test
	public final void testGetFile() 
	{
		Scanner TestInput0 = new Scanner(System.in);
		assertEquals("test.ics", iCalendarDriver.getFile(TestInput0));
	}
	
	@Test
	public final void testGetLocation() 
	{
		Scanner testInput1 = new Scanner(System.in);
		Calendar calendarLocation = new Calendar();
		iCalendarDriver.getLocation(testInput1, calendarLocation);
		assertEquals("Mililani", calendarLocation.getLocation());
		
		iCalendarDriver.getLocation(testInput1, calendarLocation);
		assertNotEquals("North Shore", calendarLocation.getLocation());
	}
	
	@Test
	public final void testGetGEO() 
	{
		Scanner testInput2 = new Scanner(System.in);
		Calendar calendarGeo = new Calendar();
		
		iCalendarDriver.getGEO(testInput2, calendarGeo);
		assertEquals("-15.125212;15.241501",calendarGeo.getGEO());
		
		iCalendarDriver.getGEO(testInput2, calendarGeo);
		assertNotEquals("121.145122;16.325111",calendarGeo.getGEO());
	}
	
	@Test
	public final void testGetComment() 
	{
		Scanner testInput3 = new Scanner(System.in);
		Calendar calendarComment = new Calendar();
		
		iCalendarDriver.getComment(testInput3, calendarComment);
		assertEquals("Working on this project", calendarComment.getComment());
	}
	
	
	@Test
	public final void createFile()
	{
		Scanner testInput4 = new Scanner(System.in);
		assertEquals("test.ics", iCalendarDriver.getFile(testInput4));
		
	}
	
	@Test
	public final void testEmptyFile() 
	{
		Scanner testInput5 = new Scanner(System.in);
		assertEquals(".ics", iCalendarDriver.getFile(testInput5));
	}
	
	
	@Test
	public final void testsortEventLog()
	{
		Scanner testInput6 = new Scanner(System.in);
		
		assertEquals(".ics", iCalendarDriver.getFile(testInput6));
	}
	
}
