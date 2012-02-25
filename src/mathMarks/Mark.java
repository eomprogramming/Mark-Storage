package mathMarks;

import java.util.Calendar;

import org.jdom.Element;

public class Mark implements Recordable {
	private Expectation expect;
	private String comment;
	private String level;
	private Calendar date;
	
	/**
	 * 
	 * @param expect
	 * @param level
	 * @param comment
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
	 * 
	 * @param a
	 * @param b
	 * @return
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
	 * 
	 * @return
	 */
	public Expectation getExpectation()
	{
		return expect;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLevel()
	{
		return level;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getComment()
	{
		return comment;
	}
	
	public Calendar getDate() {
		return date;
	}

	@Override
	public Element serialize() {
		// TODO Auto-generated method stub
		return null;
	}
}
