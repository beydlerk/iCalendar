/**
 * Calendar Object class for the .ics file parameters TEAM Dois
 * 
 * @author Kevin Beydler
 * @version 3/9/2016
 *
 */

import java.util.*; //basic functions + Java TimeZone API utility
import java.text.*; //text formatting for dates and times directives
import java.io.*; //basic file writing/handling directives

public class Calendar 
{

	private String version; 						//version data field
	private String classification; 						//version data field
	private String eventname;
	private String comment; 						//comment data field
	private String location;					 	//geo location data field
	private String GEO;
	private String DSTART; 							//date time start data field
	private String DEND; 							//date time end data field
	private String timeZone; 						//timezone data field
	
	private String[] events;  						//string of event names - thinking that the made events will be stored here
	
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
		
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	
	public String getEventname() {
		return eventname;
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
	public void setGEO(float lat, float lon) {
		String latitude = String.valueOf(lat);
		String longitude = String.valueOf(lon);
		this.GEO = latitude;
		this.GEO += ";";
		this.GEO += longitude;
	}
	public String getGEO() {
		return GEO;
	}

	public String getDSTART() {
		return DSTART;
	}

	public void setDSTART(String dSTART) {
		
		this.DSTART = dSTART;
	}

	public String getDEND() {
		return DEND;
	}

	public void setDEND(String dEND) {

		this.DEND = dEND;
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
	public void createICS(String file)
	{
		//attempts to append .ics extension to the file (The "." is the marker for the "ics" to go afterwards)
		String appendICS = file.substring(file.lastIndexOf(".") + 1, file.length());
		
		//throws an illegal argument exception if the extension is not a ".ics"
		if (!appendICS.equalsIgnoreCase("ics")) throw new IllegalArgumentException("ERROR: File extension must be a .ics ONLY!");
		
		//attempts to write Calendar's content to the .ics file
		try 
		{
			File writingto = new File(file); //WRITES TO CURRENT DIRECTORY
      		FileWriter fw = new FileWriter(writingto.getAbsoluteFile());
      		BufferedWriter bw = new BufferedWriter(fw);
      		bw.write("BEGIN:VCALENDAR");
      		bw.newLine();
      		bw.write("VERSION:" + version);
      		bw.newLine();
      		bw.write("BEGIN:VEVENT");
      		bw.newLine();
      		bw.write("SUMMARY:" + eventname); //this is event name!
      		bw.newLine();
      		bw.write("CLASSIFICATION:" + classification);
      		bw.newLine();
      		bw.write("DESCRIPTION:" + comment);
      		bw.newLine();
      		bw.write("LOCATION:" + location);
      		bw.newLine();
      		bw.write("GEO:" + GEO);
      		bw.newLine();
      		bw.write("DTSTART:" + DSTART); // in GMT
      		bw.newLine();
      		bw.write("DTEND:" + DEND); // in GMT
      		bw.newLine();
      		bw.write("TIMEZONE:Pacific/Honolulu"); //GMT -10:00
      		bw.newLine();
      		bw.write("END:VEVENT");
      		bw.newLine();
      		bw.write("END:VCALENDAR");
      		bw.close();
      		fw.close();
      		
		}
		//catch if the file encounters an error during INPUT/OUTPUT phase
		catch(IOException ioe)
		{
		 System.out.println("ERROR: Could not open file due to Input/Output exception!");
		}
	}

}
