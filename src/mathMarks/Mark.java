package mathMarks;

import java.util.Calendar;

import org.jdom.Element;

/**
 * Represents a Mark that was given to a Student in an Expectation.
 * Marks are immutable; instead of changing them, delete them with
 * {@link Student#removeMark(Course, Mark)} and create a new one.
 * @author Hao Wei
 * @author Aly Hassan
 * @author Ian Dewan
 */
public class Mark implements Recordable {
	private Expectation expect;
	private String comment;
	private String level;
	private Calendar date;
	
	/**
	 * Creates a new Mark with the given properties.
	 * @param student The Student who was given this Mark.
	 * @param expect The expectation that this Mark is for.
	 * @param level The actual level the Mark represents (<i>e.g.</i> 3+).
	 * @param comment A comment on the Mark.
	 * @param date The date the marks was given.
	 */
	public Mark(Student student, Expectation expect, String level, String comment,
			Calendar date)
	{
		this.expect = expect;
		this.level = level;
		this.comment = comment;
		this.date = date;
		student.addMark(expect.getCourse(), this);
	}
	
	/**
	 * Compare two mark levels (<i>e.g.</i> 4+ and 2-).
	 * @param a The first level.
	 * @param b The Second level.
	 * @return 1 if a &gt; b,<br/>
	 * 0 if a = b,<br/>
	 * -1 if a &lt; b
	 */
	public static int compareLevels(String a, String b)
	{
		a = a.trim();
		b = b.trim();
		
		if(a.substring(0, 1).compareTo(b.substring(0, 1)) > 0)
			return 1;
		if(a.substring(0, 1).compareTo(b.substring(0, 1)) < 0)
			return -1;
		if(a.length() == 2 && b.length() == 2)
		{
			if(a.substring(1, 2).compareTo(b.substring(1, 2)) < 0)
				return 1;
			if(a.substring(1, 2).compareTo(b.substring(1, 2)) > 0)
				return -1;
		}
		if(a.length() == 1 && b.length() == 2)
		{
			if(b.substring(1, 2).equals("+"))
				return -1;
			if(b.substring(1, 2).equals("-"))
				return 1;
		}
		if(a.length() == 2 && b.length() == 1)
		{
			if(a.substring(1, 2).equals("+"))
				return 1;
			if(a.substring(1, 2).equals("-"))
				return -1;
		}
		return 0;
	}
	
	/**
	 * Get the Expectation this Mark is for.
	 * @return The Expectation.
	 */
	public Expectation getExpectation()
	{
		return expect;
	}
	
	/**
	 * Get the level achieved.
	 * @return The level.
	 */
	public String getLevel()
	{
		return level;
	}
	
	/**
	 * Get the comment given.
	 * @return The comment.
	 */
	public String getComment()
	{
		return comment;
	}
	
	/**
	 * Get the date the Mark was given.
	 * @return The date.
	 */
	public Calendar getDate() {
		return date;
	}

	@Override
	public Element serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
