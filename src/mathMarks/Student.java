package mathMarks;

import java.util.HashMap;
import java.util.LinkedList;

import org.jdom.Element;

public class Student implements Recordable {
	private DatabaseAccess creator;
	private String id;
	private String name;
	private int grade;
	private HashMap<String,LinkedList<Mark>> marks;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param grade
	 */
	public Student(DatabaseAccess creator, String id, String name, int grade)
	{
		this.creator = creator;
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
		creator.markAsChanged(this);
	}
	
	/**
	 * 
	 */
	public void promoteGrade()
	{
		grade++;
		//TODO: Check for over-promotion?
		creator.markAsChanged(this);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**id
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
	
	public Mark[] getMarks(Course c)
	{
		try {
			return (Mark[]) marks.get(c.getCode()).toArray();
		} catch (NullPointerException e) {
			//TODO: Exception handling
			return null;
		}
	}
	
	public Mark[] getMarks(Course c, Expectation e)
	{
		LinkedList<Mark> results = new LinkedList<Mark>();		
		
		for (Mark m: marks.get(c.getCode())) {
			if (m.getExpectation() == e) {
				results.add(m);
			}
		}
		
		return (Mark[]) results.toArray();
	}
	
	public Mark[] getAllMarks() {
		LinkedList<Mark> result = new LinkedList<Mark>();
		
		for (LinkedList<Mark> m: marks.values()) {
			result.addAll(m);
		}
		
		return (Mark[]) result.toArray();
	}
	
	/**
	 * adds mark to the correct expectation file
	 * @param mark
	 */
	protected void addMark(Course c, Mark mark)
	{
		LinkedList<Mark> list = marks.get(c.getCode());
		if (list == null) {
			list = new LinkedList<Mark>();
			list.add(mark);
			marks.put(c.getCode(), list);
		} else {
			list.add(mark);
		}
		creator.markAsChanged(this);
	}
	
	/**
	 * removes the last mark for a certain expectation
	 * @param index
	 */
	public void removeMark(Course c, Mark m)
	{
		marks.get(c).remove(m);
		creator.markAsChanged(this);
	}

	@Override
	public Element serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
