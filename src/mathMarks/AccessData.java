package mathMarks;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AccessData {
	private File location;
	ArrayList<Student> students;
	Classroom classroom;
	
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
		try {
			JFileChooser choose = new JFileChooser();
			if(choose.showOpenDialog(f) == JFileChooser.APPROVE_OPTION) {
				String s = choose.getSelectedFile().getPath();
			}
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}
	
	public void removeCourse(String code)
	{
		
	}
	
	public void newClassroom(String id)
	{
		
	}
}
