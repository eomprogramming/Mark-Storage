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
	
	public int compareLevels(String a, String b)
	{
		//not sure how this works..
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
		comment += "\n" + comment;
	}
	
	public void setLevel(String level)
	{
		this.level = level;
	}
}
