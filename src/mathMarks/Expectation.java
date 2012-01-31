package mathMarks;

public class Expectation {
	private Course course;
	private String name;
	private String description;
	
	public Expectation(Course course, String name, String desc)
	{
		this.course = course;
		this.name = name;
		description = desc;
	}
	
	public Course getCourse()
	{
		return course;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescriptoin(String desc)
	{
		description = desc;
	}
}