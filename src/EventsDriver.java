/**
 *The Eventsdriver class for the Team Dois iCalendar. To read files, sort them by start times, extract their GEO data, 
 *calculate their great circle distances, then write the circle distances to the files.
 * 
 * @author Kevin Beydler, Chansen Hesia, Conner Higashino
 * @version ICS 314
 * @date 4/4/2016
 **/

//import preprocessor directives
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class EventsDriver 
{
	
	// might need an array of Strings to store contents/fileNames/content from files
	String events[];
	
	static String file1 = "event1.ics"; //for event 1
	static String file2 = "event2.ics"; //for event 2
	
	
	public static void main(String[] args) 
	{
		/*
		* Data fields for main() driver
		*/
		Scanner scanner = new Scanner(System.in); //for UI interaction by retrieving input from user's keyboard
		
		 file1 = getFile(scanner);		//To get the name of the file
		 file2 = getFile(scanner);		//To get the name of the file
		 
		 
		 /*
		  * CALL THESE WHEN READY
		  */
		 
		 //readFromFile(String[] eventList);
		 //sortEventLog(String[] eventL);
		 //greatCircleComment(Scanner scanner, Calendar calendar);
		 //writeToFile(String[] eventList);
		 
		 
	}//close main()
	
	private static String getFile(Scanner scanner) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * METHOD: Gets COMMENT field from user
	 * 
	 * @param the scanner for user's input from keyboard
	 * @param the calendar object
	 */
	
	public static void greatCircleComment(Scanner scanner, Calendar calendar) 
	{
		String userInput = ""; //to represent userInput and allow for String manipulation

		System.out.println("Please enter a brief description about this event:");
		userInput = scanner.nextLine();
		
		System.out.println("Circle's Great distance between the two event files is: ");
	}
	
	
	/**
	 * METHOD: scans the event file's content (need to scan 2 different events to get both locations for calculation)
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
	  * METHOD: scans the event file's content (need to scan 2 different events to get both locations for calculation)
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
	 * METHOD: writes over the event file's content (need to write over 2 different events to write in the circle distance)
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

}
