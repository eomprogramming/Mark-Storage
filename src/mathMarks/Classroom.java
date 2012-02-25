 package mathMarks;

import java.util.LinkedList;

import org.jdom.Element;

public class Classroom implements Recordable{
	private DatabaseAccess creator;
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
	protected Classroom(DatabaseAccess creator, Course course, int year,
			boolean semester, String section)
	{
		this.creator = creator;
		this.course = course;
		this.semesterOne = semester;
		this.section = section;
		this.year = year;		
	}
	
	public String getName() {
		return (course.getCode() + "-" + section);
	}
	
	/**
	 * 
	 * @return
	 */
	public Student[] getStudent()
	{
		return (Student[]) student.toArray();
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean getSemester() {
		return semesterOne;
	}
	
	/**
	 * 
	 * @param student
	 */
	public void addStudent(Student student)
	{
		this.student.add(student);
		creator.markAsChanged(this);
	}
	
	/**
	 * 
	 * @param index
	 */
	public void removeStudent(int index)
	{
		student.remove(index);
		creator.markAsChanged(this);
	}
	
	public Course getCourse(){
		return course;
	}

	@Override
	public Element serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
