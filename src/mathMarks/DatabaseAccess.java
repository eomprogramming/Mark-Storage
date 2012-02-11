package mathMarks;

import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class DatabaseAccess {
	public static File location;
	ArrayList<Student> students; //stores all students in the school, sorted by id
	
	/**
	 * 
	 * @param location
	 */
	public DatabaseAccess(File location)
	{
		this.setLocation(location);
	}
	
	/**
	 * 
	 * @return
	 */
	public DatabaseAccess getDefault()
	{
		return null;
	}
	
	/**
	 * 
	 * @param loc
	 * @return
	 */
	public DatabaseAccess getAccessForLocation(File loc)
	{
		return null;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudent(String id)
	{
		int a = findStudent(id, students.size(), 0);
		if(a >= 0)
			return students.get(a);
		return null;
	}
	
	/**
	 * 
	 * @param id
	 * @param top
	 * @param bot
	 * @return
	 */
	private int findStudent(String id, int top, int bot)
	{
		if(top < bot)
			return -1;
		int m = (top + bot)/2;
		
		if(id.compareTo(students.get(m).getId()) > 0)
			return findStudent(id, top, m+1);
		if(id.compareTo(students.get(m).getId()) < 0)
			return findStudent(id, m-1, bot);
		return m;
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param grade
	 * @return
	 */
	public Student newStudent(String id, String name, int grade)
	{
		Student nStudent = new Student(id, name, grade);
		students.add(nStudent);
		return nStudent;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void deleteStudent(String id)
	{
		int a = findStudent(id, students.size(), 0);
		if(a >= 0)
			students.remove(a);
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public Course getCourse(String code)
	{
		
		return new Course(code);
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public Course newCourse(String code)
	{
		return null;
	}
	
	/**
	 * 
	 * @param code
	 */
	public void removeCourse(String code)
	{
		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Classroom getClassroom(JFrame f)
	{
		String s="";
		try {
			JFileChooser choose = new JFileChooser();
			choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if(choose.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) {
				s = choose.getSelectedFile().getPath();
			}
		} catch (HeadlessException e1) {}
		
		try{
			String section =s.substring(s.length()-2, s.length());
			char slash = '\\';
			if(s.contains("/"))
				slash = '/';			
			
			String code = s.substring(s.lastIndexOf(slash)+1, s.lastIndexOf("-"));
			
			s = s.substring(0, s.lastIndexOf(slash));
			String year = s.substring(s.lastIndexOf(slash)+1,s.lastIndexOf(slash)+5);
			
			return new Classroom(new Course(code),s.endsWith("1"),section,year);
			
		}catch(Exception e){
			System.err.println("ERROR - Could not read Classroom.");
			return null;

		}
	}
	
	/**
	 * 
	 * @param courseCode Pass in "COURSE-O1" format
	 * @return
	 */
	public Classroom newClassroom(String year, boolean semesterOne, String courseCode)
	{
		String path = DatabaseAccess.getLocation().getPath()+"\\" + year +" semester ";
		if(semesterOne)
			path+="1\\";
		else
			path+="2\\";
		
		path+=courseCode;		
		File file = new File(path);		
		
		//Add time stamp
		Calendar cal = Calendar.getInstance();
		System.out.print("["+cal.getTime().toString().substring(0, cal.getTime().toString().length()-9)+"] ");
		
		System.out.println(file.getPath()+"  created.");
		file.mkdirs();		
		
		return new Classroom(new Course(courseCode.substring(0,courseCode.length()-3)),
			semesterOne,courseCode.substring(courseCode.length()-2, courseCode.length()),year);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void removeClassroom(String year, int semester, String courseCode)
	{
		
	}
	
	/**
	 * 
	 * @param id
	 */
	public void markAsChanged(Recordable id)
	{
		
	}
	
	/**
	 * 
	 */
	public void flushPartial()
	{
		
	}
	
	/**
	 * 
	 */
	public void flush()
	{
		
	}

	public static File getLocation() {
		if(location != null)
			return location;
		else
			return new File("database");
	}

	public static void setLocation(File location) {
		DatabaseAccess.location = location;
	}
}
