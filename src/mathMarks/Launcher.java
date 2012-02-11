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
		Classroom c = new Classroom(new Course("ICS4U"),true,"03","2012");		
		c.saveStudentList();
		new MainFrame();
	}
}
