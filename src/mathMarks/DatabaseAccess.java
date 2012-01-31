package mathMarks;

import java.io.File;

public class DatabaseAccess {
	private File location;
	
	public DatabaseAccess(File location)
	{
		
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
		return null;
	}
	
	public Student newStudent(String id, String name, int grade)
	{
		return null;
	}
	
	public void deleteStudent(String id)
	{
		
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
