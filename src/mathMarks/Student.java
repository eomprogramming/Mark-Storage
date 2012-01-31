package mathMarks;

import java.util.LinkedList;

public class Student {
	private String id;
	private String name;
	private int grade;
	private LinkedList<Mark> marks;
	
	public Student(String id, String name, int grade)
	{
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	public void change(String name, int grade)
	{
		this.name = name;
		this.grade = grade;
	}
	
	public void promoteGrade()
	{
		//not sure how this works
	}
	
	public String getName()
	{
		return id;
	}
	
	public int getGrade()
	{
		return grade;
	}
	
	public Mark[] getMarks()
	{
		return (Mark[]) marks.toArray();
	}
	
	public void addMark(Mark mark)
	{
		marks.add(mark);
	}
	
	public void removeMark(int index)
	{
		marks.remove(index);
	}
}
