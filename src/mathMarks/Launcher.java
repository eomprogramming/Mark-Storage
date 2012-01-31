package mathMarks;

import java.io.File;

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
		//The code to make folders
//		File file = new File("New Folder");
//		file.mkdirs();
		AccessData a = new AccessData(new File(""));
	//	a.chooseClassroom(null);
		new MainFrame();
	}
}
