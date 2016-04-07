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
	
	public static void main(String[] args) throws IOException 
	{
		String fname;
		File tfile;
		boolean checker = false;
		char flag = 'n';
		Scanner scanner = new Scanner(System.in); //for UI interaction by retrieving input from user's keyboard
		Events events = new Events();
		while(checker == false) {
			fname = getFile(scanner);
			tfile = new File(fname);
			if(tfile.exists()) {
				checker = true;
				events.setname(fname);
				events.setdate(tfile);
				events.settime(tfile);
				events.increasesize();
			}
			else {
				checker = false;
				System.out.println("That file doesn't exist! Try again please");
			}
		}
		checker = false;
		do {
			while (checker == false) {
				System.out.println("Next file, here we go!");
				fname = getFile(scanner);
				tfile = new File(fname);
				if (tfile.exists()) {
					checker = true;
					events.setname(fname);
					events.settime(tfile);
					events.increasesize();
					System.out.println("Would you like to add another event file?");
					System.out.println("Y to add another file, any other key to continue");
					flag = scanner.next().charAt(0);
				}
				else {
					checker = false;
					System.out.println("That file doesn't exist! Try again please");
				}
			}
		} while (flag == 'y' || flag == 'Y');
		events.sorttime();
		System.out.println(events.gettime(0));
		System.out.println(events.gettime(1));
	}//close main()
	

	/**
	 * METHOD: Gets COMMENT field from user
	 * 
	 * @param the scanner for user's input from keyboard
	 * @param the calendar object
	 */
	public static String getFile(Scanner scanner)
	{
		String file; //prepares to create the .ics file
		String appendICS; //used for properly appending .ics after the file's name
		
		//prompts user for the name of the file
		System.out.println("Enter filename: ");
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
	}
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
