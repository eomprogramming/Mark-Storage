package mathMarks;

import java.io.File;
import java.util.ArrayList;

public class DatabaseAccess {
	private File location;
	ArrayList<Student> students; //stores all students in the school, sorted by id
	
	
	public DatabaseAccess(File location)
	{
		this.location = location;
	}
	
	public DatabaseAccess getDefault()
	{
		return null;
	}
	
	public DatabaseAccess getAccessForLocation(File loc)
	{
		return null;
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
	
	public Course getCourse(String code)
	{
		return null;
	}
	
	public Course newCourse(String code)
	{
		return null;
	}
	
	public void removeCourse(String code)
	{
		
	}
	
	public Classroom getClassroom(String id)
	{
		return null;
	}
	
	public Classroom newClassroom(String id)
	{
		return null;
	}
	
	public void removeClassroom(String id)
	{
		
	}
	
	public void markAsChanged(Recordable id)
	{
		
	}
	
	public void flushPartial()
	{
		
	}
	
	public void flush()
	{
		
	}
}
