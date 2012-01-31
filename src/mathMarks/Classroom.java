 package mathMarks;

import java.util.Calendar;
import java.util.LinkedList;

public class Classroom {
	private Course course;
	private LinkedList<Student> student;
	private int year;
	private boolean semesterOne;
	private String section;
	
	public Classroom(Course course, boolean semester, String section)
	{
		this.course = course;
		this.semesterOne = semester;
		this.section = section;
		year = Calendar.getInstance().getWeekYear();
		
	}
	
	public Student[] getStudent()
	{
		return (Student[]) student.toArray();
	}
	
	public void addStudent(Student student)
	{
		this.student.add(student);
	}
	
	public void removeStudent(int index)
	{
		student.remove(index);
	}
}
