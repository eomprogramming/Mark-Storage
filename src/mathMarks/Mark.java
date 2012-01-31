package mathMarks;

public class Mark {
	private Expectation expect;
	private String comment;
	private String level;
	
	public Mark(Expectation expect, String level, String comment)
	{
		this.expect = expect;
		this.level = level;
		this.comment = comment;
	}
	
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
	
	public Expectation getExpectation()
	{
		return expect;
	}
	
	public String getLevel()
	{
		return level;
	}
	
	public String getComment()
	{
		return comment;
	}
	
	public void setComment(String comment)
	{
		this.comment = comment;
	}
	
	public void addComment(String comment)
	{
		this.comment += "\n" + comment;
	}
	
	public void setLevel(String level)
	{
		this.level = level;
	}
}
