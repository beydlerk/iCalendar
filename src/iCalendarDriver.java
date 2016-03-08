/**
 *The driver class for the Team Dois iCalendar. 
 * 
 * @author Kevin Beydler, Chansen, Conner
 * @version ICS 314
 * @date 2/16/2016
 **/

//Import Preprocesser Directives
import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.*;

//.ics FILE Paramters:
/*
*VERSION: 2.0
*CLASSIFICATION:
*COMMENT:
*LOCATION:
*DSTART:
*DEND:
*TIMEZONE:
*/

public class iCalendarDriver 
{
 
	public static void main(String[] args) 
	{
		/*
		* Data fields for main() driver
		*/
		Scanner scanner = new Scanner(System.in); //for UI interaction by retriving input from user's keyboard
		Calendar calendar = new Calendar(); //creates a calendar object
		String file; //prepares to create the .ics file
	        
	        /*
	         * NECESSARY METHOD CALLS BELOW:
	         */
	         
	         ////////////////////////////////////////////////////////////////////////
	         file = getFile(scanner);		//To get the name of the file
	         
	         getClassification(scanner, calendar);  //To get the CLASSIFICATION field
	         getComment(scanner, calendar); 	//To get the COMMENT field
	         getLocation(scanner, calendar);	//To get the LOCATION field
	         getGEO(scanner, calendar);
	         //getDateTimeStart(scanner, calendar);	//To get the DATETIMESTART field
	         //getDateTimeEnd(scanner, calendar); 	//To get the DATETIMEEND field
	         //getTimeZone(scanner, calendar);	//To get the TIMEZONE field
	         
	         createFile(file, calendar);		//To finally create the .ics file with the data from the user
	         ////////////////////////////////////////////////////////////////////////
	         
	}//close main()
	        
	/*
	 * METHOD: User Interface for the user to give the file's name. (Appends .ics after it to make it Calendar readable.)
	 * 
	 * @param the scanner
	 * @return the .ics file
	 */
	public static String getFile(Scanner scanner)
	{
		String file; //prepares to create the .ics file
		String userInput; //used for entering user data
		String appendICS; //used for properly appending .ics after the file's name
		boolean numOnly = false; //marks if number only format isnt followed
		
		//prompts user for the name of the file
		System.out.println("What would you like to your call your Calendar event file?:");
		//This will be the name of the .ics file generated from this program at the end. :)
		
		//takes the file and trims the whitespace from it (if there's any whitespace)
		 file = scanner.nextLine().trim();
		 
		 //conditional if the file has nothing after its name
      		if (file.lastIndexOf(".") == -1)
      		//appends the ".ics" if it doesn't have it already
		 file = file + ".ics";
		  else 
		  {
		  appendICS = file.substring(file.lastIndexOf(".") + 1, file.length());
		  if (!appendICS.equalsIgnoreCase("ics"))
        	  file = file + ".ics";
		  }
		  return file;
	}//close prepareFile method(Scanner)
	
	/*
	 * METHOD: Gets CLASSIFICATION field from user
	 * 
	 * @param the scanner for user's input from keyboard
	 * @param the calendar object
	 */
	public static void getClassification(Scanner scanner, Calendar calendar) 
	{
		//popup window with the 3 event choices. 
		//stores choice and sets it as the classification
		Object[] choice = {"public","private","confidential"};
		String user = (String)JOptionPane.showInputDialog(null, "Is this a public, private, or a confidential event?","Customized Dialog",JOptionPane.PLAIN_MESSAGE, null, choice,"public");
		calendar.setClassification(user);
	        //Great job here! The UI is perfect!
	}
	
	/*
	 * METHOD: Gets COMMENT field from user
	 * 
	 * @param the scanner for user's input from keyboard
	 * @param the calendar object
	 */
	public static void getComment(Scanner scanner, Calendar calendar) 
	{
		String userInput; //to represent userInput and allow for String manipulation
		
		System.out.println("Please enter a brief description about this event:");
		userInput = scanner.nextLine();
		calendar.setComment(userInput);
	}
	
