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


public class iCalendarDriver 
{
 
	public static void main(String[] args) 
	{
		/**
		 * Guys, something tells me that we wont get very far by putting all of our driver stuff into the main.
		 * We should probably try and break all of this up eventually into separate methods and simply use the main 
		 * to call upon them when necessary...it would be a better option...
		 */
		
		
		Scanner input = new Scanner(System.in); //for UI interaction
		Calendar calendar = new Calendar(); //creates calendar object
		String file; //prepares to create the .ics file
		String user; //used for entering user data
		boolean numOnly = false; //marks if number only format isnt followed
		
		//System.out.println("What would you like to your call your Calendar event file?:");
		//This will be the name of the .ics file generated from this program at the end. :)
		
		//FOR GETTING CLASSIFICATION DATA
		//while(!input.equalsIgnoreCase(Private) || !input.equalsIgnoreCase(Public) || !input.equalsIgnoreCase(Confidential))
		//{
		//System.out.println("What is the classification of the event? Is it a public, private, or a confidential event?:")
		//user = input.nextLine();
	//	}
		//Calendar.setClassification(user);
		
		 //FOR GETTING COMMENT DATA
		 System.out.println("Please enter a brief description about this event:");
		 user = input.nextLine();
		// Calendar.setComment(user);
		 
		 //FOR GETTING LOCATION DATA
		// System.out.println("What is the location of this event?:");
		// user = input.nextLine();
		// Calendar.setLocation(user);
		 
		 
		 //FOR GETTING START DATE
		while(numOnly==false){
			//while loop to ensure number format
		 System.out.println("Please enter the day that you want this event to start at: (yyyymmdd)");//Dont know if this is needed as I didnt see a function call for it, but i saw the variable for it so I went ahead and added a call
		 user = input.nextLine(); 
		 numOnly = user.matches("[0-9]+");//returns true if string is all numbers
		 if(numOnly==true){
			//Calendar.setDate(user);
		 }else{
			System.out.println("ERROR: Please follow the specific format within the parentheses!");
		 }
		}
	        numOnly=false;//allows for number format test to be reused
	        while(numOnly==false){
	        	//while loop to ensure number format
		 System.out.println("Please enter this event's starting time: (HHmmss)");//Dont know if this is needed as I didnt see a function call for it, but i saw the variable for it so I went ahead and added a call
		 user = input.nextLine();
		 numOnly = user.matches("[0-9]+");//returns true if string is all numbers
		 if(numOnly==true){
		//	Calendar.setTime(user);
		 }else{
			System.out.println("ERROR: Please follow the specific format within the parentheses");
		 }
	        }
	        
	        
	        //FOR GETTING END DATE & TIME
		while(numOnly==false){
			//while loop to ensure number format
		 System.out.println("Please enter the day that you want this event to end at: (yyyymmdd)");//Dont know if this is needed as I didnt see a function call for it, but i saw the variable for it so I went ahead and added a call
		 user = input.nextLine(); 
		 numOnly = user.matches("[0-9]+");//returns true if string is all numbers
		 if(numOnly==true){
		//	Calendar.setDate(user);
		 }else{
			System.out.println("ERROR: Please follow the specific format within the parentheses!");
		 }
		}
	        numOnly=false;//allows for number format test to be reused
	        while(numOnly==false){
	        	//while loop to ensure number format
		 System.out.println("Please enter this event's ending time: (HHmmss)");//Dont know if this is needed as I didnt see a function call for it, but i saw the variable for it so I went ahead and added a call
		 user = input.nextLine();
		 numOnly = user.matches("[0-9]+");//returns true if string is all numbers
		 if(numOnly==true){
		//	Calendar.setTime(user);
		 }else{
			System.out.println("ERROR: Please follow the specific format within the parentheses!");
		 }
	        }
	        
	        /*
	         *METHOD CALLS:
	         */
	         createFile(file, calendar);
	}
	        
	        
	/*
	 * METHOD: User Interface for the user to give the file's name. (Appends .ics after it to make it Calendar readable.)
	 * 
	 * @param the scanner
	 * @return the .ics file
	 */
	public static String getFileName(Scanner scanner)
	{
		String file; //prepares to create the .ics file
		String userInput; //used for entering user data
		String appendICS; //used for properly appending .ics after the file's name
		boolean numOnly = false; //marks if number only format isnt followed
		
		//prompts user for the name of the file
		System.out.println("What would you like to your call your Calendar event file?:");
		//This will be the name of the .ics file generated from this program at the end. :)
		
		//takes the file and trims the whitespace from it (if there's any whitespace)
		 //file = userInput.nextLine().trim();
		 
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
      //calendar.createICS(file);
    }
    catch (InputMismatchException exceptionIME) 
    {
      System.out.println("ERROR: Due to an input mismatch error, the program FAILED to create the file!");
    }
    System.out.println("The file: " + file + " has successfully been created!");
  }
}
}//closes iCalendarDriver.java class