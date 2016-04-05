/**
 *The driver class for the Team Dois iCalendar. 
 * 
 * @author Kevin Beydler, Chansen H, Conner H
 * @version ICS 314
 * @date 3/9/2016
 **/

//Import Preprocesser Directives
import java.util.*;
import java.awt.Dimension;
import java.awt.Toolkit;
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
	         
	         getEventname(scanner, calendar);
	         getClassification(scanner, calendar);  //To get the CLASSIFICATION field
	         getComment(scanner, calendar); 	//To get the COMMENT field
	         getLocation(scanner, calendar);	//To get the LOCATION field
	         getGEO(scanner, calendar);
	         getDateTimeStart(scanner, calendar);	//To get the DATETIMESTART field
	         getDateTimeEnd(scanner, calendar); 	//To get the DATETIMEEND field
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
		String appendICS; //used for properly appending .ics after the file's name
		
		//prompts user for the name of the file
		System.out.println("What would you like to your call your Calendar event file?:");
		//This will be the name of the .ics file generated from this program at the end. :)
		
		//takes the file and trims the whitespace from it (if there's any whitespace)
		file = scanner.nextLine().trim();
		 
		//conditional if the file has nothing after its name
		if (file.lastIndexOf(".") == -1)		//appends the ".ics" if it doesn't have it already
			file = file + ".ics";
		else 
		{
			appendICS = file.substring(file.lastIndexOf(".") + 1, file.length());
			if (!appendICS.equalsIgnoreCase("ics"))
				file = file + ".ics";
		}
		return file;
	} //close prepareFile method(Scanner)
	
	public static void getEventname(Scanner scanner, Calendar calendar)
	{
		String userInput;
		
		System.out.println("Please enter the name of this event");
		userInput = scanner.nextLine();
		calendar.setEventname(userInput);
	}
	
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
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		JFrame top = null; //dummy JFram
		if (top == null) {
			top = new JFrame();
		}
		top.setVisible(true);
		top.setAlwaysOnTop(true);
		top.setLocation(width/2,height/2);
		String user = (String)JOptionPane.showInputDialog(top, "Is this a public, private, or a confidential event?","Classification Selection",JOptionPane.PLAIN_MESSAGE, null, choice,"public");
		top.dispose();
		calendar.setClassification(user);
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
		
		
		//Here is what I think we can use to read the two event file's content
		
		/*
		String fileOne = "eventOne.ics";
		String fileTwo = "eventTwo.ics";
		
	   File FileOne = new File(fileOne);
	   File FileTwo = new File(fileTwo);
	   
	   //reads each line of the .ics event files
	   String strLine = new String("");
	   
	   Scanner fr1 = new Scanner(fileOne);  
	   Scanner fr2 = new Scanner(fileOne); 
	   
	   
	   
	   //loops until last line of ics file
	   while(fr1.hasNextLine()) {
	      strLine = fr1.nextLine();
	   }//close while
	   
	   //loops until last line of ics file
	   while(fr2.hasNextLine()) {
	      strLine = fr2.nextLine();
	   }//close while
	   
	   
	   fr1.close();
	   fr2.close();
		*/
		
		
		
		//Halverside Distance Forumula (We can maybe use this to calculate the distance for our two event files)
		
		/*
		 * 
		 * 
        double a = Math.pow(Math.sin((x2-x1)/2), 2)
                 + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2-y1)/2), 2);

        // great circle distance in radians
        double angle2 = 2 * Math.asin(Math.min(1, Math.sqrt(a)));

        // convert back to degrees
        angle2 = Math.toDegrees(angle2);

        // each degree on a great circle of Earth is 60 nautical miles
        double distance2 = 60 * angle2;

        System.out.println(distance2 + " nautical miles");
		 * 
		 */
		
		System.out.println("Circle's Great distance between the two event files is: ");
		
		
	}
	
	/*
	 * METHOD: Gets LOCATION field from user
	 * 
	 * @param the scanner for user's input from keyboard
	 * @param the calendar object
	 */
	public static void getLocation(Scanner scanner, Calendar calendar)
