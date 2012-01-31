package mathMarks;

public class Mark {
	private Expectation expect;
	private String comment;
	private String level;
	
	/**
	 * 
	 * @param expect
	 * @param level
	 * @param comment
	 */
	public Mark(Expectation expect, String level, String comment)
	{
		this.expect = expect;
		this.level = level;
		this.comment = comment;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int compareLevels(String a, String b)
	{
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
	
	/**
	 * 
	 * @param comment
	 */
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	/**
	 * 
	 * @param comment
	 */
	public void addComment(String comment)
	{
		this.comment += "\n" + comment;
	}
	
	/**
	 * 
	 * @param level
	 */
	public void setLevel(String level)
	{
		this.level = level;
	}
}
