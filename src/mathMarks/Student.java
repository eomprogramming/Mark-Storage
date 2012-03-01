package mathMarks;

import java.util.HashMap;
import java.util.LinkedList;

import org.jdom.Element;

/**
 * Represents a Student recorded in the database.
 * @author Hao Wei
 * @author Aly Hassan
 * @author Ian Dewan
 */
public class Student implements Recordable {
	private DatabaseAccess creator;
	private String id;
	private String name;
	private int grade;
	private HashMap<String,LinkedList<Mark>> marks;
	
	/**
	 * Create a new Student. This method should only be called by DatabaseAccess
	 * subclasses.
	 * @param creator The DatabasAccess which manages this Student.
	 * @param id The Student's id.
	 * @param name The Student's name.
	 * @param grade The Student's grade (an int from 1-4).
	 * @see DatabaseAccess#newStudent(String, String, int)
	 */
	public Student(DatabaseAccess creator, String id, String name, int grade)
	{
		this.creator = creator;
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	/**
	 * Change some of the Student's information.
	 * @param name The new Student name.
	 * @param grade The new Student grade.
	 */
	public void change(String name, int grade)
	{
		this.name = name;
		this.grade = grade;
		creator.markAsChanged(this);
	}
	
	/**
	 * Promote the Student to the next grade (<i>i.e.</i> increment the grade).
	 */
	public void promoteGrade()
	{
		grade++;
		//TODO: Check for over-promotion?
		creator.markAsChanged(this);
	}
	
	/**
	 * Get the Student's name.
	 * @return The name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get the Student's student id.
	 * @return The id.
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * Get the Students grade.
	 * @return An int from 1-4 representing the grade.
	 */
	public int getGrade()
	{
		return grade;
	}
	
	/**
	 * Get an array of all the Marks the Student recieved in the given Course
	 * @param c The Course in question.
	 * @return An array of Marks, or null if no Marks have been given.
	 */
	public Mark[] getMarks(Course c)
	{
		try {
			return (Mark[]) marks.get(c.getCode()).toArray();
		} catch (NullPointerException e) {
			//TODO: Exception handling
			return null;
		}
	}
	
	/**
	 * Get an array of the Marks given to the Student in the given Course for the given
	 * Expectation.
	 * @param c The Course.
	 * @param e The Expectation.
	 * @return All of the marks for that Course and Expectation.
	 */
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
	
	/**
	 * Get an array of all Marks ever given to a Student.
	 * @return All Marks.
	 */
	public Mark[] getAllMarks() {
		LinkedList<Mark> result = new LinkedList<Mark>();
		
		for (LinkedList<Mark> m: marks.values()) {
			result.addAll(m);
		}
		
		return (Mark[]) result.toArray();
	}
	
	/**
	 * Give the Student a new Mark.
	 * @param mark The Mark to give.
	 * @param c The Course it was given in.
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
	 * Remove the given Mark
	 * @param m The Mark to remove.
	 * @param c The Course the Mark was given in.
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