//Updated upstream
	{
		System.out.println("Please enter a location for this event:");
		String userInput = scanner.nextLine();
		calendar.setLocation(userInput);
	}
	
	
	/*
	 * METHOD: Gets GEO field from user
	 * 
	 * @param scanner for user input from stdin
	 * @param the calendar objefct
	 */
	public static void getGEO(Scanner scanner, Calendar calendar) 
	{
		//variables
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
		
		while(checker==false) {
			System.out.println("Please enter the day that you want this event to start at: (yyyymmdd)");
			eventDay = scanner.nextLine();
			checker = eventDay.matches("[0-9]+");
			if(checker==true && eventDay.length()==8){
				userInput = userInput+eventDay;
			}
			else {
				checker=false;
				System.out.println("Please follow number format in the parentheses");
			}
		}//end while
		checker=false;
		userInput=userInput+"T";
		while(checker==false) {
			System.out.println("Please enter this event's starting time: (HHmmss)");
			eventTime = scanner.nextLine();
			checker = eventTime.matches("[0-9]+");
			if(checker==true && eventTime.length()==6){
				userInput = userInput+eventTime;
			}
			else {
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
		String eventDay;
		String eventTime;
		String userInput = "";
		boolean checker = false;
		
		while(checker==false) {
			System.out.println("Please enter the day that you want this event to end at: (yyyymmdd)");
			userInput.toString();
			eventDay = scanner.nextLine();
			checker = eventDay.matches("[0-9]+");
			if(checker==true && eventDay.length()==8) {
				userInput = userInput+eventDay;
			}
			else {
				checker=false;
				System.out.println("Please follow number format in the parentheses");
			}
		}//end while
		checker=false;
		userInput=userInput+"T";
		while(checker==false) {
			System.out.println("Please enter this event's ending time: (HHmmss)");
			eventTime = scanner.nextLine();
			checker = eventTime.matches("[0-9]+");
			if(checker==true && eventTime.length()==6) {
				userInput = userInput+eventTime;
			}
			else {
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
		
		String g1, g2;
		
		String[] GMTpositives; //to represent the positive GMT timezones
		String[] GMTnegatives; //to represent the negative GMT timezones
		
		System.out.println("What is the timezone (GMT) for this event?:");
		Object[] choice = {"GMT +12:00", "GMT +11:30", "GMT +11:00", "GMT +10:30", "GMT +10:00", "GMT +09:30", "GMT +09:00", "GMT +08:00", "GMT +07:00", "GMT +06:30", "GMT +06:00", "GMT +05:30", "GMT +05:00", "GMT +04:00", "GMT +03:00", "GMT +02:00", "GMT +01:00", "GMT","GMT -01:00","GMT -02:00", "GMT -03:00", "GMT -03:30", "GMT -04:00", "GMT -05:00", "GMT -06:00", "GMT -07:00", "GMT -08:00", "GMT -08:30", "GMT -09:00", "GMT -09:30", "GMT -10:00", "GMT -11:00", "GMT -12:00"};
		String user = (String)JOptionPane.showInputDialog(null, "Please select a timezone","Timezone Selection",JOptionPane.PLAIN_MESSAGE, null, choice,"GMT");
		//Using a dropdown menu to make it easier on the user.
		//probably use a switch case? I dunno the best way to implement
		
		
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
//closes iCalendarDriver.java class

/**
 * scans the event file's content (need to scan 2 different events to get both locations for calculation)
 * 
 * @param args represents the file input/output from user
 */
 public String[] sortEventLog(String[] eventL) throws FileNotFoundException{ //sorts .ics event files by time
	 
	 String eventTime1="";
	 String eventTime2="";
	 
	 int i; //loop count
	 String[] eventList= eventL;
	 for(i=0; i<eventList.length;i++){
		 	String f1  = eventList[i]; //whatever.ics
			String f2 = eventList[i+1];
			File file1 = new File(f1);
			File file2 = new File(f2);
			Scanner eventOne= new Scanner(file1);
			Scanner eventTwo= new Scanner(file2);
			while(eventOne.hasNextLine()&&eventTwo.hasNextLine())
			{
				String first = eventOne.nextLine();
				String second = eventTwo.nextLine();
				if(first.charAt(3)=='T'){//finds the datetime start time line
					String[] temp = first.split(":");
					String[] time1 = temp[1].split("T");	
					eventTime1 = time1[0];
					eventTime1 = eventTime1.replaceFirst(String.valueOf(eventTime1.charAt(6)), "");//gets only the timestamp
					temp = second.split(":");
					String[] time2 = temp[1].split("T");
					eventTime2= time2[0];
					eventTime2 = eventTime2.replaceFirst(String.valueOf(eventTime2.charAt(6)), "");//gets only the timestamp
				}
				
			}
			int t1= Integer.parseInt(eventTime1);
			int t2= Integer.parseInt(eventTime2);
			if(t2<t1)
			{
				String temp = eventList[i];
				eventList[i]= eventList[i+1];
				eventList[i+1] = temp;
				i=0; //starts over from the beginning if a string gets sorted.
			}
	 }
	 return eventList;
 }
 
 /**
  * scans the event file's content (need to scan 2 different events to get both locations for calculation)
  * 
  * @param args represents the file input/output from user
  */
private void readFromFile(String[] eventList) throws FileNotFoundException, IOException 
{
	String strLine="";
	double lat1=0;
	double lon1=0;
	double lat2=0;
	double lon2=0;
	
	for(int i=0; i<eventList.length;i++){
		String f1  = eventList[i]; //whatever.ics
		String f2 = eventList[i+1];
		File file1 = new File(f1);
		File file2 = new File(f2);
		Scanner eventOne= new Scanner(file1);
		Scanner eventTwo= new Scanner(file2);
		
		   while(eventOne.hasNextLine()) 
		   {
      strLine = eventOne.nextLine();
      if(strLine.charAt(0)=='G')
      {
      	String[] split = strLine.split(":");
      	String numString= split[1];
      	String[] split2= numString.split(";");
      	String one = split2[0];
      	String two = split2[1];
      	 lat1 = Double.parseDouble(one);
      	 lon1 = Double.parseDouble(two);
      	
      }
   }//close while
   
		   while(eventTwo.hasNextLine()) {
			      strLine = eventTwo.nextLine();
			      if(strLine.charAt(0)=='G'){
			      	String[] split = strLine.split(":");
			      	String numString= split[1];
			      	String[] split2= numString.split(";");
			      	String one = split2[0];
			      	String two = split2[1];
			      	 lat2 = Double.parseDouble(one);
			      	 lon2 = Double.parseDouble(two);
			      	
			      }
			   }//close while

			double Radius= 6372797.560856;
	      	double radLat1= Math.toRadians(lat1);
	      	double radLat2= Math.toRadians(lat2);
	      	double radLat= Math.toRadians((lat2-lat1));
	      	double radLon= Math.toRadians((lon2-lon1));
	      	double angle = Math.sin(radLat/2)*Math.sin(radLat/2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.sin(radLon/2)*Math.sin(radLon/2);
	      	double distance = 2 * Math.asin(Math.sqrt(angle))*Radius;
	      	String eventValue= String.valueOf(distance); //String holding the distance value between 2 events
	      	BufferedWriter writer = new BufferedWriter(new FileWriter(eventList[i], true));//stuck here
	      	//next goal is to figure out how to access and modify comment line
	}
   

}//close readFromFile() method


/**
 * writes over the event file's content (need to write over 2 different events to write in the circle distance)
 * 
 * @param args represents the file input/output from user
 */
private void writeToFile(String[] eventList) throws FileNotFoundException, IOException 
{
	
	String file1 = "";
	String file2 = "";
	
	PrintWriter fileWriter = null;
	PrintWriter fileWriter2 = null;
	
    try 
    {
       //attempts to establish a successful connection with the fileWriters and files themselves
       fileWriter = new PrintWriter(file1);
       fileWriter2 = new PrintWriter(file2);
    }//close try
    
    catch (FileNotFoundException exceptionFNFE) 
    {
       JOptionPane.showMessageDialog(null, "ERROR: Alterations could not be saved!");
    }//close catch
    
    /*
     * Can we write into a file while the program is running?
     */

    //closes the PrintWriter objects
    fileWriter.close(); 
    fileWriter2.close(); 
    
 }//close writeToFile() method


}//closes class 
