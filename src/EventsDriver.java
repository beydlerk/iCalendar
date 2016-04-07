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
		String flag;
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
		boolean have_base = false;
		do {
			checker = false;
			flag = "\0";
			while (checker == false) {
				System.out.println("Next file, here we go!");
				fname = getFile(scanner);
				tfile = new File(fname);
				if (tfile.exists()) {
					if (events.compdate(tfile) == false) {
						System.out.println("Hey, that's on a different day! Sorry, we can't process that.");
						if (have_base == false) {
							System.out.println("Try again");
							checker = false;
						}
						else {
							checker = true;
						}
					}
					else if (events.redundant(fname) == true) {
						System.out.println("Hey, you already input that day!");
						if (have_base == false) {
							checker = false;
						}
						else {
							checker = true;
						}
					}
					else {
						checker = true;
						events.setname(fname);
						events.settime(tfile);
						events.increasesize();
					}
				}
				else {
					checker = false;
					System.out.println("That file doesn't exist! Try again please");
				}
			}
			while (flag.trim().length() == 0) {
				System.out.println("Would you like to add another event file?");
				System.out.println("Y to add another file, any other key to continue");
				String temp = scanner.nextLine();
				if (temp.trim().length() > 0) {
					flag = temp.substring(0, 1);
				}
				if (temp.trim().length() == 0) {
					System.out.println("Sorry, I didn't catch that.");
				}
			}
			have_base = true;
		} while (flag.equals("y") || flag.equals("y"));
		events.sorttime();
		//System.out.println(events.getsize());
		events.editICS();
		System.out.println("Ding! Finished.");
	}//close main()
	
	public static String getFile(Scanner scanner)
	{
		String file; //prepares to create the .ics file
		String appendICS; //used for properly appending .ics after the file's name
		
		System.out.println("Enter filename: ");
		file = scanner.nextLine().trim();
		 
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
}
