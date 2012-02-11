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
		DatabaseAccess d = new DatabaseAccess(new File("database"));
		Course c = d.newCourse("ICS3U");
//		s.addMark(d.newClassroom("2012", true, "ICS3U-02"), new Mark(new Expectation(c,"exp 1","bla ba"),"4","good"));
		System.out.println(s.getAllMarks(d.newClassroom("2012", true, "ICS3U-02")).getFirst().getLevel());
		
		new MainFrame();
	}
}
