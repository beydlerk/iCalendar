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
	public final void testGetLocation() {
		Calendar calendarLoc = new Calendar();
		
		
		assertEquals(null,calendarLoc.getLocation());
	}

}
