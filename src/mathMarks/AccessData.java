package mathMarks;

import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class AccessData {
	private File location;
	private ArrayList<Student> students;
	private Classroom classroom;
	
	public AccessData(File l)
	{
		location = l;
	}
	
	public Student getStudent(String id)
	{
		int a = findStudent(id, students.size(), 0);
		if(a >= 0)
			return students.get(a);
		return null;
	}
	
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
	
	public Student newStudent(String id, String name, int grade)
	{
		Student nStudent = new Student(id, name, grade);
		students.add(nStudent);
		return nStudent;
	}
	
	public void deleteStudent(String id)
	{
		int a = findStudent(id, students.size(), 0);
		if(a >= 0)
			students.remove(a);
	}
	
	public Classroom chooseClassroom(JFrame f)
	{
		String s;
		try {
			JFileChooser choose = new JFileChooser();
			choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if(choose.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) {
				s = choose.getSelectedFile().getPath();
			}
		} catch (HeadlessException e1) {}
		
		int section = Integer.parseInt(s.substring(s.length()-2, s.length()));
		String course = s.substring(s., s.length(s.length()-2)
		
		Classroom c = new Classroom();
		
		return null;
	}
	
	public void removeCourse(String code)
	{
		
	}
	
	public void newClassroom(String id)
	{
		
	}
}
