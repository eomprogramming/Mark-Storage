 package mathMarks;

import java.util.LinkedList;

public class Classroom {
	private Course course;
	private LinkedList<Student> student;
	private String year;
	private boolean semesterOne;
	private String section;
	
	/**
	 * 
	 * @param course
	 * @param semester
	 * @param section
	 */
	public Classroom(Course course, boolean semester, String section, String year)
	{
		this.course = course;
		this.semesterOne = semester;
		this.section = section;
		this.year = year;		
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
	
	public void saveClassList()
	{
		String path = getPath() + "class list.txt";
		IO.createOutputFile(path);
		for(int i = 0; i < student.size(); i++)
		{
			IO.println(student.get(i).getId());
		}
		IO.closeOutputFile();
	}
	
	public String getPath(){
		String path = DatabaseAccess.getLocation().getPath()+"\\" + year +" semester ";
		if(semesterOne)
			path+="1\\";
		else
			path+="2\\";
		
		path+=course.code+"-"+section;		
		return path;
	}
	
	public Course getCourse(){
		return course;
	}
}
