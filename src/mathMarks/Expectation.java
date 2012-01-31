package mathMarks;

public class Expectation {
	private Course course;
	private String name;
	private String description;
	
	/**
	 * 
	 * @param course
	 * @param name
	 * @param desc
	 */
	public Expectation(Course course, String name, String desc)
	{
		this.course = course;
		this.name = name;
		description = desc;
	}
	
	/**
	 * 
	 * @return
	 */
	public Course getCourse()
	{
		return course;
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
	public String getDescription()
	{
		return description;
	}
	
	/**
	 * 
	 * @param desc
	 */
	public void setDescriptoin(String desc)
	{
		description = desc;
	}
}