	/*
	 * METHOD: Gets LOCATION field from user
	 * 
	 * @param the scanner for user's input from keyboard
	 * @param the calendar object
	 */
	public static void getLocation(Scanner scanner, Calendar calendar)
	{
		System.out.println("Please enter a location for this event:");
		String userInput = scanner.nextLine();
		calendar.setLocation(userInput);
	}
	public static void getGEO(Scanner scanner, Calendar calendar) 
	{
		float latDeg = -100;
		float latMin = -100;
		float latSec = -100;
		float lonDeg = -200;
		float lonMin = -100;
		float lonSec = -100;
		while (latDeg < -90 || latDeg > 90) {
			System.out.println("Enter latitude degrees: (-90 to 90)");
    		latDeg = scanner.nextInt(); //reads user's input directly from keyboard - trims off whitespace
    		if (latDeg < -90 || latDeg > 90) {
    			System.out.println("Invalid input!");
    		}
		}
		while (latMin < -60 || latMin > 60) {
			System.out.println("Enter latitude minutes: (-60 to 60)");
    		latMin = scanner.nextInt();
    		if (latMin < -60 || latMin > 60) {
    			System.out.println("Invalid input!");
    		}
		}
		while (latSec < -60 || latSec > 60) {
			System.out.println("Enter latitude seconds: (-60 to 60)");
    		latSec= scanner.nextInt();
    		if (latSec < -60 || latSec > 60) {
    			System.out.println("Invalid input!");
    		}
		}
		while (lonDeg < -180 || lonDeg > 180) {
			System.out.println("Enter longitude degrees: (-180 to 180)");
    		lonDeg= scanner.nextInt();
    		if (lonDeg < -180 || lonDeg > 180) {
    			System.out.println("Invalid input!");
    		}
		}
		while (lonMin < -60 || lonMin > 60) {
			System.out.println("Enter longitude minutes: (-60 to 60)");
    		lonMin= scanner.nextInt();
    		if (lonMin < -60 || lonMin > 60) {
    			System.out.println("Invalid input!");
    		}
		}
		while (lonSec < -60 || lonSec > 60) {
			System.out.println("Enter longitude seconds: (-60 to 60)");
    		lonSec= scanner.nextInt();
    		if (lonSec < -60 || lonSec > 60) {
    			System.out.println("Invalid input!");
    		}
		}
    	float latDec= latDeg+latMin/60+latSec/3600;
    	float lonDec= lonDeg+lonMin/60+lonSec/3600;
		calendar.setGEO(latDec, lonDec);
	}
	
	/*
	 * METHOD: Gets DATE TIME START field from user
	 * 
	 * @param the scanner for user's input from keyboard
	 * @param the calendar object
	 */
	public static void getDateTimeStart(Scanner scanner, Calendar calendar) 
	{
		String eventDay; //to represent user input - for String manipulation
		String eventTime;
		String userInput = "";
		boolean checker = false;
		
		while(checker==false){
			System.out.println("Please enter the day that you want this event to start at: (yyyymmdd)");
			eventDay = scanner.nextLine();
			checker = eventDay.matches("[0-9]+");
			if(checker==true && eventDay.length()==8){
				userInput = userInput+eventDay;
			}else{
				checker=false;
				System.out.println("Please follow number format in the parentheses");
			}
		}//end while
		checker=false;
		userInput=userInput+"T";
		while(checker==false){
			System.out.println("Please enter this event's starting time: (HHmmss)");
			eventTime = scanner.nextLine();
			checker = eventTime.matches("[0-9]+");
			if(checker==true && eventTime.length()==6){
				userInput = userInput+eventTime;
			}else{
				checker=false;
				System.out.println("Please follow number format in the parentheses");
			}
		}//end while
		userInput=userInput+"Z";
		calendar.setDSTART(userInput);
	}
	
	/*
	 * METHOD: Gets DATE TIME END field from user
	 * 
	 * @param the scanner for user's input from keyboard
	 * @param the calendar object
	 */
	public static void getDateTimeEnd(Scanner scanner, Calendar calendar) 
	{
		String eventDay; //to represent user input - for String manipulation
		String eventTime;
		String userInput = "";
		boolean checker = false;
		
		while(checker==false){
			System.out.println("Please enter the day that you want this event to end at: (yyyymmdd)");
			eventDay = scanner.nextLine();
			checker = eventDay.matches("[0-9]+");
			if(checker==true && eventDay.length()==8){
				userInput = userInput+eventDay;
			}else{
				checker=false;
				System.out.println("Please follow number format in the parentheses");
			}
		}//end while
		checker=false;
		userInput=userInput+"T";
		while(checker==false){
			System.out.println("Please enter this event's ending time: (HHmmss)");
			eventTime = scanner.nextLine();
			checker = eventTime.matches("[0-9]+");
			if(checker==true && eventTime.length()==6){
				userInput = userInput+eventTime;
			}else{
				checker=false;
				System.out.println("Please follow number format in the parentheses");
			}
		}//end while
		userInput=userInput+"Z";
		calendar.setDEND(userInput);
	}
	
	/*
	 * METHOD: Gets TIMEZONE field from user
	 * 
	 * @param the scanner for user's input from keyboard
	 * @param the calendar object
	 */
	public static void getTimeZone(Scanner scanner, Calendar calendar) 
	{
		String userInput; //to represent the user's input for String manipulation
		String[] GMTpositives; //to represent the positive GMT timezones
		String[] GMTnegatives; //to represent the negative GMT timezones
		
		System.out.println("What is the timezone (GMT) for this event?:");
		
		//I think we will loop through our GMT timezones to show the user what to input
		
		
		//read in user's input
	
		//check input to see it is appropriate
		
		
		//call the calendar.setTimeZone() method from Calendar when finished with this method
	}
	
 /**
   * void method to create our .ics file.
   * 
   * @param file: the name of the .ics file object to make created
   * @param calendar: the calendar object's data used to fill into the .ics file
   * @return void (nothing)
   */
  public static void createFile(String file, Calendar calendar) 
  {
    //attempts to create the .ics file
    try 
    {
      System.out.println("Attempting to create the:" + file + ".");
      //calls the create calendar method from the Calendar.java class
      calendar.createICS(file);
    }
    catch (InputMismatchException exceptionIME) 
    {
      System.out.println("ERROR: Due to an input mismatch error, the program FAILED to create the file!");
    }
    System.out.println("The file: " + file + " has successfully been created!");
  }
}
//closes iCalendarDriver.java class
