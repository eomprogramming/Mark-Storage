package mathMarks;

import gui.MainFrame;

import java.io.File;
import java.util.Calendar;

/**
 * What do you think it does? 
 * @author Aly
 *
 */
public class Launcher {
	
	/**
	 * runs the MainFrame
	 * @param args
	 */
	public static void main(String args[]){
		DatabaseAccess test = new DatabaseAccess(new File("database"));
		test.newClassroom("2012", true, "ICS3U-02");
		new MainFrame();
	}
}
