/**
 * Calendar Object class for the .ics file parameters
 * 
 * @author kevinbeydler
 *
 */

public class Calendar 
{

	private String version; 						//version data field
	private String classification; 					//version data field
	private String comment; 						//comment data field
	private String location;					 	//geo location data field
	private String DSTART; 							//date time start data field
	private String DEND; 							//date time end data field
	private String timeZone; 						//timezone data field
	private final static String DATE = "yyyyMMdd"; 	//Date format data field
	private final static String TIME = "HHmmss"; 	//Time format data field
	
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
		DSTART = dSTART;
	}

	public String getDEND() {
		return DEND;
	}

	public void setDEND(String dEND) {
		DEND = dEND;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public void createICS()
	{
		//creates the actual .ics file
	}
	
}

