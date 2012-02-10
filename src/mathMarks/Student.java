package mathMarks;

import java.util.LinkedList;

public class Student {
	private String id;
	private String name;
	private int grade;
	//private LinkedList<Mark> marks;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param grade
	 */
	public Student(String id, String name, int grade)
	{
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	/**
	 * 
	 * @param name
	 * @param grade
	 */
	public void change(String name, int grade)
	{
		this.name = name;
		this.grade = grade;
	}
	
	/**
	 * 
	 */
	public void promoteGrade()
	{
		//not sure how this works
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getGrade()
	{
		return grade;
	}
	
	/**
	 * 
	 * @return all marks for a given student
	 */
	public Mark[] getMarks(Classroom c)
	{
		return null;
	}
	
	/**
	 * adds mark to the correct expectatoin file
	 * @param mark
	 */
	public void addMark(Classroom c, Mark mark)
	{
		
	}
	
	/**
	 * removes the last mark for a certain expectation
	 * @param index
	 */
	public void removeMark(Classroom c, Expectation expectation)
	{
		
	}
}
