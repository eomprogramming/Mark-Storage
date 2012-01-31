 package mathMarks;

import java.util.Calendar;
import java.util.LinkedList;

public class Classroom {
	private Course course;
	private LinkedList<Student> student;
	private int year;
	private boolean semesterOne;
	private String section;
	
	/**
	 * 
	 * @param course
	 * @param semester
	 * @param section
	 */
	public Classroom(Course course, boolean semester, String section)
	{
		this.course = course;
		this.semesterOne = semester;
		this.section = section;
		year = Calendar.getInstance().get(Calendar.YEAR);		
	}
	
	/**
	 * 
	 * @return
	 */
	public Student[] getStudent()
	{
		return (Student[]) student.toArray();
	}
	
	/**
	 * 
	 * @param student
	 */
	public void addStudent(Student student)
	{
		this.student.add(student);
	}
	
	/**
	 * 
	 * @param index
	 */
	public void removeStudent(int index)
	{
		student.remove(index);
	}
}
