/**
 *The Events class for the EventsDriver.java. 
 * 
 * @author Kevin Beydler, Chansen Hesia, Conner Higashino
 * @version ICS 314
 * @date 4/4/2016
 **/

//import preprocessor directives
import java.util.*; //basic functions + Java TimeZone API utility
import java.text.*; //text formatting for dates and times directives
import java.io.*; //basic file writing/handling directives



public class Events 
{
	private int date;
	private int[] starttime = new int[1000];
	private String[] filename = new String[1000];					//array of strings for filenames
	private double greatcircle;
	private int size = 0;
	
	public void setdate(File file) throws IOException {
		date = readdate(file);
	}
	public int getdate() {
		return date;
	}
	public void settime(File file) throws IOException {
		starttime[size] = readtime(file);
	}
	public int gettime(int pos) {
		return starttime[pos];
	}
	public void setname(String s) {
		filename[size] = s;
	}
	public String getname(int pos) {
		return filename[pos];
	}
	public void setcircle(double dist) {
		greatcircle = dist;
	}
	public double getcircle() {
		return greatcircle;
	}
	public void increasesize() {
		size++;
	}
	public void decreasesize() {
		size--;
	}
	public int getsize() {
		return size;
	}
	public int readdate(File file) throws IOException {
		String temp;
		FileInputStream fs = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		for (int i = 0; i < 8; i++) {
			br.readLine();
		}
		temp = br.readLine();
		temp = temp.substring(8, 15);
		int save = Integer.parseInt(temp);
		return save;
	}
	public int readtime(File file) throws IOException {
		String temp;
		FileInputStream fs = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		for (int i = 0; i < 8; i++) {
			br.readLine();
		}
		temp = br.readLine();
		temp = temp.substring(17, 22);
		int save = Integer.parseInt(temp);
		return save;
	}
	public void sorttime() {
		mergesort stack = new mergesort();
		stack.sort(starttime, filename, size);
		starttime = stack.getarray();
		filename = stack.getfollow();
	}
}




