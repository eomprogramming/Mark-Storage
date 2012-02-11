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
		Student s = new Student("S199","Aly",11);
		s.addMark(new DatabaseAccess(new File("database")).newClassroom("2012", true, "ICS3U-02"), new Mark(new Expectation(new Course("ICS3U-01"),"exp 1","bla ba"),"4","good"));
		
		new MainFrame();
	}
}
