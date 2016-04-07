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
	public boolean redundant(String file) {
		for (int i = 0; i < size; i++) {
			if (file.equals(filename[i])) {
				return true;
			}
		}
		return false;
	}
	public int readdate(File file) throws IOException {
		String temp;
		FileInputStream fs = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		for (int i = 0; i < 8; i++) {
			br.readLine();
		}
		temp = br.readLine();
		temp = temp.substring(8, 16);
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
	public double[] readlatlon(File file) throws IOException {
		String temp, lat, lon;
		double latint, lonint;
		FileInputStream fs = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		for (int i = 0; i < 7; i++) {
			br.readLine();
		}
		temp = br.readLine();
		temp = temp.substring(4);
		String[] parts = temp.split(";");
		lat = parts[0];
		lon = parts[1];
		latint = Double.parseDouble(lat);
		lonint = Double.parseDouble(lon);
		double[] geoinfo = {latint, lonint};
		br.close();
		return geoinfo;
	}
	public void sorttime() {
		mergesort stack = new mergesort();
		stack.sort(starttime, filename, size);
		starttime = stack.getarray();
		filename = stack.getfollow();
	}
	public boolean compdate(File file) throws IOException {
		int newval = readdate(file);
		//System.out.println(newval);
		if (newval == date) {
			return true;
		}
		else {
			return false;
		}
	}
	public double compgeo(int start) throws IOException {
		double Radius= 6372797.560856;
		File tfile = new File(filename[start]);
      	double[] set1 = readlatlon(tfile);
      	tfile = new File(filename[start+1]);
      	double[] set2 = readlatlon(tfile);
		double radLat1= Math.toRadians(set1[0]);
      	double radLat2= Math.toRadians(set2[0]);
      	double radLat= Math.toRadians((set2[0]-set1[0]));
      	double radLon= Math.toRadians((set2[1]-set1[1]));
      	double angle = Math.sin(radLat/2)*Math.sin(radLat/2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.sin(radLon/2)*Math.sin(radLon/2);
      	double distance = 2 * Math.asin(Math.sqrt(angle))*Radius;
      	distance = distance/1000;
      	return distance;
	}
	public void editICS() throws IOException {
		String file, ver, event, classif, distance = null, distmile = null, loc, geo, start, end;
		File reading;
		FileInputStream fs;
		BufferedReader br;
		for (int i = 0; i < size; i++) {
			file = filename[i];
			reading = new File(file);
			fs = new FileInputStream(reading);
			br = new BufferedReader(new InputStreamReader(fs));
			br.readLine();
			ver = br.readLine();
			br.readLine();
			event = br.readLine();
			classif = br.readLine();
			br.readLine();
			loc = br.readLine();
			geo = br.readLine();
			start = br.readLine();
			end = br.readLine();			
			br.close();
			if (i != size-1) {
				distance = String.valueOf(compgeo(i));
				distmile = String.valueOf(compgeo(i)*0.621371);
			}
			try 
			{
				File writingto = new File(file); //WRITES TO CURRENT DIRECTORY
				FileWriter fw = new FileWriter(writingto.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("BEGIN:VCALENDAR");
				bw.newLine();
				bw.write(ver);
				bw.newLine();
				bw.write("BEGIN:VEVENT");
				bw.newLine();
				bw.write(event);
				bw.newLine();
				bw.write(classif);
				bw.newLine();
				if (i != size-1) {
					bw.write("DESCRIPTION:" + distance + " km = " + distmile + " mi");
				}
				else {
					bw.write("DESCRIPTION:This is your last event of the day!");
				}
				bw.newLine();
				bw.write(loc);
				bw.newLine();
				bw.write(geo);
				bw.newLine();
				bw.write(start); // in GMT
				bw.newLine();
				bw.write(end); // in GMT
				bw.newLine();
				bw.write("TIMEZONE:Pacific/Honolulu"); //GMT -10:00
				bw.newLine();
				bw.write("END:VEVENT");
				bw.newLine();
				bw.write("END:VCALENDAR");
				bw.close();
				fw.close();
			}
			catch(IOException ioe)
			{
				System.out.println("ERROR: Could not open file due to Input/Output exception!");
			}
		}
	}
}




