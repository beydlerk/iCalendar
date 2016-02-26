/**
 * Calendar Object class for the .ics file parameters TEAM Dois
 * 
 * @author Kevin Beydler
 * @version 2/21/2016
 *
 */

import java.util.*; //basic functions + Java TimeZone API utility
import java.text.*; //text formatting for dates and times directives
import java.io.*; //basic file writing/handling directives

public class Calendar 
{

	private String version; 						//version data field
	private String classification; 						//version data field
	private String comment; 						//comment data field
	private String location;					 	//geo location data field
	private String DSTART; 							//date time start data field
	private String DEND; 							//date time end data field
	private String timeZone; 						//timezone data field
	private final static String DATETIME_FORMAT = "yyyyMMdd'T'HHmmss"; 	//Date & Time formatting data field
	
	/*
	 * Calendar construction method
	 */
	public Calendar()
	{
		setVersion("2.0");
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getClassification() {
		
		/*
		* TODO: need to add a conditional or something to check if the user entered a private/public/confidential
		*/
		
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDSTART() {
		return DSTART;
	}

	public void setDSTART(String dSTART) {
		
		/*
		* TODO: Definitely need to add stuff to properly set the starting date
		*/
		
		DSTART = dSTART;
	}

	public String getDEND() {
		return DEND;
	}

	public void setDEND(String dEND) {
		
		/*
		* TODO: Definitely need to add stuff to properly set the ending date
		*/
		DEND = dEND;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	
	
	/**
	* METHOD: Writes the calendar's content into a blank file, appends .ics and prepares to be called in driver class
	* 
	* @param file: The file that the user is trying to create
	* @return void
	* @throws IllegalArgumentException - if there was an error opening the file
	*/
	public void createICS(file)
	{
		//attempts to append .ics extension to the file (The "." is the marker for the "ics" to go afterwards)
		String appendICS = file.substring(file.lastIndexOf(".") + 1, file.length());
		
		//throws an illegal argument exception if the extension is not a ".ics"
		if (!appendICS.equalsIgnoreCase("ics")) throw new IllegalArgumentException("ERROR: File extension must be a .ics ONLY!");
		
		//attempts to write Calendar's content to the .ics file
		try 
		{
      		PrintWriter pw = new PrintWriter(new FileWriter(file, false));
      		/*
      		* Okay so, this is how I think we will do this...
      		*
      		* 1) The version will be easy, the printer will print the version 2.0 to the file simply.
      		* 2) This symbol (&) means that this wont be too hard I think...
      		* 3) This symbol ($) means we will have a hard time with this...
      		*/
      		
      		pw.println("VERSION:" + version);
      		pw.println("CLASSIFICATION:" + classification); // &
      		pw.println("COMMENT:" + comment); // &
      		pw.println("Location:" + location); // $ 
      		pw.println("DTSTART:" + DTSTART); // $ 
      		pw.println("DTEND:" + DTEND); // $
      		pw.println("TIMEZONE:" + TimeZone); // $
      		pw.close();
		}
		//catch if the file encounters an error during INPUT/OUTPUT phase
		catch(IOException ioe)
		{
		 System.out.println("ERROR: Could not open file due to Input/Output exception!");
		}
	}

}